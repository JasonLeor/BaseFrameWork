package com.livenaked.common.http.intercept;

import com.livenaked.common.tools.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 签名验证插件
 */
@Component
public class SignCheckInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //check sign
        String clientSign = request.getParameter("sign");
        Map params = getParams(request);
        String serverSign = Utils.generateSign(params, "");
        logger.info(serverSign + "====" + clientSign);
        logger.info(params.toString());
        if (!serverSign.equals(clientSign)) {
//            throw new ServiceException(ResponseCode.SIGN_INVALID);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    private Map getParams(HttpServletRequest request) {
        Enumeration<String> parameterNames = request.getParameterNames();
        Map map = new HashMap();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            if (!"sign".equals(name)) {
                map.put(name, request.getParameter(name));
            }
        }
        return map;
    }
}
