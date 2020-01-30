package com.grady.fim.common.pojo.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChatMessageReqVo implements Serializable {

    private static final long serialVersionUID = 3293840140836251344L;

    private String friendAccount;
}
