package com.meerkat.easymon.config;


import com.meerkat.easymon.quartz.CustomJobFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;

@Configuration
public class QuartzConfiguration implements ApplicationContextAware {

    @Bean
    public CustomJobFactory customJobFactory() {
        return new CustomJobFactory();
    }
    
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource,CustomJobFactory customJobFactory) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setDataSource(dataSource);
        bean.setOverwriteExistingJobs(true);
        bean.setStartupDelay(10);
        bean.setAutoStartup(true);
        bean.setJobFactory(customJobFactory);
        bean.setApplicationContextSchedulerContextKey("applicationContextKey");
        bean.setConfigLocation(new ClassPathResource("spring-quartz.properties"));
        return bean;
    }
    
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
