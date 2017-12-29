package com.livenaked.task;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 定时任务调度器
 */
@Component
public class ScheduleHandle {
    @Autowired
    private Scheduler scheduler;

    /**
     * 添加一个 任务
     *
     * @param cron         执行规则
     * @param jobName      任务名
     * @param jobGroupName 任务组名
     * @param job          任务实现类
     */
    public void addJob(String jobName, String jobGroupName, String cron, Class<? extends Job> job, Map<String, ?> params) {
        try {
            // 创建jobDetail实例，绑定Job实现类
            // 指明job的名称，所在组的名称，以及绑定job类
            JobDetail jobDetail = JobBuilder.newJob(job).withIdentity(jobName, jobGroupName).build();//设置Job的名字和组
            if (params != null && params.size() > 0) {
                jobDetail.getJobDataMap().putAll(params);
            }
            jobDetail.getJobDataMap().put("jobName", jobName);
            jobDetail.getJobDataMap().put("jobGroupName", jobGroupName);
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
            //设置定时任务的时间触发规则
            CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroupName).withSchedule(scheduleBuilder).build();
            // 把作业和触发器注册到任务调度中
            scheduler.scheduleJob(jobDetail, cronTrigger);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改定时任务时间
     *
     * @param jobName      任务名
     * @param jobGroupName 任务组名
     * @param cron         执行时间
     */
    public void updateJobTime(String jobName, String jobGroupName, String cron) {
        try {
            TriggerKey triggerKey = new TriggerKey(jobName, jobGroupName);
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (trigger == null) {
                return;
            }
            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(cron)) {  // Trigger已存在，那么更新相应的定时设置
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);//设置一个新的定时时间
                CronTrigger cronTrigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
                scheduler.rescheduleJob(triggerKey, cronTrigger);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 停止一个任务
     *
     * @param jobName      任务名
     * @param jobGroupName 任务组名
     */
    public void stopJob(String jobName, String jobGroupName) {
        try {
            JobKey jobKey = new JobKey(jobName, jobGroupName);
            JobDetail jobDetail = scheduler.getJobDetail(jobKey);
            if (jobDetail == null) {
                return;
            }
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除一个任务
     *
     * @param jobName      任务名
     * @param jobGroupName 任务组名
     */
    public void deleteJob(String jobName, String jobGroupName) {
        try {
            JobKey jobKey = new JobKey(jobName, jobGroupName);
            JobDetail jobDetail = scheduler.getJobDetail(jobKey);
            if (jobDetail == null) {
                return;
            }
            scheduler.deleteJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 开始一个任务
     *
     * @param jobName      任务名
     * @param jobGroupName 任务组名
     */
    public void startJob(String jobName, String jobGroupName) {
        try {
            JobKey jobKey = new JobKey(jobName, jobGroupName);
            JobDetail jobDetail = scheduler.getJobDetail(jobKey);
            if (jobDetail == null) {
                return;
            }
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 开始定时任务
     */
    public void startAllJob() {
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 立即执行定时任务
     */
    public void doJob(String triggerName, String triggerGroupName) {
        try {
            JobKey jobKey = JobKey.jobKey(triggerName, triggerGroupName);
            scheduler.triggerJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        try {
            scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
