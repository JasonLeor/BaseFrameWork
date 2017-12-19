package com.livenaked.common.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * JSON 工具类
 */
public class JSONUtils {
    /**
     * 对象转 json 字符串
     *
     * @param object
     * @return
     */
    public static String toJSONString(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * JSON 字符串 转 JavaBean
     */
    public static Object toJavaObject(String jsonStr, Class classes) {
        return JSONObject.parseObject(jsonStr, classes);
    }

    /**
     * JSONArray 字符串 转 集合
     */
    public static List toArray(String jsonArrayStr, Class classes) {

        return JSONArray.parseArray(jsonArrayStr, classes);
    }

    /**
     * JSON字符串转Map
     *
     * @param jsonStr Json格式字符串
     */
    public static Map toMap(String jsonStr) {
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        Map map = new HashMap();
        Set<String> keys = jsonObject.keySet();
        for (String key : keys) {
            map.put(key, jsonObject.get(key));
        }
        return map;
    }
}
