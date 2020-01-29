package com.grady.fim.server.pojo.res;

import lombok.Data;

import java.io.Serializable;

@Data
public class MessageRepVo implements Serializable {

    private static final long serialVersionUID = 7586097784586464425L;

    // 发送者的用户id
    private String senderId;

    // 聊天内容
    private String msg;
}
