package com.grady.fim.server.pojo.res;

import lombok.Data;

import java.io.Serializable;

@Data
public class WsContentRepVo implements Serializable {

    private static final long serialVersionUID = -3287319168323830478L;

    // 动作类型
    private Integer action;
    // 用户的聊天内容
    private MessageRepVo chatMsg;
    // 扩展字段
    private String extend;
}
