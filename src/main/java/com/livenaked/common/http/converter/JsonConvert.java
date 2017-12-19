package com.livenaked.common.http.converter;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JsonConvert extends FastJsonHttpMessageConverter4 {

    public JsonConvert() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        setFastJsonConfig(fastJsonConfig);
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        setSupportedMediaTypes(supportedMediaTypes);

    }
}
