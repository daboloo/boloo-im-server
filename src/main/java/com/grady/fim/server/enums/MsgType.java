package com.grady.fim.server.enums;

/**
 * 消息类型
 */
public enum MsgType {

    CONNECT(1, "第一次(或重连)初始化连接"),

    CHAT(2, "聊天消息"),

    ONLINE_TYPE(3, "上线"),

    KEEPALIVE(4, "客户端保持心跳"),

    FRIEND_REQUEST(5, "好友请求");

    public final int code;

    public final String codeMsg;

    MsgType(int code, String codeMsg) {
        this.code = code;
        this.codeMsg = codeMsg;
    }
}
