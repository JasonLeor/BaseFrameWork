package com.livenaked.common;


import com.livenaked.common.annotation.IgnoreMark;

import java.lang.annotation.Annotation;

/**
 * 参数
 */
public class Constants {
    /**
     * 日志追踪主键
     */
    public static final String LOG_TRACE_PK_KEY = "requestId";
    /**
     * xml 响应结果 根节点名
     */
    public static final String XML_RESPONSE_ROOT_NAME = "xml";
    /**
     * response忽略处理标记
     */
    public static final Class<? extends Annotation> IGNORE_MARK_ANNOTATION = IgnoreMark.class;
    /**
     * user token
     */
    public static final String USER_LOGIN_TOKEN_FIELD = "token";
    public static final String[] JSONP_CALLBACK_FIELDS = new String[]{"callback", "jsonp"};
}
