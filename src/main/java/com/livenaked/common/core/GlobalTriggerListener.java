package com.livenaked.common.core;

import org.quartz.JobExecutionContext;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 全局 Trigger 监听器
 */
public class GlobalTriggerListener implements TriggerListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    /**
     * trigger满足触发条件时 触发
     */
    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        logger.info("触发器被触发");
    }

    /**
     * trigger触发后 执行job 前 触发
     */
    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        logger.info("触发器同意执行job");
        // false 表示 同意执行
        return false;
    }

    /**
     * 错过 trigger 触发时  触发
     *
     * @param trigger
     */
    @Override
    public void triggerMisfired(Trigger trigger) {
        logger.info("错过触发");
    }

    /**
     * trigger 被触发 且 job 执行结束 时 触发
     */
    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        logger.info("触发器监听器通知 job执行结束");
        // 若该任务不再执行就删除
        String jobName = context.getJobDetail().getKey().getName();
        try {
            if (context.getNextFireTime() == null) {
                context.getScheduler().deleteJob(context.getJobDetail().getKey());
            }
        } catch (SchedulerException e) {
            logger.error("删除" + jobName + "任务失败", e);
        }
    }
}
