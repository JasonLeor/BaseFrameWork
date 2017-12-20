package com.livenaked.common.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;

/**
 * 网络请求工具
 */
public class HttpUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    public static String doRequest(final HttpMethod method, final String url, final Map<String, String> headers, final String params, final String body) throws IOException {
        String requestUrl = url + ((params != null && !"".equals(params)) ? "?" + params : "");
        URL realUrl = new URL(requestUrl);
        HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();

        connection.setRequestMethod(method.name());
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("connection", "keep-alive");
        connection.setRequestProperty("Charset", "UTF-8");
        connection.setRequestProperty("Content-Type", "");

        // 添加 header
        if (headers != null) {
            Set<String> headerKeys = headers.keySet();
            for (String headerKey : headerKeys) {
                connection.setRequestProperty(headerKey, headers.get(headerKey));
            }
        }

        // requestBody
        if (body != null && !"".equals(body)) {
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(body.getBytes());
            outputStream.flush();
        }
        int responseCode = connection.getResponseCode();
        InputStream inputStream = connection.getInputStream();
        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);
            }
            return buffer.toString();
        } else {
            logger.error("网络请求异常: " + requestUrl + " header" + connection.getHeaderFields().toString() + "  body:" + body);
            return null;
        }
    }

    public static String doPost(final String url, final Map<String, String> params, final String body) {

        return null;
    }

    public static String doPost(final String url, final Map<String, String> params) {

        return null;
    }

    public static String doPost(final String url, final String params, final String body) {

        return null;
    }

    public static String doPost(final String url, final String params) {

        return null;
    }

    public static String doGet(final String url, final Map<String, String> params) {

        return null;
    }

    public static String doGet(final String url, final String params) {

        return null;
    }
}
