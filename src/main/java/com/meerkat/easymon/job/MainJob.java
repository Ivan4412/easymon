package com.meerkat.easymon.job;

import com.meerkat.easymon.data.gen.model.TDatasource;
import com.meerkat.easymon.data.gen.model.TMonitLog;
import com.meerkat.easymon.dto.ScheduleJob;
import com.meerkat.easymon.service.JdbcTemplateService;
import com.meerkat.easymon.service.MonitLogService;
import com.meerkat.easymon.util.ExpressionUtils;
import com.meerkat.easymon.util.HttpUtil;
import com.meerkat.easymon.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrSubstitutor;
import org.apache.http.auth.AuthenticationException;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

import java.io.IOException;
import java.util.*;

/**
 * author : yjs
 * createTime : 2018/6/5
 * description : 定时任务类
 * version : 1.0
 */
@Slf4j
public class MainJob extends AbstractJob {

    /**
     * JdbcTemplate服务
     */
    @Autowired
    private JdbcTemplateService jdbcTemplateService;

    /**
     * 监控信息日志服务类
     */
    @Autowired
    private MonitLogService monitLogService;

    public void execute(ScheduleJob scheduleJob) throws JobExecutionException {

        if(scheduleJob == null){
            log.error("MainJob执行错误，未接收到scheduleJob");
            throw new JobExecutionException("MainJob执行错误，未接收到scheduleJob!");
        }

        log.debug("MainJob({}) is running:{}",scheduleJob.getJobName(),new Date());

        //执行计划任务
        switch (scheduleJob.getType()) {
            case "sql"://sql查询结果
                this.handleSql(scheduleJob);
                break;
            case "increment"://sql查询结果增量预警
                this.handleIncrement(scheduleJob);
                break;
            case "urlGet"://url方式预警
                this.handleUrlGet(scheduleJob);
                break;
            case "urlLeast"://url方式连续时间段内至少一次满足条件
                this.handleUrlLeast(scheduleJob);
                break;
            default:
                log.error("Job({})暂不支持该监控类型：", scheduleJob.getJobName(), scheduleJob.getType());
                throw new JobExecutionException("暂不支持该监控类型：" + scheduleJob.getType());
        }

    }


    /**
     * 处理url类型连续时间段内至少一次满足条件监控任务
     * @param scheduleJob
     * @throws JobExecutionException
     */

    @SuppressWarnings("Duplicates")
    private void handleUrlLeast(ScheduleJob scheduleJob) throws JobExecutionException {

        StringBuffer executeResult = new StringBuffer(""); //准备返回的执行结果
        List<String> resultList = new ArrayList<>(); //连续一段时间内的监控结果
        Map resultMap = new HashMap(); //记录查询结果
        String result = this.processUrlGet(scheduleJob); //解析Url查询结果
        boolean verifyFlag = false;  //是否预警，默认为false，所有结果中，至少有一次满足条件，则不预警

        String resultName = ExpressionUtils.getConditionName(scheduleJob.getExpectedResult()); //取得条件变量名

        if (StringUtils.isBlank(resultName)) {
            log.error("URL监控任务({}):{}，解析期望结果变量名出错:{}！", scheduleJob.getJobName(), scheduleJob.getContent(), scheduleJob.getExpectedResult());
            throw new JobExecutionException("URL监控类型，解析期望结果变量名出错！");
        }

        //预期结果不为空，查询结果为空，预警
        if (StringUtils.isBlank(result)) {
            if (StringUtils.isNotBlank(scheduleJob.getExpectedResult())) {
                scheduleJob.setWarning(true);
                scheduleJob.setExecuteResult("查询结果为空!");
                scheduleJob.setWarningMessage("监控规则(" + scheduleJob.getDescription() + ")查询结果为空!");
                return;
            }
            executeResult.append("查询结果为空!");

        } else {
            try {
                //以JSON格式解析数据
                resultMap = JsonUtil.parseJson(JSONObject.fromObject(result));
                Iterator<Map.Entry<String, String>> iter = resultMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, String> entry = iter.next();
                    if (resultName.equals(entry.getKey())) {
                        resultList.add(entry.getValue()); //添加到结果判断队列
                        executeResult.append(entry.getKey()).append("=").append(entry.getValue()); //添加本次结果到记录中
                        if (iter.hasNext()) {
                            executeResult.append(",");
                        }
                    }
                }

            } catch (JSONException e) {
                log.error("URL监控任务({}):{}，Json解析出错:{}！", scheduleJob.getJobName(), scheduleJob.getContent(), e);
                scheduleJob.setWarning(true);
                throw new JobExecutionException("URL监控类型，Json解析出错！");
            }
        }

