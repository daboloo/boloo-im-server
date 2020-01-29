package com.grady.fim.server.utils;

import com.google.gson.Gson;
import com.grady.fim.common.pojo.bo.JsonResult;
import com.grady.fim.common.utils.ResultTool;
import com.grady.fim.server.enums.MsgType;
import com.grady.fim.server.pojo.req.MessageReqVo;
import com.grady.fim.server.pojo.res.MessageRepVo;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChannelHolder {
    private static final Map<String, NioSocketChannel> CHANNEL_MAP = new ConcurrentHashMap<>(16);

    private static final Map<String, String> USER_MAP = new ConcurrentHashMap<>(16);

    public static void put(String id, NioSocketChannel channel) {
        CHANNEL_MAP.put(id, channel);
    }

    public static NioSocketChannel get(String id) {
        return CHANNEL_MAP.get(id);
    }

    public static void saveUser(String id, String name) {
        USER_MAP.put(id, name);
    }

    /**
     * 通知上线
     */
    public static void notifyOnline(MessageReqVo messageReqVo) {
        CHANNEL_MAP.values().forEach(channel -> {
            Gson gson = new Gson();
            MessageRepVo repVo = new MessageRepVo();
            repVo.setMsgType(MsgType.ONLINE_TYPE.code);
            repVo.setSuccess(true);
            repVo.setMessage(messageReqVo.getUserId());
            JsonResult<MessageRepVo> response = ResultTool.success(repVo);
            channel.writeAndFlush(new TextWebSocketFrame(gson.toJson(response)));
        });
    }
}

