package com.livenaked.common.http.converter;

import com.livenaked.common.annotation.HttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * xml 格式转换器
 */
@HttpMessageConverter
public class XmlConverter extends Jaxb2RootElementHttpMessageConverter {

    public XmlConverter() {
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        setDefaultCharset(Charset.forName("UTF-8"));
        supportedMediaTypes.add(MediaType.APPLICATION_XML);
        supportedMediaTypes.add(MediaType.TEXT_XML);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        setSupportedMediaTypes(supportedMediaTypes);
        setProcessExternalEntities(false);
    }

}
