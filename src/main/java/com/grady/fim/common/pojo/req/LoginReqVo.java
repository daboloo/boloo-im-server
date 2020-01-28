package com.grady.fim.common.pojo.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 登录请求Vo
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class LoginReqVo extends BaseRequest {

    private String username;

    private String password;
}
