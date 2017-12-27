package com.livenaked.common.http.handler;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.alibaba.fastjson.support.spring.FastJsonpResponseBodyAdvice;
import com.alibaba.fastjson.support.spring.MappingFastJsonValue;
import com.livenaked.common.Constants;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Order(2)
@RestControllerAdvice(basePackages = "com.livenaked")
public class JsonpResponseHandler extends FastJsonpResponseBodyAdvice {

    public JsonpResponseHandler() {
        super(Constants.JSONP_CALLBACK_FIELDS);
    }

    @Override
    public void beforeBodyWriteInternal(MappingFastJsonValue bodyContainer, MediaType contentType, MethodParameter returnType, ServerHttpRequest request, ServerHttpResponse response) {
        HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
        for (String field : Constants.JSONP_CALLBACK_FIELDS) {
            String value = servletRequest.getParameter(field);
            if (value != null) {
                MediaType contentTypeToUse = getContentType(contentType, request, response);
                response.getHeaders().setContentType(contentTypeToUse);
                bodyContainer.setJsonpFunction(value);
                return;
            }
        }
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return FastJsonHttpMessageConverter4.class.isAssignableFrom(converterType);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
        for (String field : Constants.JSONP_CALLBACK_FIELDS) {
            if (!ObjectUtils.isEmpty(servletRequest.getParameter(field))) {
                return super.beforeBodyWrite(body, returnType, selectedContentType, selectedConverterType, request, response);
            }
        }
        return body;
    }


}
