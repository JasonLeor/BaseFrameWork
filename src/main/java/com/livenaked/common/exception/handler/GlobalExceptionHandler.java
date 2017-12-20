package com.livenaked.common.exception.handler;

import com.livenaked.common.ResponseCode;
import com.livenaked.common.exception.ServiceException;
import com.livenaked.common.exception.SystemException;
import com.livenaked.common.http.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 业务异常控制器
     */
    @ExceptionHandler(ServiceException.class)
    public Response handlerServiceException(ServiceException e) {
        logger.error("---- 捕获业务异常");
        return new Response(e);
    }

    /**
     * 系统异常控制器
     */
    @ExceptionHandler(SystemException.class)
    public Response handlerSystemException(SystemException e) {
        logger.error("---- 捕获系统异常");
        return new Response(e);
    }

    /**
     * 其他异常捕获
     */
    @ExceptionHandler(Exception.class)
    public Response handlerOtherException(Exception e) {
        logger.error("---- 捕获系统异常");
        return new Response(ResponseCode.SYSTEM_ERROR);
    }
}
