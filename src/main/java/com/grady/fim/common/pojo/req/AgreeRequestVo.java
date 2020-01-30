package com.grady.fim.common.pojo.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class AgreeRequestVo implements Serializable {

    private static final long serialVersionUID = -8535376142185129618L;

    /**
     * 同意的账号
     */
    private String agreeUserAccount;
}
