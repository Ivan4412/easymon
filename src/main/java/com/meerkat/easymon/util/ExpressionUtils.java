package com.meerkat.easymon.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/** 表达式判断工具类
 * author : yjs
 * createTime : 2018/6/13
 * description :
 * version : 1.0
 */
public  class ExpressionUtils {

    private static final Logger log = LoggerFactory.getLogger(ExpressionUtils.class);
    /**
     *  result的值是否满足表达式
     * @param result
     * @param resultName  result在表达式中的变量名
     * @param conditions  表达式
     * @return
     */
    public static boolean judgeResult(String result,String resultName,String conditions){
        boolean flag = true;

        //SPEL语法变量以#开头
        conditions = conditions.replace(resultName,"#"+resultName);
        //支持使用逗号，分号分割不同条件（去除条件中的空格）
        conditions = conditions.replace(" ","").replace(",",";").replaceAll(";+", ";"); //把多个分号替换为单个分号;
        //支持表达式以=或者==，指定变量的值
        conditions = conditions.replaceAll("([^><=!])=([^=])","$1==$2");
        String[] conditionList = conditions.split(";");
        if(conditionList != null){

            for(int i=0;i<conditionList.length;i++){
                String condition = conditionList[i];
                if(condition.contains(resultName)){ //含该字段
                    ExpressionParser parser = new SpelExpressionParser();
                    EvaluationContext context = new StandardEvaluationContext();

                    if(isInteger(result)) {
                        context.setVariable(resultName, Integer.valueOf(result));
                    }else if(isDouble(result)){
                        context.setVariable(resultName, Double.valueOf(result));
                    }else{
                        context.setVariable(resultName, result);
                    }
                    if(!parser.parseExpression(condition).getValue(context, boolean.class)){
                        flag = false;
                    }
                }
            }

        }

        return flag;
    }


    /**
     * 取得表达式中数组值（sql查询结果增量预警中使用）
     * @param resultName
     * @param conditions
     * @return
     */
    public static Object[] getIncrementConditions(String resultName,String conditions) {

        Object[] conditionsArray = null;

        //SPEL语法变量以#开头
        conditions = conditions.replace(resultName,"#"+resultName);

        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();

        if(conditions.contains(resultName)) { //含该字段

            List list = parser.parseExpression(conditions).getValue(context, List.class);

            if (list != null && list.size() > 0) {
                     conditionsArray = list.toArray();
            }
        }

        return conditionsArray;
    }

    /**
     * 取得表达式中值（sql查询结果增量预警中使用）
     * @param resultName
     * @param condition
     * @return
     */
    public static String getResultCondition(String resultName,String condition){

        String result = "";

        //SPEL语法变量以#开头
        condition = condition.replace(resultName,"#"+resultName);

        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();

        if(condition.contains(resultName)) { //含该字段
            result = parser.parseExpression(condition).getValue(context, String.class);
        }

        return result;
    }

    /**
     * 取得表达式中值（URL连续时间段预警中使用）
     * @param resultName
     * @param conditions
     * @return
     */
    public static String getResultConditions(String resultName, String conditions) {
        String result = "";

        //支持使用逗号，分号分割不同条件（去除条件中的空格）
        conditions = conditions.replace(" ", "").replace(",", ";").replaceAll(";+", ";"); //把多个分号替换为单个分号;

        String[] conditionList = conditions.split(";");
        if (conditionList != null) {
            for (int i = 0; i < conditionList.length; i++) {
                String condition = conditionList[i];

                ExpressionParser parser = new SpelExpressionParser();
                EvaluationContext context = new StandardEvaluationContext();

                String conditionName = ExpressionUtils.getConditionName(condition); //取得条件变量名
                if (!StringUtils.isEmpty(conditionName) && conditionName.equals(resultName)) {
                    //SPEL语法变量以#开头
                    condition = condition.replace(resultName,"#"+resultName);
                    result = parser.parseExpression(condition).getValue(context, String.class);
                    break;
                }
            }
        }
        return result;
    }

    /**
     *  取得表达式中的变量名
     * @param conditions
     * @return
     */
    public static List<String> getConditionsName(String conditions) {
        List<String> nameList = new ArrayList<>();

        //支持使用逗号，分号分割不同条件（去除条件中的空格）
        conditions = conditions.replace(" ", "").replace(",", ";").replaceAll(";+", ";"); //把多个分号替换为单个分号;

        String[] conditionList = conditions.split(";");
        if (conditionList != null) {
            for (int i = 0; i < conditionList.length; i++) {
                String condition = conditionList[i];
                String conditionName = ExpressionUtils.getConditionName(condition);
                if (!StringUtils.isEmpty(conditionName)) {
                    nameList.add(conditionName);
                }
            }
        }
        return nameList;
    }

    /**
     *  取得单个表达式中的变量名
     * @param condition
     * @return
     */
    public static String getConditionName(String condition) {
        String[] array = null;
        if(StringUtils.isEmpty(condition)){
           return null;
       }
        if (condition.contains(">=")) {
            array = condition.replace(" ", "").split(">=");
        }
        else if(condition.contains("<=")){
            array = condition.replace(" ", "").split("<=");
        }
        else if(condition.contains("<>")){
            array = condition.replace(" ", "").split("<>");
        }
        else if(condition.contains(">")){
            array = condition.replace(" ", "").split(">");
        }
        else if(condition.contains("<")){
            array = condition.replace(" ", "").split("<");
        }
        else if(condition.contains("==")){
            array = condition.replace(" ", "").split("==");
        }
        else if(condition.contains("!=")){
            array = condition.replace(" ", "").split("!=");
        }
        else if(condition.contains("=")){
            array = condition.replace(" ", "").split("=");
        }

        if (array == null || array.length != 2) {
            return null;
        } else {
            return array[0];
        }
    }

    /**
     * 判断是否是整数
     * @param str
     * @return
     */
    public static boolean isInteger(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


    /**
     * 判断是否是小数
     * @param str
     * @return
     */
    public static boolean isDouble(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
        return pattern.matcher(str).matches();
    }

}