        //查询连续时间段内监控执行结果
        int intervalTime = scheduleJob.getTriggerInterval();
        if (intervalTime == 0) {
            log.error("URL连续时间段监控任务({})，间隔时间不正确：{}！", scheduleJob.getJobName(), intervalTime);
            scheduleJob.setWarning(true);
            throw new JobExecutionException("URL连续时间段监控任务，间隔时间不正确！");
        }

        List<TMonitLog> monitLogList = monitLogService.findMonitLogListByRuleIdAndInterval(scheduleJob.getJobId(), intervalTime * 1000);
        for (TMonitLog tMonitLog : monitLogList) {
            if (StringUtils.isNotBlank(tMonitLog.getResult()) && tMonitLog.getResult().contains(resultName)) {
                String recordResult = ExpressionUtils.getResultConditions(resultName.replace(".", "__46__"), tMonitLog.getResult().replace(".", "__46__"));//根据变量名取，记录中结果的值
                resultList.add(recordResult);
            }
        }

        String expectedResult = scheduleJob.getExpectedResult();
        //支持变量名中含有点号，由于变量名只支持数字字母下划线，以__46__替代字段中的点号
        expectedResult = expectedResult.replace(".", "__46__");
        for (String resultValue : resultList) {
            if (ExpressionUtils.judgeResult(resultValue, resultName.replace(".", "__46__"), expectedResult)) {
                verifyFlag = true;
            }
        }

        //验证通过不告警
        if (verifyFlag) {
            scheduleJob.setWarning(false);
        } else {
            scheduleJob.setWarning(true);
        }

        //预警消息内容转换
        StrSubstitutor sub = new StrSubstitutor(resultMap);
        String resolvedString = sub.replace(scheduleJob.getWarningMessage());
        log.debug("resolvedWarningMessage,warningMessage:{},resolved:{}", scheduleJob.getWarningMessage(), resolvedString);

