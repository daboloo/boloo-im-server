package com.grady.fim.controller;


import com.grady.fim.common.exception.BusinessException;
import com.grady.fim.common.pojo.bo.JsonResult;
import com.grady.fim.common.pojo.req.LoginReqVo;
import com.grady.fim.common.pojo.req.RegisterReqVo;
import com.grady.fim.common.utils.ResultTool;
import com.grady.fim.common.utils.SecurityUtils;
import com.grady.fim.config.security.JwtAuthenticationToken;
import com.grady.fim.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(value = "/auth")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public JsonResult<String> login(@RequestBody LoginReqVo vo, HttpServletRequest request) {
        String username = vo.getUsername();
        String password = vo.getPassword();
        // 系统登录认证
        JwtAuthenticationToken token = SecurityUtils.login(request, username, password, authenticationManager);
        return ResultTool.success(token.getToken());
    }

    @ApiOperation(value = "注册")
    @PostMapping("/register")
    public JsonResult<String> register(@RequestBody RegisterReqVo vo) throws BusinessException {
        String username = vo.getUsername();
        String password = vo.getPassword();
        return authService.register(username, password);
    }
}
