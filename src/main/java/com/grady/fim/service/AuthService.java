package com.grady.fim.service;

import com.grady.fim.common.exception.BusinessException;
import com.grady.fim.common.pojo.bo.JsonResult;

/**
 * 权限相关Service
 */
public interface AuthService {

    /**
     * 注册接口
     * @param username
     * @param password
     * @return
     */
    JsonResult<String> register(String username, String password) throws BusinessException;
}
