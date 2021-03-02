package service;
import com.meerkat.easymon.EasymonServiceApp;
import com.meerkat.easymon.data.gen.model.TDatasource;
import com.meerkat.easymon.service.JdbcTemplateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * author : yjs
 * createTime : 2018/6/6
 * description :
 * version : 1.0
 */
//这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文。
@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringApplicationConfiguration(classes = EasymonServiceApp.class)
public class TestJdbcTemplateService {
    /**
     * 使用spring jdbctemplate查询表结果select
     */
    @Autowired
    private JdbcTemplateService jdbcTemplateService;
    @Test
    public void testJdbcTemplate(){
        //创建数据源
        TDatasource datasource = new TDatasource();
        //设置数据库连接信息
        datasource.setUrl("jdbc:mysql://localhost:3306/Ivan");
        datasource.setDriveClassName("com.mysql.jdbc.Driver");
        datasource.setUsername("root");
        datasource.setPassword("imcoming4412");

        jdbcTemplateService.setDataSource(datasource);
        //执行sql语句
        String sql = "update user set user_name = 'yjs' where id = '3'";

        //调用执行方法，执行sql
        jdbcTemplateService.execute(sql);

    }
}
