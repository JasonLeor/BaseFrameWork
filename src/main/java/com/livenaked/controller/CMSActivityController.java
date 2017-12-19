package com.livenaked.controller;

import com.livenaked.model.PUser;
import com.livenaked.service.intf.UserServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * CMS 活动相关接口
 */
@RestController
@RequestMapping("/cms/activity")
public class CMSActivityController {
    @Autowired
    private UserServiceIntf userDao;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public void test() {
        PUser one = userDao.findById((long) 1588);
        PUser one2 = userDao.findById((long) 1588);
        System.out.println(one.toString());
    }
}
