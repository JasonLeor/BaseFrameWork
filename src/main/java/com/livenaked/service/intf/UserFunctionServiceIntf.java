package com.livenaked.service.intf;

public interface UserFunctionServiceIntf {
    /**
     * 用户是否有 该功能的权限
     */
    boolean hasFunction(Long userId, Long functionId);
}
