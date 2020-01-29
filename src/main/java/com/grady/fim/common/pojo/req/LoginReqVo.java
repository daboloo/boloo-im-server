package com.grady.fim.common.pojo.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 登录请求Vo
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class LoginReqVo implements Serializable {

    private static final long serialVersionUID = -8964031648095923069L;

    public LoginReqVo() {

    }

    public LoginReqVo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String username;

    private String password;
}
