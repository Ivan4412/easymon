# easymon
easymon监控系统。
easymon监控平台提供业务层面数据监控服务，为各系统负责人更好的了解系统运作情况，用户可通过配置需监控系统的数据源及相关业务监控规则，监控目标系统数据变化。当满足告警触发规则时，Easymon将以手机短信，邮件，企业微信机器人等形式，发送告警信息相关接收人。

## 1. 建立数据库
执行创建sql: 
  - /resources/db/easymon_mysql.sql 
  - /resources/db/quartz_mysql.sql
  
## 2. 配置参数
配置数据库地址:
 -  /resources/system.properties
    ![image](src\main\resources\img\DBconfig.png)
    
配置系统发件邮箱:
 -  /resources/system.properties
    ![image](src\main\resources\img\email.png)
    
配置短信服务商：
 -  /resources/system.properties
    ![image](src\main\resources\img\smsConfig.png)

## 3. 配置任务
- 配置目前数据库源：t_datasource表
- 配置监控任务：t_monit_rule表
- 配置消息接收人信息：t_receiver表
- 配置监控消息接收关系：t_rule_receiver表
(更多内容，请参看document下文档)

## 4.编译工程和启动服务
- mvn clean install -Dmaven.test.skip=true -P test
- mvn spring-boot:run -Dmaven.test.skip=true