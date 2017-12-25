package com.livenaked.common.exception;

import com.livenaked.common.ResponseCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统异常
 */
@Getter
@Setter
public class SystemException extends GlobalException {
    public SystemException() {
        super.setCode(ResponseCode.SYSTEM_ERROR.getCode());
        super.setMsg(ResponseCode.SYSTEM_ERROR.getMsg());
    }

    public SystemException(String msg) {
        super.setCode(ResponseCode.SYSTEM_ERROR.getCode());
        super.setMsg(msg);
    }

    public SystemException(ResponseCode responseCode) {
        this.setCode(responseCode.getCode());
        this.setMsg(responseCode.getMsg());
    }

    public SystemException(ResponseCode responseCode, String message) {
        this.setCode(responseCode.getCode());
        this.setMsg(message);
    }
}
