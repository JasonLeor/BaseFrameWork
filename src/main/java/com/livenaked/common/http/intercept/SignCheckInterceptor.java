package com.livenaked.common.http.intercept;

import com.livenaked.common.ResponseCode;
import com.livenaked.common.exception.ServiceException;
import com.livenaked.common.tools.Utils;
import com.livenaked.service.intf.UserServiceIntf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
 * <p>
 * 若用户已登录 取用户 secretKey 做 签名验证
 * 若用户未登录 则不加 secretKey 做 签名验证
 */
@Component
public class SignCheckInterceptor implements HandlerInterceptor {
    @Autowired
    private UserServiceIntf userService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String SIGN_PARAM_FIELD = "sign";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //check sign
        String clientSign = request.getParameter(SIGN_PARAM_FIELD);
        if (Utils.isEmpty(clientSign)) {
            throw new ServiceException(ResponseCode.PARAMETER_ERROR);
        }
        Map<String, String> params = getParams(request);
        String secretKey = "";
//        用户秘钥验签
//        PUser currentLoginUser = userService.getCurrentLoginUser();
//        if (currentLoginUser != null && !Utils.isEmpty(currentLoginUser.getSecretKey())) {
//            secretKey = currentLoginUser.getSecretKey();
//        }
        String serverSign = Utils.generateSign(params, secretKey);
        if (!serverSign.equals(clientSign)) {
            throw new ServiceException(ResponseCode.SIGN_INVALID);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    private Map<String, String> getParams(HttpServletRequest request) {
        Enumeration<String> parameterNames = request.getParameterNames();
        Map<String, String> map = new HashMap<>();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            if (!"sign".equals(name)) {
                map.put(name, request.getParameter(name));
            }
        }
        return map;
    }
}
