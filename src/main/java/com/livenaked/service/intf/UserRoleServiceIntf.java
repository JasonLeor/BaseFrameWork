package com.livenaked.service.intf;

public interface UserRoleServiceIntf {
    /**
     * 用户的角色是否有该 功能权限
     *
     * @param userId     用户id
     * @param functionId 权限 id
     */
    boolean hasFunction(Long userId, Long functionId);
}
