package com.livenaked.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 课程接口
 */
@RestController
@RequestMapping("/general/course")
public class GeneralCourseController {
    /**
     * 课程列表
     */
    @RequestMapping(value = "courseList", method = RequestMethod.GET)
    private String courseList() {

        return "123131232";
    }

    /**
     * 课程详细信息
     */
    @RequestMapping(value = "courseDetail", method = RequestMethod.GET)
    private void courseDetail(String id) {

    }

}
