package com.grady.fim.server.handler;

import com.google.gson.Gson;
import com.grady.fim.server.enums.MsgType;
import com.grady.fim.server.pojo.req.WsContentReqVo;
import com.grady.fim.server.utils.ChannelHolder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.log4j.Log4j2;

import java.util.Optional;

/**
 * 处理聊天消息的handler
 */
@Log4j2
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static ChannelGroup users = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame frame) throws Exception {
        String text = Optional.ofNullable(frame.text()).orElse("") ;
        Channel currentChannel = ctx.channel();
        handleChannelRead(currentChannel, text);
    }

    private void handleChannelRead(Channel channel, String text) {
        Gson gson = new Gson();
        WsContentReqVo vo = gson.fromJson(text, WsContentReqVo.class);
        Integer action = vo.getAction();

        if (action == MsgType.CONNECT.code) {
            String senderId = vo.getChatMsg().getSenderId();
            ChannelHolder.put(senderId, (NioSocketChannel)channel);
            ChannelHolder.notifyOnline(senderId);
            log.info(senderId + " 上线了");
        }
        else if (action == MsgType.KEEPALIVE.code) {
            log.info("收到来自channel为[" + channel + "]的心跳包...");
        }
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        users.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        String channelId = ctx.channel().id().asShortText();
        users.remove(ctx.channel());
        log.info("客户端被移除，channelId为：" + channelId);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info(cause);
        ctx.channel().close();
        users.remove(ctx.channel());
    }
}
