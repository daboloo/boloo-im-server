package com.grady.fim.common.utils;

import com.grady.fim.common.pojo.bo.JsonResult;
import com.grady.fim.common.pojo.enums.ResultCode;

/**
 * @author gradyjiang
 * @Date 2020/1/2 - 下午5:56
 */
public class ResultTool {
    public static JsonResult success() {
        return new JsonResult(true);
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<T>(true, data);
    }

    public static JsonResult fail() {
        return new JsonResult(false);
    }

    public static JsonResult fail(ResultCode resultEnum) {
        return new JsonResult(false, resultEnum);
    }

    public static <T> JsonResult<T> fail(T data) {
        return new JsonResult<T>(false, data);
    }
}
