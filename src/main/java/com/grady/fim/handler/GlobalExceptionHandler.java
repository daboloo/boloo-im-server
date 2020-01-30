package com.grady.fim.handler;

import com.grady.fim.common.exception.BusinessException;
import com.grady.fim.common.pojo.bo.JsonResult;
import com.grady.fim.common.utils.ResultTool;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.grady.fim.common.pojo.enums.ResultCode.COMMON_FAIL;

@Log4j2
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理 BusinessException
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public JsonResult handleBusinessException(Exception e) {
        return ResultTool.fail(e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler
    public JsonResult handlerSeverException(Exception e) {
        log.error("Other Exception handler ", e);
        return ResultTool.fail(COMMON_FAIL);
    }
}
