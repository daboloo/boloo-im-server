package com.grady.fim.server.pojo.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class MessageReqVo implements Serializable {

    private int msgType;

    private String userId;

    private String userName;
}
