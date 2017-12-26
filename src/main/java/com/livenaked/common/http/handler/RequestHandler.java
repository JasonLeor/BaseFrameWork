package com.livenaked.common.http.handler;

import com.livenaked.common.http.converter.JsonConvert;
import com.livenaked.common.http.converter.StringConvert;
import com.livenaked.common.http.converter.XmlConverter;
import com.livenaked.common.http.intercept.FunctionInterceptor;
import com.livenaked.common.http.intercept.LoginInterceptor;
import com.livenaked.common.http.intercept.SignCheckInterceptor;
import com.livenaked.common.http.intercept.TimeOutCheckInterceptor;
import com.livenaked.common.tools.EnvUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * 请求 控制器
 */
@Configuration
@ComponentScan("com.livenaked")
public class RequestHandler extends WebMvcConfigurerAdapter {
    @Autowired
    private SignCheckInterceptor signTrueInterceptor;
    @Autowired
    private TimeOutCheckInterceptor timeOutCheckInterceptor;
    @Autowired
    private FunctionInterceptor functionInterceptor;
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Autowired
    private JsonConvert jsonConvert;
    @Autowired
    private XmlConverter xmlConverter;
    @Autowired
    private StringConvert stringConvert;


    /**
     * 拦截器执行顺序按添加顺序升序
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if (!EnvUtils.CURRENT_ENVIRONMENT.equals(EnvUtils.ENVIRONMENT.TEST)) {
            // 时间校验
            registry.addInterceptor(timeOutCheckInterceptor).addPathPatterns("/**");
            // 签名校验
            registry.addInterceptor(signTrueInterceptor).addPathPatterns("/**");
        }
        // 用户登录状态
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**/user/**");
        // 功能权限检查
        registry.addInterceptor(functionInterceptor).addPathPatterns("/**");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jsonConvert);
        converters.add(xmlConverter);
        converters.add(stringConvert);
    }
}
