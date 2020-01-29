package com.grady.fim.server;

import com.google.gson.Gson;
import com.grady.fim.common.pojo.bo.JsonResult;
import com.grady.fim.common.pojo.req.P2PReqVo;
import com.grady.fim.common.utils.ResultTool;
import com.grady.fim.server.enums.MsgType;
import com.grady.fim.server.exception.ChatException;
import com.grady.fim.server.pojo.res.WsContentRepVo;
import com.grady.fim.server.utils.ChannelHolder;
import com.grady.fim.server.utils.WsRepUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;
import java.util.Optional;

@Log4j2
@Component
public class IMServer {

    private EventLoopGroup boss = new NioEventLoopGroup();
    private EventLoopGroup work = new NioEventLoopGroup();


    @Value("${fim.server.port}")
    private int nettyPort;

    /**
     * netty 服务启动
     * @throws InterruptedException
     */
    @PostConstruct
    public void serverStart() throws InterruptedException {
        ServerBootstrap bootstrap = new ServerBootstrap()
                .group(boss, work)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(nettyPort))
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(new IMServerInitializer());

        ChannelFuture future = bootstrap.bind().sync();
        if (future.isSuccess()) {
            log.info("fim server 启动成功");
        }
    }

    /**
     * 销毁
     */
    @PreDestroy
    public void destroy() {
        boss.shutdownGracefully().syncUninterruptibly();
        work.shutdownGracefully().syncUninterruptibly();
        log.info("关闭 fim server 成功");
    }

    public void sendMsg(P2PReqVo vo) throws ChatException {
        String dstUserId = vo.getDstUserId();
        String message = vo.getMsg();
        NioSocketChannel channel = Optional.ofNullable(ChannelHolder.get(dstUserId))
                .orElseThrow(() -> new ChatException( 9999, "客户端[" + dstUserId + "]不在线！"));

        WsContentRepVo wsContentRepVo = WsRepUtil.createWsContentRepVo(MsgType.CHAT.code, dstUserId, message);
        Gson gson = new Gson();
        channel.writeAndFlush(new TextWebSocketFrame(gson.toJson(wsContentRepVo)));
    }
}

