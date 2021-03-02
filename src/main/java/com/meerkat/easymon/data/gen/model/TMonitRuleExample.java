package com.meerkat.easymon.data.gen.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMonitRuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMonitRuleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRuleIdIsNull() {
            addCriterion("rule_id is null");
            return (Criteria) this;
        }

        public Criteria andRuleIdIsNotNull() {
            addCriterion("rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andRuleIdEqualTo(String value) {
            addCriterion("rule_id =", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotEqualTo(String value) {
            addCriterion("rule_id <>", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdGreaterThan(String value) {
            addCriterion("rule_id >", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdGreaterThanOrEqualTo(String value) {
            addCriterion("rule_id >=", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLessThan(String value) {
            addCriterion("rule_id <", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLessThanOrEqualTo(String value) {
            addCriterion("rule_id <=", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLike(String value) {
            addCriterion("rule_id like", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotLike(String value) {
            addCriterion("rule_id not like", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdIn(List<String> values) {
            addCriterion("rule_id in", values, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotIn(List<String> values) {
            addCriterion("rule_id not in", values, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdBetween(String value1, String value2) {
            addCriterion("rule_id between", value1, value2, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotBetween(String value1, String value2) {
            addCriterion("rule_id not between", value1, value2, "ruleId");
            return (Criteria) this;
        }

        public Criteria andDatesourceIdIsNull() {
            addCriterion("datesource_id is null");
            return (Criteria) this;
        }

        public Criteria andDatesourceIdIsNotNull() {
            addCriterion("datesource_id is not null");
            return (Criteria) this;
        }

        public Criteria andDatesourceIdEqualTo(Long value) {
            addCriterion("datesource_id =", value, "datesourceId");
            return (Criteria) this;
        }

        public Criteria andDatesourceIdNotEqualTo(Long value) {
            addCriterion("datesource_id <>", value, "datesourceId");
            return (Criteria) this;
        }

        public Criteria andDatesourceIdGreaterThan(Long value) {
            addCriterion("datesource_id >", value, "datesourceId");
            return (Criteria) this;
        }

        public Criteria andDatesourceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("datesource_id >=", value, "datesourceId");
            return (Criteria) this;
        }

        public Criteria andDatesourceIdLessThan(Long value) {
            addCriterion("datesource_id <", value, "datesourceId");
            return (Criteria) this;
        }

        public Criteria andDatesourceIdLessThanOrEqualTo(Long value) {
            addCriterion("datesource_id <=", value, "datesourceId");
            return (Criteria) this;
        }

        public Criteria andDatesourceIdIn(List<Long> values) {
            addCriterion("datesource_id in", values, "datesourceId");
            return (Criteria) this;
        }

        public Criteria andDatesourceIdNotIn(List<Long> values) {
            addCriterion("datesource_id not in", values, "datesourceId");
            return (Criteria) this;
        }

        public Criteria andDatesourceIdBetween(Long value1, Long value2) {
            addCriterion("datesource_id between", value1, value2, "datesourceId");
            return (Criteria) this;
        }

        public Criteria andDatesourceIdNotBetween(Long value1, Long value2) {
            addCriterion("datesource_id not between", value1, value2, "datesourceId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andExpectedResultIsNull() {
            addCriterion("expected_result is null");
            return (Criteria) this;
        }

        public Criteria andExpectedResultIsNotNull() {
            addCriterion("expected_result is not null");
            return (Criteria) this;
        }

        public Criteria andExpectedResultEqualTo(String value) {
            addCriterion("expected_result =", value, "expectedResult");
            return (Criteria) this;
        }

        public Criteria andExpectedResultNotEqualTo(String value) {
            addCriterion("expected_result <>", value, "expectedResult");
            return (Criteria) this;
        }

        public Criteria andExpectedResultGreaterThan(String value) {
            addCriterion("expected_result >", value, "expectedResult");
            return (Criteria) this;
        }

        public Criteria andExpectedResultGreaterThanOrEqualTo(String value) {
            addCriterion("expected_result >=", value, "expectedResult");
            return (Criteria) this;
        }

        public Criteria andExpectedResultLessThan(String value) {
            addCriterion("expected_result <", value, "expectedResult");
            return (Criteria) this;
        }

        public Criteria andExpectedResultLessThanOrEqualTo(String value) {
            addCriterion("expected_result <=", value, "expectedResult");
            return (Criteria) this;
        }

        public Criteria andExpectedResultLike(String value) {
            addCriterion("expected_result like", value, "expectedResult");
            return (Criteria) this;
        }

        public Criteria andExpectedResultNotLike(String value) {
            addCriterion("expected_result not like", value, "expectedResult");
            return (Criteria) this;
        }

        public Criteria andExpectedResultIn(List<String> values) {
            addCriterion("expected_result in", values, "expectedResult");
            return (Criteria) this;
        }

        public Criteria andExpectedResultNotIn(List<String> values) {
            addCriterion("expected_result not in", values, "expectedResult");
            return (Criteria) this;
        }

        public Criteria andExpectedResultBetween(String value1, String value2) {
            addCriterion("expected_result between", value1, value2, "expectedResult");
            return (Criteria) this;
        }

        public Criteria andExpectedResultNotBetween(String value1, String value2) {
            addCriterion("expected_result not between", value1, value2, "expectedResult");
            return (Criteria) this;
        }

        public Criteria andRuleDescIsNull() {
            addCriterion("rule_desc is null");
            return (Criteria) this;
        }

        public Criteria andRuleDescIsNotNull() {
            addCriterion("rule_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRuleDescEqualTo(String value) {
            addCriterion("rule_desc =", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescNotEqualTo(String value) {
            addCriterion("rule_desc <>", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescGreaterThan(String value) {
            addCriterion("rule_desc >", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescGreaterThanOrEqualTo(String value) {
            addCriterion("rule_desc >=", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescLessThan(String value) {
            addCriterion("rule_desc <", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescLessThanOrEqualTo(String value) {
            addCriterion("rule_desc <=", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescLike(String value) {
            addCriterion("rule_desc like", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescNotLike(String value) {
            addCriterion("rule_desc not like", value, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescIn(List<String> values) {
            addCriterion("rule_desc in", values, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescNotIn(List<String> values) {
            addCriterion("rule_desc not in", values, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescBetween(String value1, String value2) {
            addCriterion("rule_desc between", value1, value2, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andRuleDescNotBetween(String value1, String value2) {
            addCriterion("rule_desc not between", value1, value2, "ruleDesc");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeIsNull() {
            addCriterion("trigger_type is null");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeIsNotNull() {
            addCriterion("trigger_type is not null");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeEqualTo(Short value) {
            addCriterion("trigger_type =", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeNotEqualTo(Short value) {
            addCriterion("trigger_type <>", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeGreaterThan(Short value) {
            addCriterion("trigger_type >", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("trigger_type >=", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeLessThan(Short value) {
            addCriterion("trigger_type <", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeLessThanOrEqualTo(Short value) {
            addCriterion("trigger_type <=", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeIn(List<Short> values) {
            addCriterion("trigger_type in", values, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeNotIn(List<Short> values) {
            addCriterion("trigger_type not in", values, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeBetween(Short value1, Short value2) {
            addCriterion("trigger_type between", value1, value2, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeNotBetween(Short value1, Short value2) {
            addCriterion("trigger_type not between", value1, value2, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerIntervalIsNull() {
            addCriterion("trigger_interval is null");
            return (Criteria) this;
        }

        public Criteria andTriggerIntervalIsNotNull() {
            addCriterion("trigger_interval is not null");
            return (Criteria) this;
        }

        public Criteria andTriggerIntervalEqualTo(Integer value) {
            addCriterion("trigger_interval =", value, "triggerInterval");
            return (Criteria) this;
        }

        public Criteria andTriggerIntervalNotEqualTo(Integer value) {
            addCriterion("trigger_interval <>", value, "triggerInterval");
            return (Criteria) this;
        }

        public Criteria andTriggerIntervalGreaterThan(Integer value) {
            addCriterion("trigger_interval >", value, "triggerInterval");
            return (Criteria) this;
        }

        public Criteria andTriggerIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("trigger_interval >=", value, "triggerInterval");
            return (Criteria) this;
        }

        public Criteria andTriggerIntervalLessThan(Integer value) {
            addCriterion("trigger_interval <", value, "triggerInterval");
            return (Criteria) this;
        }

        public Criteria andTriggerIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("trigger_interval <=", value, "triggerInterval");
            return (Criteria) this;
        }

        public Criteria andTriggerIntervalIn(List<Integer> values) {
            addCriterion("trigger_interval in", values, "triggerInterval");
            return (Criteria) this;
        }

        public Criteria andTriggerIntervalNotIn(List<Integer> values) {
            addCriterion("trigger_interval not in", values, "triggerInterval");
            return (Criteria) this;
        }

        public Criteria andTriggerIntervalBetween(Integer value1, Integer value2) {
            addCriterion("trigger_interval between", value1, value2, "triggerInterval");
            return (Criteria) this;
        }

        public Criteria andTriggerIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("trigger_interval not between", value1, value2, "triggerInterval");
            return (Criteria) this;
        }

        public Criteria andCronExpressionIsNull() {
            addCriterion("cron_expression is null");
            return (Criteria) this;
        }

        public Criteria andCronExpressionIsNotNull() {
            addCriterion("cron_expression is not null");
            return (Criteria) this;
        }

        public Criteria andCronExpressionEqualTo(String value) {
            addCriterion("cron_expression =", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotEqualTo(String value) {
            addCriterion("cron_expression <>", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionGreaterThan(String value) {
            addCriterion("cron_expression >", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionGreaterThanOrEqualTo(String value) {
            addCriterion("cron_expression >=", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionLessThan(String value) {
            addCriterion("cron_expression <", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionLessThanOrEqualTo(String value) {
            addCriterion("cron_expression <=", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionLike(String value) {
            addCriterion("cron_expression like", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotLike(String value) {
            addCriterion("cron_expression not like", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionIn(List<String> values) {
            addCriterion("cron_expression in", values, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotIn(List<String> values) {
            addCriterion("cron_expression not in", values, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionBetween(String value1, String value2) {
            addCriterion("cron_expression between", value1, value2, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotBetween(String value1, String value2) {
            addCriterion("cron_expression not between", value1, value2, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andIsVaildIsNull() {
            addCriterion("is_vaild is null");
            return (Criteria) this;
        }

        public Criteria andIsVaildIsNotNull() {
            addCriterion("is_vaild is not null");
            return (Criteria) this;
        }

        public Criteria andIsVaildEqualTo(Short value) {
            addCriterion("is_vaild =", value, "isVaild");
            return (Criteria) this;
        }

        public Criteria andIsVaildNotEqualTo(Short value) {
            addCriterion("is_vaild <>", value, "isVaild");
            return (Criteria) this;
        }

        public Criteria andIsVaildGreaterThan(Short value) {
            addCriterion("is_vaild >", value, "isVaild");
            return (Criteria) this;
        }

        public Criteria andIsVaildGreaterThanOrEqualTo(Short value) {
            addCriterion("is_vaild >=", value, "isVaild");
            return (Criteria) this;
        }

        public Criteria andIsVaildLessThan(Short value) {
            addCriterion("is_vaild <", value, "isVaild");
            return (Criteria) this;
        }

        public Criteria andIsVaildLessThanOrEqualTo(Short value) {
            addCriterion("is_vaild <=", value, "isVaild");
            return (Criteria) this;
        }

        public Criteria andIsVaildIn(List<Short> values) {
            addCriterion("is_vaild in", values, "isVaild");
            return (Criteria) this;
        }

        public Criteria andIsVaildNotIn(List<Short> values) {
            addCriterion("is_vaild not in", values, "isVaild");
            return (Criteria) this;
        }

        public Criteria andIsVaildBetween(Short value1, Short value2) {
            addCriterion("is_vaild between", value1, value2, "isVaild");
            return (Criteria) this;
        }

        public Criteria andIsVaildNotBetween(Short value1, Short value2) {
            addCriterion("is_vaild not between", value1, value2, "isVaild");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("creater is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("creater is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("creater like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("creater not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("creater not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNull() {
            addCriterion("updater is null");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNotNull() {
            addCriterion("updater is not null");
            return (Criteria) this;
        }

        public Criteria andUpdaterEqualTo(String value) {
            addCriterion("updater =", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotEqualTo(String value) {
            addCriterion("updater <>", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThan(String value) {
            addCriterion("updater >", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThanOrEqualTo(String value) {
            addCriterion("updater >=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThan(String value) {
            addCriterion("updater <", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThanOrEqualTo(String value) {
            addCriterion("updater <=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLike(String value) {
            addCriterion("updater like", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotLike(String value) {
            addCriterion("updater not like", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterIn(List<String> values) {
            addCriterion("updater in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotIn(List<String> values) {
            addCriterion("updater not in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterBetween(String value1, String value2) {
            addCriterion("updater between", value1, value2, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotBetween(String value1, String value2) {
            addCriterion("updater not between", value1, value2, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andSendTypeIsNull() {
            addCriterion("send_type is null");
            return (Criteria) this;
        }

        public Criteria andSendTypeIsNotNull() {
            addCriterion("send_type is not null");
            return (Criteria) this;
        }

        public Criteria andSendTypeEqualTo(Short value) {
            addCriterion("send_type =", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotEqualTo(Short value) {
            addCriterion("send_type <>", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeGreaterThan(Short value) {
            addCriterion("send_type >", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("send_type >=", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeLessThan(Short value) {
            addCriterion("send_type <", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeLessThanOrEqualTo(Short value) {
            addCriterion("send_type <=", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeIn(List<Short> values) {
            addCriterion("send_type in", values, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotIn(List<Short> values) {
            addCriterion("send_type not in", values, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeBetween(Short value1, Short value2) {
            addCriterion("send_type between", value1, value2, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotBetween(Short value1, Short value2) {
            addCriterion("send_type not between", value1, value2, "sendType");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}