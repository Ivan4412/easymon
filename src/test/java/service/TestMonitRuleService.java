package service;

import com.meerkat.easymon.EasymonServiceApp;
import com.meerkat.easymon.common.Constant;
import com.meerkat.easymon.data.gen.model.TMonitRule;
import com.meerkat.easymon.dto.ScheduleJob;
import com.meerkat.easymon.service.MonitRuleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by lenovo on 2018/6/5.
 */
//这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文。
@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringApplicationConfiguration(classes = EasymonServiceApp.class)
public class TestMonitRuleService {

    @Autowired
    private MonitRuleService monitRuleService;


    @Test
    public void testService() {
        List<TMonitRule> list = monitRuleService.getAllValidMonitRule();
        if(!CollectionUtils.isEmpty(list)) {
            assertEquals((long)list.get(0).getIsVaild(), Constant.MONITRULE_ISVAILD);
        }else {
           System.out.println("无有效监控规则");
        }

        List<TMonitRule> list2 = monitRuleService.getAllMonitRule();
        assertNotNull(list2);

    }

}

