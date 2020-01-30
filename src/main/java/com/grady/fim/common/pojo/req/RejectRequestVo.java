package com.grady.fim.common.pojo.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class RejectRequestVo implements Serializable {

    private static final long serialVersionUID = -2000772498607191713L;

    /**
     * 拒绝的账号
     */
    private String rejectUserAccount;
}
