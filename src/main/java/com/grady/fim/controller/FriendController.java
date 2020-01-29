package com.grady.fim.controller;

import com.grady.fim.common.constants.ErrorCodes;
import com.grady.fim.common.exception.BusinessException;
import com.grady.fim.common.pojo.bo.JsonResult;
import com.grady.fim.common.pojo.rsp.FriendListRspVo;
import com.grady.fim.common.utils.JwtTokenUtils;
import com.grady.fim.service.FriendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.grady.fim.common.constants.Constants.HEADER_AUTHORIZATION;

@Api(value = "/friend")
@Log4j2
@RestController
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    FriendService friendService;

    @ApiOperation(value = "获取好友列表")
    @PostMapping("/getFriends")
    public JsonResult<FriendListRspVo> getFriendList(HttpServletRequest request) throws BusinessException {
        String username = JwtTokenUtils.getUsernameFromToken(request.getHeader(HEADER_AUTHORIZATION));
        if (username == null) {
            throw new BusinessException(ErrorCodes.ILLEGAL_ARGUMENT_CODE, "Authorization 非法");
        }
        return friendService.getFriendList(username);
    }
}
