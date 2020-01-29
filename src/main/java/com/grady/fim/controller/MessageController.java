package com.grady.fim.controller;

import com.grady.fim.common.exception.BusinessException;
import com.grady.fim.common.pojo.bo.JsonResult;
import com.grady.fim.common.pojo.req.P2PReqVo;
import com.grady.fim.common.pojo.rsp.NullBody;
import com.grady.fim.common.utils.ResultTool;
import com.grady.fim.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "/message")
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @ApiOperation(value = "发送消息")
    @PostMapping(value = "/sendMsg")
    public JsonResult<NullBody> sendMsg(@RequestBody @Valid P2PReqVo p2pRequest) {
        try {
            System.out.println("接收到消息：" + p2pRequest);
            messageService.sendMsg(p2pRequest);
            return ResultTool.success();
        } catch (BusinessException be) {
            return ResultTool.fail();
        }
    }

}
