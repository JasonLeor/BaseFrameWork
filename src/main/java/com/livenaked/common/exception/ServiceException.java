package com.livenaked.common.exception;

import com.livenaked.common.ResponseCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 业务异常
 */
@Getter
@Setter
public class ServiceException extends GlobalException {

    public ServiceException() {
        super.setCode(ResponseCode.SERVICE_ERROR.getCode());
        super.setMsg(ResponseCode.SERVICE_ERROR.getMsg());
    }

    public ServiceException(String msg) {
        super.setCode(ResponseCode.SERVICE_ERROR.getCode());
        super.setMsg(msg);
    }
}