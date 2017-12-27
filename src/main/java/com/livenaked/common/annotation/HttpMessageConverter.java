package com.livenaked.common.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 自定义转换器 注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface HttpMessageConverter {
}
