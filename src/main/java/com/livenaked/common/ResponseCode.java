package com.livenaked.common;

public enum ResponseCode {
    SUCCESS(200, "SUCCESS"),
    REQUEST_TIME_OUT(500, "请求超时"),
    SYSTEM_ERROR(-100, "系统异常"),
    SIGN_INVALID(-101, "签名错误"),
    SERVICE_ERROR(-200, "业务异常"),
    PERMISSION_ERROR(-201, "权限不足"),
    LOGIN_TIMEOUT(-202, "登录超时"),
    PARAMETER_ERROR(-300, "参数缺失"),
    THRID_FAIL(-400, "第三方操作失败"),
    NOT_FOUND(-500, "NOT FOUND");
    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
