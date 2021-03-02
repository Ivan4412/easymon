package common;

import com.meerkat.easymon.EasymonServiceApp;
import com.meerkat.easymon.email.EmailService;
import com.meerkat.easymon.sms.SmsService;
import com.meerkat.easymon.util.ExpressionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by lenovo on 2018/6/5.
 */
//这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文。
@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringApplicationConfiguration(classes = EasymonServiceApp.class)
public class TestCommon {

    @Autowired
    protected SmsService smsService;

    @Autowired
    protected EmailService emailService;

    @Test
    public void testExpression() {
        String colname = "result";
        String conditions = "result = {1,2,3}";

        Object[] result = ExpressionUtils.getIncrementConditions(colname, conditions);
        assertNotNull(result);
        Map map = null;
        assertEquals(CollectionUtils.isEmpty(map), true);

        conditions = "result = 501";
        String resultStr = ExpressionUtils.getResultCondition(colname, conditions);
        assertEquals(resultStr, "501");
    }


    @Test
    public void testSms() {
        String phone = "13509678704";
        String content = "测试短信消息1";
        String result = smsService.send(phone, content);
        assertEquals(result, "SUCCESS");
    }

    @Test
    public void testEmail() {
        String result = emailService.sendEmail("yjsong4412@126.com", "easymon测试", "发送邮件测试");
        assertEquals(result, "SUCCESS");
    }

    @Test
    public void testService() {

        //测试整数判断
        assertEquals(ExpressionUtils.isInteger("123"), true);
        assertEquals(ExpressionUtils.isInteger("-123"), true);
        assertEquals(ExpressionUtils.isInteger("-0"), true);
        assertEquals(ExpressionUtils.isInteger("1.23"), false);
        assertEquals(ExpressionUtils.isInteger("-1.23"), false);
        assertEquals(ExpressionUtils.isInteger("1 23"), false);
        assertEquals(ExpressionUtils.isInteger("'123'"), false);
        assertEquals(ExpressionUtils.isInteger("abcd"), false);

        //测试小数判断
        assertEquals(ExpressionUtils.isDouble("1.23"), true);
        assertEquals(ExpressionUtils.isDouble("1.00"), true);
        assertEquals(ExpressionUtils.isDouble("-1.23"), true);
        assertEquals(ExpressionUtils.isDouble("123"), true);
        assertEquals(ExpressionUtils.isDouble("1.2 3"), false);
        assertEquals(ExpressionUtils.isDouble("abcd"), false);

        String result = "10";
        String colname = "result";
        String conditions = "result>0;result>=10; result=10;result==10, result<12, result<=10";

        assertEquals(ExpressionUtils.judgeResult(result, colname, conditions), true);

        result = "10";
        colname = "result";
        conditions = "result>0; result<10";

        assertEquals(ExpressionUtils.judgeResult(result, colname, conditions), false);

        result = "10";
        colname = "result";
        conditions = "result==10;result=10; othen==0";

        assertEquals(ExpressionUtils.judgeResult(result, colname, conditions), true);

        result = "10";
        colname = "result";
        conditions = "result!=9";

        assertEquals(ExpressionUtils.judgeResult(result, colname, conditions), true);

        result = "abc";
        colname = "result";
        conditions = "result=='abc'";

        assertEquals(ExpressionUtils.judgeResult(result, colname, conditions), true);

        result = "abc";
        colname = "result";
        conditions = "result=\"abc\"";

        assertEquals(ExpressionUtils.judgeResult(result, colname, conditions), true);


        result = "abc";
        colname = "result";
        conditions = "result.equals('abc')";

        assertEquals(ExpressionUtils.judgeResult(result, colname, conditions), true);

        result = "abc";
        colname = "result";
        conditions = "result.contains('ab')";

        assertEquals(ExpressionUtils.judgeResult(result, colname, conditions), true);

        result = "3.14159";
        colname = "result";
        conditions = "result<4";

        assertEquals(ExpressionUtils.judgeResult(result, colname, conditions), true);

        result = "3.14159";
        colname = "result";
        conditions = "result==3.14159";

        assertEquals(ExpressionUtils.judgeResult(result, colname, conditions), true);

    }

}

