package com.livenaked.common.http.converter;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StringConvert extends StringHttpMessageConverter {
    @Override
    protected void writeInternal(String str, HttpOutputMessage outputMessage) throws IOException {
        super.writeInternal(str, outputMessage);
    }
}
