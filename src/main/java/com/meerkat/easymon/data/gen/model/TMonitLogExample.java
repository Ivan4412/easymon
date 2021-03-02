package com.meerkat.easymon.data.gen.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMonitLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMonitLogExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
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

        public Criteria andReceiverIdIsNull() {
            addCriterion("receiver_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdIsNotNull() {
            addCriterion("receiver_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdEqualTo(String value) {
            addCriterion("receiver_id =", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdNotEqualTo(String value) {
            addCriterion("receiver_id <>", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdGreaterThan(String value) {
            addCriterion("receiver_id >", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_id >=", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdLessThan(String value) {
            addCriterion("receiver_id <", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdLessThanOrEqualTo(String value) {
            addCriterion("receiver_id <=", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdLike(String value) {
            addCriterion("receiver_id like", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdNotLike(String value) {
            addCriterion("receiver_id not like", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdIn(List<String> values) {
            addCriterion("receiver_id in", values, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdNotIn(List<String> values) {
            addCriterion("receiver_id not in", values, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdBetween(String value1, String value2) {
            addCriterion("receiver_id between", value1, value2, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdNotBetween(String value1, String value2) {
            addCriterion("receiver_id not between", value1, value2, "receiverId");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andIsWarningIsNull() {
            addCriterion("is_warning is null");
            return (Criteria) this;
        }

        public Criteria andIsWarningIsNotNull() {
            addCriterion("is_warning is not null");
            return (Criteria) this;
        }

        public Criteria andIsWarningEqualTo(Short value) {
            addCriterion("is_warning =", value, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningNotEqualTo(Short value) {
            addCriterion("is_warning <>", value, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningGreaterThan(Short value) {
            addCriterion("is_warning >", value, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningGreaterThanOrEqualTo(Short value) {
            addCriterion("is_warning >=", value, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningLessThan(Short value) {
            addCriterion("is_warning <", value, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningLessThanOrEqualTo(Short value) {
            addCriterion("is_warning <=", value, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningIn(List<Short> values) {
            addCriterion("is_warning in", values, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningNotIn(List<Short> values) {
            addCriterion("is_warning not in", values, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningBetween(Short value1, Short value2) {
            addCriterion("is_warning between", value1, value2, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningNotBetween(Short value1, Short value2) {
            addCriterion("is_warning not between", value1, value2, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsMailIsNull() {
            addCriterion("is_mail is null");
            return (Criteria) this;
        }

        public Criteria andIsMailIsNotNull() {
            addCriterion("is_mail is not null");
            return (Criteria) this;
        }

        public Criteria andIsMailEqualTo(Short value) {
            addCriterion("is_mail =", value, "isMail");
            return (Criteria) this;
        }

        public Criteria andIsMailNotEqualTo(Short value) {
            addCriterion("is_mail <>", value, "isMail");
            return (Criteria) this;
        }

        public Criteria andIsMailGreaterThan(Short value) {
            addCriterion("is_mail >", value, "isMail");
            return (Criteria) this;
        }

        public Criteria andIsMailGreaterThanOrEqualTo(Short value) {
            addCriterion("is_mail >=", value, "isMail");
            return (Criteria) this;
        }

        public Criteria andIsMailLessThan(Short value) {
            addCriterion("is_mail <", value, "isMail");
            return (Criteria) this;
        }

        public Criteria andIsMailLessThanOrEqualTo(Short value) {
            addCriterion("is_mail <=", value, "isMail");
            return (Criteria) this;
        }

        public Criteria andIsMailIn(List<Short> values) {
            addCriterion("is_mail in", values, "isMail");
            return (Criteria) this;
        }

        public Criteria andIsMailNotIn(List<Short> values) {
            addCriterion("is_mail not in", values, "isMail");
            return (Criteria) this;
        }

        public Criteria andIsMailBetween(Short value1, Short value2) {
            addCriterion("is_mail between", value1, value2, "isMail");
            return (Criteria) this;
        }

        public Criteria andIsMailNotBetween(Short value1, Short value2) {
            addCriterion("is_mail not between", value1, value2, "isMail");
            return (Criteria) this;
        }

        public Criteria andIsTelephoneIsNull() {
            addCriterion("is_telephone is null");
            return (Criteria) this;
        }

        public Criteria andIsTelephoneIsNotNull() {
            addCriterion("is_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andIsTelephoneEqualTo(Short value) {
            addCriterion("is_telephone =", value, "isTelephone");
            return (Criteria) this;
        }

        public Criteria andIsTelephoneNotEqualTo(Short value) {
            addCriterion("is_telephone <>", value, "isTelephone");
            return (Criteria) this;
        }

        public Criteria andIsTelephoneGreaterThan(Short value) {
            addCriterion("is_telephone >", value, "isTelephone");
            return (Criteria) this;
        }

        public Criteria andIsTelephoneGreaterThanOrEqualTo(Short value) {
            addCriterion("is_telephone >=", value, "isTelephone");
            return (Criteria) this;
        }

        public Criteria andIsTelephoneLessThan(Short value) {
            addCriterion("is_telephone <", value, "isTelephone");
            return (Criteria) this;
        }

        public Criteria andIsTelephoneLessThanOrEqualTo(Short value) {
            addCriterion("is_telephone <=", value, "isTelephone");
            return (Criteria) this;
        }

        public Criteria andIsTelephoneIn(List<Short> values) {
            addCriterion("is_telephone in", values, "isTelephone");
            return (Criteria) this;
        }

        public Criteria andIsTelephoneNotIn(List<Short> values) {
            addCriterion("is_telephone not in", values, "isTelephone");
            return (Criteria) this;
        }

        public Criteria andIsTelephoneBetween(Short value1, Short value2) {
            addCriterion("is_telephone between", value1, value2, "isTelephone");
            return (Criteria) this;
        }

        public Criteria andIsTelephoneNotBetween(Short value1, Short value2) {
            addCriterion("is_telephone not between", value1, value2, "isTelephone");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andIsWechatIsNull() {
            addCriterion("is_weChat is null");
            return (Criteria) this;
        }

        public Criteria andIsWechatIsNotNull() {
            addCriterion("is_weChat is not null");
            return (Criteria) this;
        }

        public Criteria andIsWechatEqualTo(Short value) {
            addCriterion("is_weChat =", value, "isWechat");
            return (Criteria) this;
        }

        public Criteria andIsWechatNotEqualTo(Short value) {
            addCriterion("is_weChat <>", value, "isWechat");
            return (Criteria) this;
        }

        public Criteria andIsWechatGreaterThan(Short value) {
            addCriterion("is_weChat >", value, "isWechat");
            return (Criteria) this;
        }

        public Criteria andIsWechatGreaterThanOrEqualTo(Short value) {
            addCriterion("is_weChat >=", value, "isWechat");
            return (Criteria) this;
        }

        public Criteria andIsWechatLessThan(Short value) {
            addCriterion("is_weChat <", value, "isWechat");
            return (Criteria) this;
        }

        public Criteria andIsWechatLessThanOrEqualTo(Short value) {
            addCriterion("is_weChat <=", value, "isWechat");
            return (Criteria) this;
        }

        public Criteria andIsWechatIn(List<Short> values) {
            addCriterion("is_weChat in", values, "isWechat");
            return (Criteria) this;
        }

        public Criteria andIsWechatNotIn(List<Short> values) {
            addCriterion("is_weChat not in", values, "isWechat");
            return (Criteria) this;
        }

        public Criteria andIsWechatBetween(Short value1, Short value2) {
            addCriterion("is_weChat between", value1, value2, "isWechat");
            return (Criteria) this;
        }

        public Criteria andIsWechatNotBetween(Short value1, Short value2) {
            addCriterion("is_weChat not between", value1, value2, "isWechat");
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