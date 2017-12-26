package com.livenaked.service.intf;

public interface UserFunctionServiceIntf {
    /**
     * 用户是否有 该功能的权限
     */
    boolean hasFunction(String userId, Long functionId);
}
