package com.livenaked.common.http.filter;

import com.livenaked.common.Constants;
import com.livenaked.common.tools.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 日志追踪过滤器 (不得在过滤器中做 数据库操作)
 */
@Component
@WebFilter(filterName = "LogTraceFilter", urlPatterns = "/*")
public class LogTraceFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void destroy() {
        logger.debug("LogTraceFilter 销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // 插入日志追踪主键
        MDC.put(Constants.LOG_TRACE_PK_KEY, Utils.generateUUID());

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        logger.debug("LogTraceFilter 初始化");
    }
}
