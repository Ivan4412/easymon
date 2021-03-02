package service;

import com.meerkat.easymon.EasymonServiceApp;
import com.meerkat.easymon.common.Constant;
import com.meerkat.easymon.data.gen.model.TMonitRule;
import com.meerkat.easymon.data.gen.model.TRuleReceiver;
import com.meerkat.easymon.service.MonitRuleService;
import com.meerkat.easymon.service.RuleReceiverService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by lenovo on 2018/6/5.
 */
//这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文。
@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringApplicationConfiguration(classes = EasymonServiceApp.class)
public class TestRuleReceiverService {

    @Autowired
    private RuleReceiverService ruleReceiverService;

    @Test
    public void testService() {
        String id="001";
        List<TRuleReceiver> list = ruleReceiverService.getRuleReceiverByRuleId(id);
        if(!CollectionUtils.isEmpty(list)) {
            assertEquals(list.get(0).getRuleId(), id);
        }else {
            System.out.println("无rule_id为"+id+"规则接收人映射");
        }

    }
}

