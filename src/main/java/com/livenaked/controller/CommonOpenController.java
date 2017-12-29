package com.livenaked.controller;

import com.livenaked.common.tools.Utils;
import com.livenaked.task.ScheduleHandle;
import com.livenaked.task.job.TestJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.temporal.ChronoUnit;

/**
 * 公共开放 接口 (供第三方使用)
 */
@RestController
@RequestMapping("/open")
public class CommonOpenController {
    @Autowired
    private ScheduleHandle scheduleHandle;

    @RequestMapping("/start")
    public void test(String jobName, String jobGroupName) {
        scheduleHandle.addJob(jobName, jobGroupName, Utils.getCron(Utils.afterDateTime(10L, ChronoUnit.SECONDS)), TestJob.class, null);
        scheduleHandle.startJob(jobName, jobGroupName);
    }

    @RequestMapping("/stop")
    public void test2() {
        scheduleHandle.stopJob("job1", "gropu1");
    }

    @RequestMapping("/modify")
    public void test3() {
        scheduleHandle.updateJobTime("job1", "gropu1", "0/1 * * * * ? ");
    }

    @RequestMapping("/remove")
    public void test4() {
        scheduleHandle.deleteJob("job1", "gropu1");
    }
}
