package com.grady.fim.server.pojo.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class WsContentReqVo implements Serializable {


    private static final long serialVersionUID = 4774072352033935091L;

    // 动作类型
    private Integer action;
    // 用户的聊天内容
    private MessageReqVo chatMsg;
    // 扩展字段
    private String extend;
}
