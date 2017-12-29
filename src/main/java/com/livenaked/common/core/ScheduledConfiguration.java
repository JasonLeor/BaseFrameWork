package com.livenaked.common.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class ScheduledConfiguration {

    @Bean
    public SchedulerFactoryBean getSchedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setSchedulerListeners(new GlobalSchedulerListener());
        schedulerFactoryBean.setGlobalTriggerListeners(new GlobalTriggerListener());
        schedulerFactoryBean.setGlobalJobListeners(new GlobalJobListener());
        return schedulerFactoryBean;
    }
}
