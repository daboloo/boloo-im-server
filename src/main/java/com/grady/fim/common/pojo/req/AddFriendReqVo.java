package com.grady.fim.common.pojo.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddFriendReqVo implements Serializable {

    private static final long serialVersionUID = -6948687315654535165L;

    private String friendAccount;
}
