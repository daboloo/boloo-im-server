package com.grady.fim.server.utils;

import com.google.gson.Gson;
import com.grady.fim.server.enums.MsgType;
import com.grady.fim.server.pojo.res.WsContentRepVo;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChannelHolder {
    private static final Map<String, NioSocketChannel> CHANNEL_MAP = new ConcurrentHashMap<>(16);

    public static void put(String userId, NioSocketChannel channel) {
        CHANNEL_MAP.put(userId, channel);
    }

    public static NioSocketChannel get(String id) {
        return CHANNEL_MAP.get(id);
    }

    /**
     * 通知上线
     */
    public static void notifyOnline(String userId) {
        final WsContentRepVo wsContentRepVo = WsRepUtil.createWsContentRepVo(MsgType.ONLINE_TYPE.code, userId, userId);
        final Gson gson = new Gson();
        final TextWebSocketFrame frame = new TextWebSocketFrame(gson.toJson(wsContentRepVo));

        CHANNEL_MAP.forEach((key, channel) -> {
            if (!key.equals(userId)) {
                channel.writeAndFlush(frame);
            }
        });
    }
}

