package service;

import com.meerkat.easymon.EasymonServiceApp;
import com.meerkat.easymon.data.gen.model.TConfiguration;
import com.meerkat.easymon.service.ConfigurationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by lenovo on 2018/6/5.
 */
//这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文。
@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringApplicationConfiguration(classes = EasymonServiceApp.class)
public class TestConfigurationService {

    @Autowired
    private ConfigurationService configurationService;

    @Test
    public void testService() {

        TConfiguration tConfiguration = configurationService.findConfigurationVaildByName("weChat_addr");

        if (tConfiguration == null) {
            assertFalse(true);
        } else {
            System.out.println("配置内容："+tConfiguration.getContent());
            assertTrue(true);
        }

        tConfiguration = configurationService.findConfigurationById(new Long(1));

        if (tConfiguration == null) {
            assertFalse(true);
        } else {
            System.out.println("配置内容："+tConfiguration.getContent());
            assertTrue(true);
        }
    }
}

