package com.grady.fim.controller;

import com.grady.fim.common.pojo.bo.JsonResult;
import com.grady.fim.common.utils.ResultTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gradyjiang
 * @Date 2020/1/6 - 上午11:35
 */
@Api(value = "/hello")
@RestController
@RequestMapping("/hello")
public class HelloController {

    @ApiOperation(value = "测试接口")
    @GetMapping("/test")
    public JsonResult<String> test() {
        return ResultTool.success("hello test");
    }
}
