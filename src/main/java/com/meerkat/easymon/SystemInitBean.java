package com.meerkat.easymon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.meerkat.easymon.config.Config;
import com.meerkat.easymon.schedule.ScheduleJobService;

/**
 * 系统初始化类
 */
@Component
public class SystemInitBean implements InitializingBean {

	static Logger logger = LoggerFactory.getLogger(SystemInitBean.class);

	@Autowired
	private Config config;
	
	@Autowired
	private AppExitGracefully appExitGracefully;
	
	  /** 定时任务service */
    @Autowired
    private ScheduleJobService scheduleJobService;
	
	public void afterPropertiesSet() throws Exception {
		//启用优雅停机
		if("true".equalsIgnoreCase(config.getShutdownHook())){
			Runtime.getRuntime().addShutdownHook(new Thread(appExitGracefully));
		}
		scheduleJobService.initScheduleJob();
	}
}