        scheduleJob.setWarningMessage(resolvedString);
        scheduleJob.setExecuteResult(executeResult.toString());

    }

    private String processUrlGet(ScheduleJob scheduleJob) throws JobExecutionException{

        if (StringUtils.isBlank(scheduleJob.getContent())) {
            log.error("URL监控任务({})，未获取到URL地址！", scheduleJob.getJobName());
            scheduleJob.setWarning(true);
            throw new JobExecutionException("URL监控类型，URL地址不能为空！");
        }

        String result = "";

        TDatasource datasource = scheduleJob.getDatasource();
        try {
            if (datasource != null) { //配置datasource信息的，读取用户密码信息，发送授权信息
                result = HttpUtil.getHttpResponseWithAuth(scheduleJob.getContent(), datasource.getUsername(), datasource.getPassword());
            } else {
                result = HttpUtil.getHttpResponse(scheduleJob.getContent());
            }
        } catch (AuthenticationException e) {
            //HTTP链接失败，预警
            scheduleJob.setWarning(true);
            scheduleJob.setWarningMessage(scheduleJob.getDescription()+"任务授权失败");
            scheduleJob.setExecuteResult(e.getMessage());
            return null;
        } catch (IOException e) {
            //HTTP链接失败，预警
            scheduleJob.setWarning(true);
            scheduleJob.setWarningMessage(scheduleJob.getWarningMessage());
            scheduleJob.setExecuteResult(e.getMessage());
            return null;
        }

        return result;
    }

    /**
     * 处理url类型监控任务
     * @param scheduleJob
     * @throws JobExecutionException
     */
    private void handleUrlGet(ScheduleJob scheduleJob) throws JobExecutionException{

        StringBuffer executeResult = new StringBuffer(""); //准备返回的执行结果
        Map resultMap = new HashMap(); //记录查询结果
        String result = this.processUrlGet(scheduleJob); //解析Url查询结果

        //预期结果不为空，查询结果为空，预警
        if(StringUtils.isBlank(result)){
            if(StringUtils.isNotBlank(scheduleJob.getExpectedResult())){
                scheduleJob.setWarning(true);
                scheduleJob.setExecuteResult("查询结果为空!");
                scheduleJob.setWarningMessage("监控规则(" + scheduleJob.getDescription() + ")查询结果为空!");
                return;
            }
            executeResult.append("查询结果为空!");

        }else{
            //解析查询结果
            boolean verifyFlag = true;  //表达式验证结果，多个表达式有一个验证不通过就告警

            String expectedResult =  scheduleJob.getExpectedResult();
            //支持变量名中含有点号，由于变量名只支持数字字母下划线，以__46__替代字段中的点号
            expectedResult = expectedResult.replace(".","__46__");
            try {
                //以JSON格式解析数据
                resultMap = JsonUtil.parseJson(JSONObject.fromObject(result));
                Iterator<Map.Entry<String, String>> iter = resultMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, String> entry = iter.next();

                    if (!ExpressionUtils.judgeResult(entry.getValue(), entry.getKey().replace(".","__46__"), expectedResult)) {
                        verifyFlag = false;
                    }

                    List<String> resultNameList = ExpressionUtils.getConditionsName(scheduleJob.getExpectedResult()); //取得条件变量名
                    for (String resultName : resultNameList) {
                        if (StringUtils.isNotBlank(resultName) && resultName.equals(entry.getKey())) {
                            executeResult.append(entry.getKey()).append("=").append(entry.getValue()); //添加本次结果到记录中
                            if (iter.hasNext()) {
                                executeResult.append(",");
                            }
                        }
                    }

                }

            } catch (JSONException e) {
                log.error("URL监控任务({}):{}，Json解析出错:{}！", scheduleJob.getJobName(), scheduleJob.getContent(), e);
                throw new JobExecutionException("URL监控类型，Json解析出错！");
            }

            //验证通过不告警
            if (verifyFlag) {
                scheduleJob.setWarning(false);
            } else {
                scheduleJob.setWarning(true);
            }

        }

        //预警消息内容转换
        StrSubstitutor sub = new StrSubstitutor(resultMap);
        String resolvedString = sub.replace(scheduleJob.getWarningMessage());
        log.debug("resolvedWarningMessage,warningMessage:{},resolved:{}", scheduleJob.getWarningMessage(), resolvedString);

        scheduleJob.setWarningMessage(resolvedString);
        scheduleJob.setExecuteResult(executeResult.toString());

    }

    /**
     * 处理increment类型监控任务
     * @param scheduleJob
     */
    private void handleIncrement(ScheduleJob scheduleJob) throws JobExecutionException{
        jdbcTemplateService.setDataSource(scheduleJob.getDatasource());

        SqlRowSet sqlRowSet = null;
        try {
            sqlRowSet = jdbcTemplateService.queryForRowSet(scheduleJob.getContent());
        } catch (Exception e) {
            log.error("Job({})，监控规则sql查询异常！", scheduleJob.getJobName());
            //数据库查询异常，预警
            scheduleJob.setWarning(true);
            scheduleJob.setExecuteResult(e.getMessage());
            scheduleJob.setWarningMessage("监控规则(" + scheduleJob.getDescription() + ")查询异常：" + e.getMessage());
            return;
        }

        if (sqlRowSet != null && sqlRowSet.getMetaData() != null) {
            sqlRowSet.first();
            SqlRowSetMetaData metaData = sqlRowSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (sqlRowSet.getRow() > 0) {
                Map valuesMap = new HashMap(); //记录查询结果
                boolean warningFlag = false;  //是否需要预警，默认不需要
                StringBuffer executeResult = new StringBuffer("");
                for (int i = 1; i <= columnCount; i++) {
                    String colName = metaData.getColumnName(i);
                    String result = sqlRowSet.getString(colName);
                    log.debug("Get ColumnName:{},result:{},condition:{}", colName, result, scheduleJob.getExpectedResult());
                    if(StringUtils.isBlank(result)){ //查询结果为空时，置为0
                        result = "0";
                    }
                    if(!ExpressionUtils.isInteger(result)){ //目前只支持整数类型的增量结果查询
                        log.error("ruleId:({})目前只支持整数类型的增量结果查询, ColumnName:{}", scheduleJob.getJobId(), colName);
                        throw new JobExecutionException("目前只支持整数类型的增量结果查询!");
                    }

                    int resultInt = Integer.parseInt(result); //转换为int类型

                    //取得期望增量数组
                    Object[] conditions = ExpressionUtils.getIncrementConditions(colName, scheduleJob.getExpectedResult());

                    //取得当天上一次查询的结果
                    int incrementResultInt = 0;
                    TMonitLog monitLog = monitLogService.findMonitLogByRuleIdLastOneToday(scheduleJob.getJobId());
                    if(monitLog != null){
                        String incrementResult = ExpressionUtils.getResultCondition(colName,monitLog.getResult());

                        if(StringUtils.isBlank(incrementResult)){ //查询结果为空时，置为0
                            incrementResult = "0";
                        }

                        if(!ExpressionUtils.isInteger(incrementResult)){ //目前只支持整数类型的增量结果查询
                            log.error("ruleId:({})增量结果查询目前只支持整数类型, ColumnName:{}", scheduleJob.getJobId(), colName);
                            throw new JobExecutionException("增量结果查询目前只支持整数类型!");
                        }

                        incrementResultInt =  Integer.parseInt(incrementResult);
                    }

                    int resultTotal = resultInt + incrementResultInt; //累计历史查询结果

                    if (conditions != null) {
                        try {
                            for (int j = 0; j < conditions.length - 1; j++) {
                                int min = (Integer) conditions[j];
                                int max = (Integer) conditions[j + 1];

                                if (max < min) {
                                    int t = min;
                                    min = max;
                                    max = t;
                                }

                                //判断当前查询结果是否符合期望预警规则（为了避免查询数据量太大，每次只查询一定时间间隔内的数据，并将结果累加判断）

                                if (resultTotal >= min && resultTotal < max) { //需要告警

                                    //查询该结果是否已经预警过，已经预警过则不再重复预警
                                    if (monitLog != null && incrementResultInt >= min && incrementResultInt < max) { //历史结果也在该阶段，则已经预警过，不需要告警
                                        log.debug("增量结果，历史已预警， ColumnName:{},result:{},min:{}，max:{}", colName, result, min, max);
                                    } else {
                                        warningFlag = true;
                                    }
                                    break;

                                } else { //无需告警
                                    log.debug("无需告警 ColumnName:{},result:{},min:{}，max:{}", colName, result, min, max);
                                }
                            }
                        }catch(ClassCastException e){
                            log.error("ruleId:({})取得期望预警增量数组类型转换失败, ColumnName:{}  :{}", scheduleJob.getJobId(), colName,e);
                            throw new JobExecutionException("取得期望预警增量数组类型转换失败!",e);
                        }
                    }else{
                        log.error("ruleId:({})取得期望增量预警条件失败, ColumnName:{}", scheduleJob.getJobId(), colName);
                        throw new JobExecutionException("取得期望增量预警条件失败!");
                    }

                    //记录查询结果
                    executeResult.append(colName).append("=").append(String.valueOf(resultTotal));
                    valuesMap.put(colName, resultTotal);
                    if (i != columnCount) {
                        executeResult.append(",");
                    }

                    scheduleJob.setWarning(warningFlag);

                    StrSubstitutor sub = new StrSubstitutor(valuesMap);
                    String resolvedString = sub.replace(scheduleJob.getWarningMessage());
                    log.debug("resolvedWarningMessage,warningMessage:{},resolved:{}", scheduleJob.getWarningMessage(), resolvedString);

                    scheduleJob.setWarningMessage(resolvedString);
                    scheduleJob.setExecuteResult(executeResult.toString());
                }
            }
        } else {
            log.error("Job({})，监控规则sql查询失败，请检查！", scheduleJob.getJobName());
            //数据库查询异常，预警
            scheduleJob.setWarning(true);
            scheduleJob.setWarningMessage("监控规则(" + scheduleJob.getDescription() + ")查询异常，请检查");
        }

    }


    /**
     * 处理sql类型监控任务
     * @param scheduleJob
     */
    private void handleSql(ScheduleJob scheduleJob) throws JobExecutionException{
        jdbcTemplateService.setDataSource(scheduleJob.getDatasource());

        SqlRowSet sqlRowSet = null;
        try {
            sqlRowSet = jdbcTemplateService.queryForRowSet(scheduleJob.getContent());
        } catch (Exception e) {
            log.error("Job({})，监控规则sql查询异常！", scheduleJob.getJobName());
            //数据库查询异常，预警
            scheduleJob.setWarning(true);
            scheduleJob.setExecuteResult(e.getMessage());
            scheduleJob.setWarningMessage("监控规则(" + scheduleJob.getDescription() + ")查询异常：" + e.getMessage());
            return;
        }

        if (sqlRowSet != null && sqlRowSet.getMetaData() != null) {
            sqlRowSet.first();
            SqlRowSetMetaData metaData = sqlRowSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (sqlRowSet.getRow() > 0) {
                Map valuesMap = new HashMap(); //记录查询结果
                boolean verifyFlag = true;  //表达式验证结果，多个表达式有一个验证不通过就告警
                StringBuffer  executeResult = new StringBuffer("");
                for (int i = 1; i <= columnCount; i++) {
                    String colName = metaData.getColumnName(i);
                    String result = sqlRowSet.getString(colName);
                    log.debug("Get ColumnName:{},result:{},condition:{}", colName, result, scheduleJob.getExpectedResult());
                    executeResult.append(colName).append("=").append(result);
                    valuesMap.put(colName, result);
                    if(i != columnCount){
                        executeResult.append(",");
                    }
                    //无期望结果时，查询出结果时告警，无结果不告警
                    if (StringUtils.isBlank(scheduleJob.getExpectedResult()) || !ExpressionUtils.judgeResult(result, colName, scheduleJob.getExpectedResult())) {
                        verifyFlag = false;
                    }

                }
                //验证通过不告警
                if (verifyFlag) {
                    scheduleJob.setWarning(false);
                } else {
                    scheduleJob.setWarning(true);
                }

                StrSubstitutor sub = new StrSubstitutor(valuesMap);
                String resolvedString = sub.replace(scheduleJob.getWarningMessage());
                log.debug("resolvedWarningMessage,warningMessage:{},resolved:{}", scheduleJob.getWarningMessage(), resolvedString);

                scheduleJob.setWarningMessage(resolvedString);
                scheduleJob.setExecuteResult(executeResult.toString());

            } else {
                if (StringUtils.isBlank(scheduleJob.getExpectedResult())) {
                    scheduleJob.setWarning(false);
                } else { //有期望结果，查询无数据时，告警
                    scheduleJob.setWarning(true);
                }
            }

        } else {
            log.error("Job({})，监控规则sql查询失败，请检查！", scheduleJob.getJobName());
            //数据库查询异常，预警
            scheduleJob.setWarning(true);
            scheduleJob.setWarningMessage("监控规则(" + scheduleJob.getDescription() + ")查询异常，请检查");
        }
    }


}
