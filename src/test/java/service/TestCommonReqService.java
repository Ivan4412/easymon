package service;

import com.meerkat.easymon.EasymonServiceApp;
import com.meerkat.easymon.common.Constant;
import com.meerkat.easymon.data.gen.model.TCommonReq;
import com.meerkat.easymon.service.CommonReqService;
import com.meerkat.easymon.util.ExpressionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by lenovo on 2018/6/5.
 */
//这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文。
@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringApplicationConfiguration(classes = EasymonServiceApp.class)
public class TestCommonReqService {

    @Autowired
    private CommonReqService commonReqService;

    @Test
    public void testResultConditions() {
        String resultName = "queue_totals.messages_ready";
        //支持变量名中含有点号，由于变量名只支持数字字母下划线，以__46__替代字段中的点号
        resultName = resultName.replace(".","__46__");
        String conditions = "queue_totals.messages_ready=218,queue_totals.messages=227,";
        conditions = conditions.replace(".","__46__");
        String result = ExpressionUtils.getResultConditions(resultName, conditions);
        System.out.println("getResultCondition:" + result);
        assertEquals(result, "218");
    }

    @Test
    public void testGetConditionName(){
        String condition;
        String name;
        condition = "queue_totals.messages_unacknowledged < 7";
        name = ExpressionUtils.getConditionName(condition);
        System.out.println("GetConditionName:" + name);
        assertEquals(name, "queue_totals.messages_unacknowledged");

        condition = "queue_totals.messages_unacknowledged > 7";
        name = ExpressionUtils.getConditionName(condition);
        System.out.println("GetConditionName:" + name);
        assertEquals(name, "queue_totals.messages_unacknowledged");

        condition = "queue_totals.messages_unacknowledged <> 7";
        name = ExpressionUtils.getConditionName(condition);
        System.out.println("GetConditionName:" + name);
        assertEquals(name, "queue_totals.messages_unacknowledged");

        condition = "queue_totals.messages_unacknowledged >= 7";
        name = ExpressionUtils.getConditionName(condition);
        System.out.println("GetConditionName:" + name);
        assertEquals(name, "queue_totals.messages_unacknowledged");

        condition = "queue_totals.messages_unacknowledged <= 7";
        name = ExpressionUtils.getConditionName(condition);
        System.out.println("GetConditionName:" + name);
        assertEquals(name, "queue_totals.messages_unacknowledged");

        condition = "queue_totals.messages_unacknowledged == 7";
        name = ExpressionUtils.getConditionName(condition);
        System.out.println("GetConditionName:" + name);
        assertEquals(name, "queue_totals.messages_unacknowledged");

        condition = "queue_totals.messages_unacknowledged = 7";
        name = ExpressionUtils.getConditionName(condition);
        System.out.println("GetConditionName:" + name);
        assertEquals(name, "queue_totals.messages_unacknowledged");
    }

    @Test
    public void testGetConditionsName(){
        String conditions = "result1 == 123,test2=4, result.abb=value";
        List<String> nameList = ExpressionUtils.getConditionsName(conditions);
        for(String name :nameList) {
            System.out.println("GetConditionName:" + name);
        }
        assertEquals(nameList.get(0), "result1");
        assertEquals(nameList.get(1), "test2");
        assertEquals(nameList.get(2), "result.abb");
    }

}

