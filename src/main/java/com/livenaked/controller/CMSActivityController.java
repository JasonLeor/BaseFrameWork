package com.livenaked.controller;

import com.livenaked.model.PCourse;
import com.livenaked.model.PUser;
import com.livenaked.service.intf.CourseServiceIntf;
import com.livenaked.service.intf.UserServiceIntf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CMS 活动相关接口
 */
@RestController
@RequestMapping("/cms/activity")
public class CMSActivityController {
    @Autowired
    private UserServiceIntf userService;
    @Autowired
    private CourseServiceIntf courseService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "test")
    public PUser test() {
        PCourse course = courseService.findCourse(1L);
        System.out.println(course.getSpace().toString());
        PUser user = userService.findUser("1588");
        return user;
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
