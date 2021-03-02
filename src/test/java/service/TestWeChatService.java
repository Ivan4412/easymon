package service;

import com.meerkat.easymon.EasymonServiceApp;
import com.meerkat.easymon.data.gen.model.TConfiguration;
import com.meerkat.easymon.data.gen.model.TReceiver;
import com.meerkat.easymon.service.ConfigurationService;
import com.meerkat.easymon.service.ReceiverService;
import com.meerkat.easymon.service.WeChatService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by lenovo on 2018/6/5.
 */
//这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文。
@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringApplicationConfiguration(classes = EasymonServiceApp.class)
public class TestWeChatService {

    @Autowired
    private ReceiverService receiverService;

    @Autowired
    private WeChatService weChatService;

    @Autowired
    private ConfigurationService configurationService;

    @Test
    public void testService() {
        TReceiver receiver = receiverService.findReceiverById("yangjingsong");
        List<TReceiver> receivers = new ArrayList<>();
        receivers.add(receiver);
        if (CollectionUtils.isEmpty(receivers)) {
            assertFalse(true);
        } else {
            String content = "easymon消息测试";
            TConfiguration tConfiguration = configurationService.findConfigurationVaildByName("weChat_addr");

            if (tConfiguration == null) {
                assertFalse(true);
                return ;
            }
            String urlAddress = tConfiguration.getContent();
            Boolean result = weChatService.sendText(content, receivers, urlAddress);
            assertEquals(result, true);
        }
    }
}

