package com.livenaked.common.http.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.alibaba.fastjson.support.spring.MappingFastJsonValue;
import com.livenaked.common.annotation.HttpMessageConverter;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * json转换器
 */
@HttpMessageConverter
public class JsonConverter extends FastJsonHttpMessageConverter4 {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    public JsonConverter() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue);
        setFastJsonConfig(fastJsonConfig);
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        setDefaultCharset(DEFAULT_CHARSET);
        setSupportedMediaTypes(supportedMediaTypes);

    }

    @Override
    protected void writeInternal(Object obj, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        // 对返回内容进行统一加密
        if (obj instanceof MappingFastJsonValue) {
            MappingFastJsonValue jsonpObject = (MappingFastJsonValue) obj;
            OutputStream out = outputMessage.getBody();
            String text = JSON.toJSONString(jsonpObject.getValue(), new SerializerFeature[0]);
            String jsonpText = jsonpObject.getJsonpFunction() + "(" + text + ")";
            byte[] bytes = jsonpText.getBytes(DEFAULT_CHARSET);
            out.write(bytes);
        } else {
            super.writeInternal(obj, type, outputMessage);
        }
    }
}
