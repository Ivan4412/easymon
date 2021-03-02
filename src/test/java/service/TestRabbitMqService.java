package service;

import com.meerkat.easymon.EasymonServiceApp;
import com.meerkat.easymon.util.HttpUtil;
import com.meerkat.easymon.util.JsonUtil;
import net.sf.json.JSONObject;
import org.apache.http.auth.AuthenticationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * author : yjs
 * createTime : 2019/3/12
 * description :
 * version : 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EasymonServiceApp.class)
public class TestRabbitMqService {

    @Test
    public void testHttpGet() throws IOException, AuthenticationException {
        String result = HttpUtil.getHttpResponseWithAuth("http://120.78.15.216:15672/api/overview", "peng", "3a72bX_3f2c");
        Map map = JsonUtil.parseJson(JSONObject.fromObject(result));
        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }

    }
}
