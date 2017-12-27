package com.livenaked.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 普通 基本接口
 */
@RestController
@RequestMapping("/general")
public class GeneralController {

    /**
     * 检查版本
     */
    @RequestMapping(value = "version", method = RequestMethod.POST)
    public void checkVersion(String os, String version) {

    }

    /**
     * 获取当前最新版本
     */
    @RequestMapping(value = "version", method = RequestMethod.GET)
    public void getCurrentVersion(String os) {

    }

}
