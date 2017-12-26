package com.livenaked.service.intf;

import com.livenaked.model.PUser;

public interface UserServiceIntf {
    /**
     * 检查 登录状态
     *
     * @param token 授权标识
     */
    boolean checkLoginStatus(String token);

    /**
     * 获取 用户
     */
    PUser getUser(String token);

    /**
     * 获取当前登录 的 用户
     */
    PUser getCurrentLoginUser();

    /**
     * 查询用户
     *
     * @param userId 用户id
     */
    PUser findUser(String userId);
}
