package com.meerkat.easymon.quartz;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

/**
 * 由于默认的JobFactory使用反射创建实例后，未被Spring IOC托管，所以需要自行实现Factory类
 * @author ucheer
 *
 */
public class CustomJobFactory extends SpringBeanJobFactory{  
  
    @Autowired
    private AutowireCapableBeanFactory capableBeanFactory;
    
    @Override    
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {    
        //调用父类的方法    
        Object jobInstance = super.createJobInstance(bundle);    
        //进行注入    
        capableBeanFactory.autowireBean(jobInstance);    
        return jobInstance;    
    }  
      
} 