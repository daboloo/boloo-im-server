package com.grady.fim.server.pojo.res;

import lombok.Data;

import java.io.Serializable;

@Data
public class MessageRepVo implements Serializable {

    private int msgType;

    private boolean success;

    private String message;
}
