package com.grady.fim.server.pojo.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class MessageReqVo implements Serializable {

    private static final long serialVersionUID = 4244947900979337326L;

    // 发送者的用户id
    private String senderId;
    // 接受者的用户id
    private String receiverId;
    // 聊天内容
    private String msg;
}
