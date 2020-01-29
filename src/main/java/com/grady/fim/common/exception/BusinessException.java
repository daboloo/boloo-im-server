package com.grady.fim.common.exception;

public class BusinessException extends Exception {

    private static final long serialVersionUID = -4229150497117416212L;
    private String code;

    private String msg;

    public BusinessException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}