package com.livenaked.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CMS 活动相关接口
 */
@RestController
@RequestMapping("/cms/activity")
public class CMSActivityController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "test")
    public String test() {

        return "3";
    }

    @RequestMapping(value = "user/test")
    public String Usertest() {

        return "1";
    }

    @RequestMapping(value = "teacher/test")
    public String te() {

        return "2";
    }
}
