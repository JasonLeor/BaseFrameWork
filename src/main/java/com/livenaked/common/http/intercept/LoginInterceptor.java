package com.livenaked.common.http.intercept;

import com.livenaked.common.ResponseCode;
import com.livenaked.common.exception.ServiceException;
import com.livenaked.common.tools.Utils;
import com.livenaked.service.intf.UserServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录判断
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserServiceIntf userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Integer s = Integer.valueOf(Utils.randomNumber(1));
        if (s % 2 == 0) {
            return true;
        } else {
            throw new ServiceException(ResponseCode.LOGIN_TIMEOUT);
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
