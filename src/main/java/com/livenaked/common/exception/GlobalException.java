package com.livenaked.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GlobalException extends RuntimeException {
    private Integer code;
    private String msg;
}
