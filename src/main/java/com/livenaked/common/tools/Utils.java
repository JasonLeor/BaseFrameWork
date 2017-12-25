package com.livenaked.common.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 工具类
 */
public class Utils {
    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 通过经纬度获取距离(单位：米)
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    public static double getDistance(double lat1, double lng1, double lat2,
                                     double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        return s * 1000d;
    }

    public static String urlEncode(String str, String charset) {
        try {
            return URLEncoder.encode(str, charset);
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    /**
     * 对象数组 转 对象
     * 数组数据 必须 与对象成员顺序类型对应
     *
     * @param objects 对象数组
     * @param clazz   javaBean
     * @return bean
     */
    public static Object Objects2Bean(Object[] objects, Class clazz) {
        try {
            Object obj = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < objects.length; i++) {
                String fieldName = fields[i].getName();
                Method method = clazz.getMethod("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), objects[i].getClass());
                method.invoke(obj, objects[i]);
            }
            return obj;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * md5 加密
     */
    public static String md5Encoding(String str) {
        StringBuilder sb = new StringBuilder(32);
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(str.getBytes("utf-8"));

            for (int i = 0; i < array.length; i++) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).toUpperCase().substring(1, 3));
            }
        } catch (Exception e) {
            return null;
        }
        return sb.toString();
    }

    /**
     * 获得时间 hh:mm:ss
     */
    public static String getClock(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return localDateTime.format(formatter);
    }

    /**
     * 获得时间 hh:mm:ss
     */
    public static String getClock() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    /**
     * 获得日期 yyyy-MM-dd
     */
    public static String getDate(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return localDateTime.format(formatter);
    }

    /**
     * 获得日期 yyyy-MM-dd
     */
    public static String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDateTime.now().format(formatter);
    }

    /**
     * 获得时间 yyyy-MM-dd HH:mm:ss
     */
    public static String getTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }

    /**
     * 获得时间 yyyy-MM-dd HH:mm:ss
     */
    public static String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    public static String getTime(LocalDateTime localDateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDateTime.format(formatter);
    }

    /**
     * 获得整型时间戳
     */
    public static Long getTimestamp(LocalDateTime localDateTime, TimeUnit unit) {

        return null;
    }

    /**
     * 获得整型时间戳
     */
    public static Long getTimestamp(TimeUnit unit) {
        long timestamp = Calendar.getInstance().getTimeInMillis();
        if (unit.equals(TimeUnit.SECONDS)) {
            timestamp = timestamp / 1000;
        }
        return timestamp;
    }

    /**
     * 获取将来时间
     *
     * @param m    数值
     * @param unit 单位
     * @return 将来时间
     */
    public static LocalDateTime afterDateTime(Long m, ChronoUnit unit) {
        return LocalDateTime.now().plus(m, unit);
    }

    /**
     * 获取指定时间的将来时间
     *
     * @param dateTime 指定的时间
     * @param m        数值
     * @param unit     单位
     * @return 将来时间
     */
    public static LocalDateTime afterDateTime(LocalDateTime dateTime, Long m, ChronoUnit unit) {
        return dateTime.plus(m, unit);
    }

    /**
     * 获取过去时间
     *
     * @param m    数值
     * @param unit 单位
     * @return 过去时间
     */
    public static LocalDateTime beforDateTime(Long m, ChronoUnit unit) {
        return LocalDateTime.now().minus(m, unit);
    }

    /**
     * 获取指定时间的过去时间
     *
     * @param dateTime 指定的时间
     * @param m        数值
     * @param unit     单位
     * @return 过去时间
     */
    public static LocalDateTime beforDateTime(LocalDateTime dateTime, Long m, ChronoUnit unit) {
        return dateTime.minus(m, unit);
    }

    /**
     * 获取两个指定时间相差的 分钟数
     *
     * @param dateTime1 时间1
     * @param dateTime2 时间2
     * @return 分钟数
     */
    public static Long getDateTimeDifferMinute(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        long minute1 = Timestamp.valueOf(dateTime1).getTime() / 1000L;
        long minute2 = Timestamp.valueOf(dateTime2).getTime() / 1000L;
        long differ = Math.abs(minute1 - minute2);
        return differ / 60;
    }

    /**
     * 随机 数字
     *
     * @param length 随机数长度
     * @return 随机串
     */
    public static String randomNumber(int length) {
        String a[] = new String[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = String.valueOf((int) (10 * (Math.random())));
        }
        return String.join("", a);
    }

    /**
     * 生成订单号
     *
     * @param length 订单号长度
     * @return 订单号
     */
    public static String generateOrderNo(int length) {
        String timestamp = String.valueOf(getTimestamp(TimeUnit.MILLISECONDS));
        String orderNo = "";
        if (length > timestamp.length()) {
            orderNo = timestamp + randomNumber(length - timestamp.length());
        } else if (length > 0 & length < timestamp.length()) {
            orderNo = randomNumber(length);
        }
        return orderNo;
    }

    /**
     * 生成订单号
     *
     * @param length 订单号长度
     * @return 订单号
     */
    public static String generateOrderNo(String head, int length) {
        if (!StringUtils.isEmpty(head)) {
            length = length - head.length();
        }
        String orderNo = generateOrderNo(length);
        return String.format("%s%s", head, orderNo);
    }

    /**
     * 随机 字符串
     *
     * @param head   随机串的头
     * @param length 长度
     * @return 随机串
     */
    public static String randomString(String head, int length) {

        return head;
    }

    /**
     * map转键值对
     */
    public static String map2Pairs(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        ArrayList keys = new ArrayList<>(map.keySet());
        for (int i = 0; i < keys.size(); i++) {
            sb.append(String.format("%s=%s", keys.get(i), map.get(keys.get(i).toString())));
            if (i < keys.size() - 1) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

    public static Map<String, String> getJSONMap(Object obj) {
        JSONObject json = JSON.parseObject(JSON.toJSONString(obj));
        TreeMap<String, String> treeMap = new TreeMap<>();
        Set<String> keySet = json.keySet();
        for (String key : keySet) {
            treeMap.put(key, json.getString(key).trim());
        }
        return treeMap;
    }

    public static String UrlEncodeValue(String str, String charset) {
        try {
            if (StringUtils.isEmpty(str)) {
                return str;
            } else {
                return URLEncoder.encode(str, charset);
            }
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    /**
     * 字符转码
     *
     * @param str
     * @param charset
     * @return
     */
    public static String getString(String str, String charset) {
        try {
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            return new String(str.getBytes(), charset);
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    /**
     * 计算签名
     *
     * @param map 参数
     * @param key 加密关键字
     * @return 加密串
     */
    public static String generateSign(Map<String, String> map, String key) {
        Set<String> keySet = map.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (k.equals("sign")) {
                continue;
            }
            if (map.get(k).trim().length() > 0) // 参数值为空，则不参与签名
                sb.append(k).append("=").append(map.get(k)).append("&");
        }
        sb.append("key=").append(key);

        return md5Encoding(sb.toString());
    }

    /**
     * 生成UUID
     *
     * @return uuid
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public static boolean isEmptyByCollection(Collection collection) {
        return (collection == null || collection.size() <= 0);
    }

    public static boolean isEmpty(String string) {
        return (string == null || "".equals(string));
    }
}
