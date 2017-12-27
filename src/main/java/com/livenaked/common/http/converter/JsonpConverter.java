//package com.livenaked.common.http.converter;
//
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonpHttpMessageConverter4;
//import com.livenaked.common.annotation.HttpMessageConverter;
//import org.springframework.http.HttpInputMessage;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//
//import java.io.IOException;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * jsonp 转换器
// */
//@HttpMessageConverter
//public class JsonpConverter extends FastJsonpHttpMessageConverter4 {
//    public JsonpConverter() {
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.PrettyFormat,
//                SerializerFeature.WriteMapNullValue);
//        setFastJsonConfig(fastJsonConfig);
//
//        List<MediaType> supportedMediaTypes = new ArrayList<>();
//        supportedMediaTypes.add(MediaType.valueOf("*/*"));
//        setSupportedMediaTypes(supportedMediaTypes);
//    }
//
//    @Override
//    protected boolean supports(Class<?> paramClass) {
//        return super.supports(paramClass);
//    }
//
//    @Override
//    public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
//        return super.read(type, contextClass, inputMessage);
//    }
//
//}
