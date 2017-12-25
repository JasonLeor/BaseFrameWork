package com.livenaked.common.http.intercept;

import com.livenaked.common.ResponseCode;
import com.livenaked.common.exception.ServiceException;
import com.livenaked.common.tools.Utils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 请求时间检查
 */
@Component
public class TimeOutCheckInterceptor implements HandlerInterceptor {
    private static final long LIMIT = 300;

    private static final TimeUnit UNIT = TimeUnit.SECONDS;

    private static final String TIMEOUT_PARAM_FIELD = "timestamp";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Long requestTime;
        try {
            requestTime = Long.valueOf(request.getParameter(TIMEOUT_PARAM_FIELD));
        } catch (Exception e) {
            throw new ServiceException(ResponseCode.PARAMETER_ERROR);
        }

        Long serverTime = Utils.getTimestamp(UNIT);

        boolean isTimeout = Math.abs(serverTime - requestTime) > LIMIT;
        if (isTimeout) {
            throw new ServiceException(ResponseCode.REQUEST_TIME_OUT);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
