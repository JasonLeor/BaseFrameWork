package com.livenaked.common.core;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 全局job 监听器
 */
public class GlobalJobListener implements JobListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    /**
     * 任务执行前 触发
     */
    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        String name = context.getJobDetail().getKey().getName();
        logger.info(name + "将开始");
    }

    /**
     * 任务被 触发器否决时 触发
     *
     * @param context
     */
    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        String name = context.getJobDetail().getKey().getName();
        logger.info(name + "被触发器否决");
    }

    /**
     * 任务结束后触发
     */
    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        String name = context.getJobDetail().getKey().getName();
        logger.info(name + "执行结束");
    }
}
