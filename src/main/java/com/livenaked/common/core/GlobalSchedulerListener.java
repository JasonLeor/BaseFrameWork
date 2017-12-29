package com.livenaked.common.core;

import org.quartz.SchedulerException;
import org.quartz.SchedulerListener;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.listeners.SchedulerListenerSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Scheduler 监听器
 */
public class GlobalSchedulerListener extends SchedulerListenerSupport implements SchedulerListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * jobDetail 部署时触发
     */
    @Override
    public void jobScheduled(Trigger trigger) {
        super.jobScheduled(trigger);
        logger.info("有新任务部署");
    }

    /**
     * jobDetail 卸载时触发
     */
    @Override
    public void jobUnscheduled(TriggerKey triggerKey) {
        super.jobUnscheduled(triggerKey);
        logger.info("有任务卸载");
    }

    /**
     * 运行期间产生 严重错误时 触发
     */
    @Override
    public void schedulerError(String msg, SchedulerException cause) {
        super.schedulerError(msg, cause);
        logger.error("schedule 捕获错误");
    }

    /**
     * trigger 生命周期结束时 触发
     */
    @Override
    public void triggerFinalized(Trigger trigger) {
        super.triggerFinalized(trigger);
        logger.info("schedule 捕获到一个不会再执行的 触发器");
    }

    /**
     * trigger组被暂停时 触发
     */
    @Override
    public void triggersPaused(String triggerGroup) {
        super.triggersPaused(triggerGroup);
        logger.info("触发器被停止");
    }

    /**
     * trigger组回复运行时 触发
     */
    @Override
    public void triggersResumed(String triggerGroup) {
        super.triggersResumed(triggerGroup);
        logger.info("触发器恢复工作");
    }

    /**
     * scheduler 关闭前触发
     */
    @Override
    public void schedulerShutdown() {
        super.schedulerShutdown();
        logger.info("scheduler 将要关闭");
    }
}
