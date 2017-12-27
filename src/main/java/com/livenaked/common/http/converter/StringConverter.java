package com.livenaked.common.http.converter;

import com.livenaked.common.annotation.HttpMessageConverter;
import com.livenaked.common.tools.JSONUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 其他 转换器
 */
@HttpMessageConverter
public class StringConverter extends AbstractHttpMessageConverter<Object> {
    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    public StringConverter() {
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.ALL);
        setSupportedMediaTypes(supportedMediaTypes);
        setDefaultCharset(DEFAULT_CHARSET);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        byte[] bytes;
        if (o instanceof String) {
            bytes = ((String) o).getBytes();
        } else {
            bytes = JSONUtils.toJSONString(o).getBytes();
        }
        outputMessage.getBody().write(bytes);
    }
}
