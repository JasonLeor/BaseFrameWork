package com.livenaked.controller;

import com.livenaked.entity.SimpleEntity;
import com.livenaked.model.PUser;
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
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserServiceIntf userDao;

    @RequestMapping(value = "test")
    public SimpleEntity test() throws Exception {
        logger.trace("111", "12");
        logger.info("222", "12");
        logger.error("333", "12");
        logger.debug("444", "12");
        logger.warn("555", "12");
        PUser one = userDao.findById((long) 1588);
        PUser one2 = userDao.findById((long) 1588);
        SimpleEntity simpleEntity = new SimpleEntity();
        return new SimpleEntity("111");
    }
}
