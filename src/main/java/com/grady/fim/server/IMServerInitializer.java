package com.grady.fim.server;

import com.grady.fim.server.handler.WebSocketServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

public class IMServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline()
                // 编解码 http 请求
                .addLast("http-codec", new HttpServerCodec())
                // 写文件内容 向客户端发送HTML5文件
                .addLast("http-chunked", new ChunkedWriteHandler())
                // 聚合解码 HttpRequest/HttpContent/LastHttpContent 到 FullHttpRequest
                // 将HTTP消息的多个部分合成一条完整的HTTP消息
                // 保证接收的 Http 请求的完整性
                .addLast("aggregator", new HttpObjectAggregator(64*1024))
                .addLast("handler", new WebSocketServerHandler());
    }
}
