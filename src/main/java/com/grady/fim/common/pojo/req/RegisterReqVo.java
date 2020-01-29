package com.grady.fim.common.pojo.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 注册实体
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class RegisterReqVo implements Serializable {

    private String username;

    private String password;
}
