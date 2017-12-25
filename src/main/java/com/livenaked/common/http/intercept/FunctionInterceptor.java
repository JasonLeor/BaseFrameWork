package com.livenaked.common.http.intercept;

import com.livenaked.common.ResponseCode;
import com.livenaked.common.exception.ServiceException;
import com.livenaked.common.exception.SystemException;
import com.livenaked.entity.FunctionLevelEnum;
import com.livenaked.entity.FunctionStatusEnum;
import com.livenaked.model.PFunction;
import com.livenaked.service.intf.FunctionServiceIntf;
import com.livenaked.service.intf.UserFunctionServiceIntf;
import com.livenaked.service.intf.UserRoleServiceIntf;
import com.livenaked.service.intf.UserServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能状态&权限 拦截器
 * 1.判断功能状态
 * 2.判断功能权限
 * <p>
 * 该拦截器必须依赖在 LoginInterceptor 后面
 */
@Component
public class FunctionInterceptor implements HandlerInterceptor {
    @Autowired
    private FunctionServiceIntf functionService;
    @Autowired
    private UserServiceIntf userService;
    @Autowired
    private UserRoleServiceIntf userRoleService;
    @Autowired
    private UserFunctionServiceIntf userFunctionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String route = request.getRequestURI();
        PFunction function = functionService.findFunction(route);
        if (function != null) {
            // 检查 功能状态
            switch (FunctionStatusEnum.getByValue(function.getStatus())) {
                case DISABLED:
                    throw new SystemException(ResponseCode.SYSTEM_ERROR, "该功能已被禁用");
                case ENABLED:
                    break;
                case MAINTAINED:
                    throw new SystemException(ResponseCode.SYSTEM_ERROR, "该功能正在维护中,请稍后再试");
            }
            // 根据级别 进行过滤 PUBLIC | PRIVATE | DESIGNATED
            switch (FunctionLevelEnum.valueOf(function.getLevel())) {
                case PUBLIC: // 开放功能
                    break;
                case ROLE_PRIVATE: // 角色私有功能
                    if (!userRoleService.hasFunction(userService.getCurrentLoginUser().getUserId(), function.getId())) {
                        throw new ServiceException(ResponseCode.PERMISSION_ERROR);
                    }
                    break;
                case DESIGNATED: // 特定用户公共
                    if (!userFunctionService.hasFunction(userService.getCurrentLoginUser().getUserId(), function.getId())) {
                        throw new ServiceException(ResponseCode.PERMISSION_ERROR);
                    }
                    break;
            }
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
