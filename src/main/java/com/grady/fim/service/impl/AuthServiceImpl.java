package com.grady.fim.service.impl;

import com.grady.fim.common.constants.ErrorCodes;
import com.grady.fim.common.exception.BusinessException;
import com.grady.fim.common.pojo.bo.JsonResult;
import com.grady.fim.common.pojo.model.User;
import com.grady.fim.common.utils.ResultTool;
import com.grady.fim.mapper.UserMapper;
import com.grady.fim.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public JsonResult<String> register(String username, String password) throws BusinessException {
        User user = userMapper.loadUserByUsername(username);
        if (user != null) {
            throw new BusinessException(ErrorCodes.ILLEGAL_ARGUMENT_CODE, "用户名重复");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String bCryptPassword = encoder.encode(password);
        userMapper.createUser(username, bCryptPassword);
        return ResultTool.success();
    }
}
