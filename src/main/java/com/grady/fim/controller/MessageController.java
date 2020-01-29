package com.grady.fim.controller;

import com.grady.fim.common.constants.ErrorCodes;
import com.grady.fim.common.exception.BusinessException;
import com.grady.fim.common.pojo.bo.JsonResult;
import com.grady.fim.common.pojo.req.P2PReqVo;
import com.grady.fim.common.pojo.req.UnreadMsgListRepVo;
import com.grady.fim.common.pojo.rsp.NullBody;
import com.grady.fim.common.utils.JwtTokenUtils;
import com.grady.fim.common.utils.ResultTool;
import com.grady.fim.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static com.grady.fim.common.constants.Constants.HEADER_AUTHORIZATION;

@Api(value = "/message")
@Log4j2
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @ApiOperation(value = "发送消息")
    @PostMapping(value = "/sendMsg")
    public JsonResult<NullBody> sendMsg(@RequestBody @Valid P2PReqVo p2pRequest) throws BusinessException {
        messageService.sendMsg(p2pRequest);
        return ResultTool.success();
    }

    @ApiOperation(value = "获取未读消息")
    @PostMapping(value = "/unreadMsg")
    public JsonResult<UnreadMsgListRepVo> getUnreadMsg(HttpServletRequest request) throws BusinessException {
        String username = JwtTokenUtils.getUsernameFromToken(request.getHeader(HEADER_AUTHORIZATION));
        if (username == null) {
            throw new BusinessException(ErrorCodes.ILLEGAL_ARGUMENT_CODE, "Authorization 非法");
        }
        return messageService.getUnreadMsg(username);
    }


}
