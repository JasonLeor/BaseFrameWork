package com.livenaked.common.annotation;

import java.lang.annotation.*;

/**
 * API 标记
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface IgnoreMark {
}
