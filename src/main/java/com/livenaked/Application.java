package com.livenaked;

import com.livenaked.common.core.BaseDaoFactoryBean;
import com.livenaked.common.core.BaseDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories(basePackages = "com.livenaked.dao",
        repositoryImplementationPostfix = "Impl",
        repositoryFactoryBeanClass = BaseDaoFactoryBean.class,
        repositoryBaseClass = BaseDaoImpl.class)
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
    }
}
