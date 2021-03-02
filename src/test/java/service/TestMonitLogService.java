package service;

import com.meerkat.easymon.EasymonServiceApp;
import com.meerkat.easymon.common.Constant;
import com.meerkat.easymon.data.gen.model.TMonitLog;
import com.meerkat.easymon.data.gen.model.TMonitRule;
import com.meerkat.easymon.service.MonitLogService;
import com.meerkat.easymon.service.MonitRuleService;
import org.joda.time.DateTimeComparator;
import org.joda.time.DateTimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by lenovo on 2018/6/5.
 */
//这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文。
@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringApplicationConfiguration(classes = EasymonServiceApp.class)
public class TestMonitLogService {

    @Autowired
    private MonitLogService monitLogService;

    @Autowired
    private MonitRuleService monitRuleService;

    @Test
    public void testService() {
        //插入数据

        List<TMonitRule> monitRules = monitRuleService.getAllMonitRule();
        TMonitRule monitRule = monitRules.get(0);

        TMonitLog jobLog = new TMonitLog();
        jobLog.setRuleId(monitRule.getRuleId());
        jobLog.setIsMail(Constant.MONITLOG_ISMAIL);
        jobLog.setIsTelephone(Constant.MONITLOG_ISTELEPHONE);
        jobLog.setIsWarning(Constant.MONITLOG_ISWARNING);
        jobLog.setResult("成功");
        monitLogService.insert(jobLog);

        List<TMonitLog> list = monitLogService.findMonitLogByRuleId(monitRule.getRuleId());
        if(!CollectionUtils.isEmpty(list)) {
            assertEquals(list.get(0).getRuleId(),monitRule.getRuleId());
        }else {
           System.out.println("无日志信息规则");
        }

        TMonitLog monitLoglast = monitLogService.findMonitLogByRuleIdLastOne(monitRule.getRuleId(),"yangjingsong");
        assertEquals(monitLoglast.getRuleId(),monitRule.getRuleId());
        System.out.println("日志信息("+monitLoglast.getCreatedTime()+"):"+monitLoglast);

        List<TMonitLog> list2 = monitLogService.findMonitLogListByRuleIdAndInterval(monitRule.getRuleId(), 3600);
        if(!CollectionUtils.isEmpty(list2)) {
            assertEquals(list2.get(0).getRuleId(),monitRule.getRuleId());
        }else {
            System.out.println("无日志信息规则");
        }


    }

}

