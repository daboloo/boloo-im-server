package com.grady.fim.server.handler;

import com.google.gson.Gson;
import com.grady.fim.common.pojo.bo.JsonResult;
import com.grady.fim.common.utils.ResultTool;
import com.grady.fim.server.enums.MsgType;
import com.grady.fim.server.pojo.req.MessageReqVo;
import com.grady.fim.server.pojo.res.MessageRepVo;
import com.grady.fim.server.utils.ChannelHolder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;
import lombok.extern.log4j.Log4j2;

import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

@Log4j2
public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object> {


    private static final String WEBSOCKET = "websocket";

    private static final String UPGRADE = "Upgrade";

    private WebSocketServerHandshaker handshaker;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof FullHttpRequest) {
            handleHttpRequest(ctx, (FullHttpRequest)msg);
        }
        else if (msg instanceof WebSocketFrame) {
            handleWebSocketFrame(ctx, (WebSocketFrame)msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) {
        if (req.decoderResult().isFailure()
                || !WEBSOCKET.equals(req.headers().get(UPGRADE))) {
            sendHttpResponse(ctx, req, new DefaultFullHttpResponse(HTTP_1_1, BAD_REQUEST));
            return;
        }

        //构造握手响应返回
        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(
                "ws://localhost:8080/websocket", null, false);

        handshaker = wsFactory.newHandshaker(req);
        if (handshaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
        }
        else {
            handshaker.handshake(ctx.channel(), req);
        }
    }

    private static void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, FullHttpResponse res) {
        if (res.status().code() != 200) {
            ByteBuf buf = Unpooled.copiedBuffer(res.status().toString(), CharsetUtil.UTF_8);
            res.content().writeBytes(buf);
            buf.release();
            HttpUtil.setContentLength(res, res.content().readableBytes());
        }

        // 如果是非Keep-Alive，关闭连接
        ChannelFuture f = ctx.channel().writeAndFlush(res);
        if (!HttpUtil.isKeepAlive(req) || res.status().code() != 200) {
            f.addListener(ChannelFutureListener.CLOSE);
        }
    }

    private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
        if (frame instanceof CloseWebSocketFrame) {
            handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
            return;
        }
        if (frame instanceof PingWebSocketFrame) {
            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
            return;
        }
        // 暂支持文本消息，不支持二进制消息
        if (!(frame instanceof TextWebSocketFrame)) {
            throw new UnsupportedOperationException(String.format(
                    "%s frame types not supported", frame.getClass().getName()));
        }
        handleTextWebSocketFrame(ctx, (TextWebSocketFrame)frame);
    }

    private void handleTextWebSocketFrame(ChannelHandlerContext ctx, TextWebSocketFrame frame) {
        String requestText = frame.text();
        Gson gson = new Gson();
        MessageReqVo messageReqVo = gson.fromJson(requestText, MessageReqVo.class);
        if (messageReqVo.getMsgType() == MsgType.LOGIN_TYPE.code) {
            MessageRepVo repVo = new MessageRepVo();
            repVo.setMsgType(MsgType.LOGIN_TYPE.code);
            repVo.setSuccess(true);
            JsonResult<MessageRepVo> response = ResultTool.success(repVo);
            ctx.channel().writeAndFlush(new TextWebSocketFrame(gson.toJson(response)));
            synchronized (this) {
                // 通知其他用户 该id用户上线
                ChannelHolder.notifyOnline(messageReqVo);
                ChannelHolder.put(messageReqVo.getUserId(), (NioSocketChannel)ctx.channel());
                ChannelHolder.saveUser(messageReqVo.getUserId(), messageReqVo.getUserName());
                log.info(messageReqVo.getUserName() + " 上线了");
            }
        }
    }
}
