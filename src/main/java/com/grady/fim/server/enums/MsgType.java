package com.grady.fim.server.enums;

/**
 * 消息类型
 */
public enum MsgType {

    LOGIN_TYPE(1001, "登录"),

    ONLINE_TYPE(1002, "上线"),

    CHAT_TYPE(1003, "聊天");

    public final int code;

    public final String codeMsg;

    MsgType(int code, String codeMsg) {
        this.code = code;
        this.codeMsg = codeMsg;
    }
}
