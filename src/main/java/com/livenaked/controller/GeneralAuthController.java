package com.livenaked.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 授权接口
 */
@RestController
@RequestMapping("/general/auth")
public class GeneralAuthController {
    /**
     * 用户注册
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public void register(String phoneNo, String captcha) {

    }

    /**
     * 用户登录
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public void login(String phoneNo) {

    }

    /**
     * 发送手机短信验证码
     */
    @RequestMapping(value = "captcha", method = RequestMethod.POST)
    public void sendSMSCode(String phoneNo) {

    }
}
