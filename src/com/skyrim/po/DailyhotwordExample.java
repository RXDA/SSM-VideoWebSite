package com.skyrim.po;

import java.util.ArrayList;
import java.util.List;

public class DailyhotwordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DailyhotwordExample() {
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

        public Criteria andHotwordidIsNull() {
            addCriterion("hotwordid is null");
            return (Criteria) this;
        }

        public Criteria andHotwordidIsNotNull() {
            addCriterion("hotwordid is not null");
            return (Criteria) this;
        }

        public Criteria andHotwordidEqualTo(Integer value) {
            addCriterion("hotwordid =", value, "hotwordid");
            return (Criteria) this;
        }

        public Criteria andHotwordidNotEqualTo(Integer value) {
            addCriterion("hotwordid <>", value, "hotwordid");
            return (Criteria) this;
        }

        public Criteria andHotwordidGreaterThan(Integer value) {
            addCriterion("hotwordid >", value, "hotwordid");
            return (Criteria) this;
        }

        public Criteria andHotwordidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotwordid >=", value, "hotwordid");
            return (Criteria) this;
        }

        public Criteria andHotwordidLessThan(Integer value) {
            addCriterion("hotwordid <", value, "hotwordid");
            return (Criteria) this;
        }

        public Criteria andHotwordidLessThanOrEqualTo(Integer value) {
            addCriterion("hotwordid <=", value, "hotwordid");
            return (Criteria) this;
        }

        public Criteria andHotwordidIn(List<Integer> values) {
            addCriterion("hotwordid in", values, "hotwordid");
            return (Criteria) this;
        }

        public Criteria andHotwordidNotIn(List<Integer> values) {
            addCriterion("hotwordid not in", values, "hotwordid");
            return (Criteria) this;
        }

        public Criteria andHotwordidBetween(Integer value1, Integer value2) {
            addCriterion("hotwordid between", value1, value2, "hotwordid");
            return (Criteria) this;
        }

        public Criteria andHotwordidNotBetween(Integer value1, Integer value2) {
            addCriterion("hotwordid not between", value1, value2, "hotwordid");
            return (Criteria) this;
        }

        public Criteria andHotwordIsNull() {
            addCriterion("hotword is null");
            return (Criteria) this;
        }

        public Criteria andHotwordIsNotNull() {
            addCriterion("hotword is not null");
            return (Criteria) this;
        }

        public Criteria andHotwordEqualTo(String value) {
            addCriterion("hotword =", value, "hotword");
            return (Criteria) this;
        }

        public Criteria andHotwordNotEqualTo(String value) {
            addCriterion("hotword <>", value, "hotword");
            return (Criteria) this;
        }

        public Criteria andHotwordGreaterThan(String value) {
            addCriterion("hotword >", value, "hotword");
            return (Criteria) this;
        }

        public Criteria andHotwordGreaterThanOrEqualTo(String value) {
            addCriterion("hotword >=", value, "hotword");
            return (Criteria) this;
        }

        public Criteria andHotwordLessThan(String value) {
            addCriterion("hotword <", value, "hotword");
            return (Criteria) this;
        }

        public Criteria andHotwordLessThanOrEqualTo(String value) {
            addCriterion("hotword <=", value, "hotword");
            return (Criteria) this;
        }

        public Criteria andHotwordLike(String value) {
            addCriterion("hotword like", value, "hotword");
            return (Criteria) this;
        }

        public Criteria andHotwordNotLike(String value) {
            addCriterion("hotword not like", value, "hotword");
            return (Criteria) this;
        }

        public Criteria andHotwordIn(List<String> values) {
            addCriterion("hotword in", values, "hotword");
            return (Criteria) this;
        }

        public Criteria andHotwordNotIn(List<String> values) {
            addCriterion("hotword not in", values, "hotword");
            return (Criteria) this;
        }

        public Criteria andHotwordBetween(String value1, String value2) {
            addCriterion("hotword between", value1, value2, "hotword");
            return (Criteria) this;
        }

        public Criteria andHotwordNotBetween(String value1, String value2) {
            addCriterion("hotword not between", value1, value2, "hotword");
            return (Criteria) this;
        }

        public Criteria andTimesIsNull() {
            addCriterion("times is null");
            return (Criteria) this;
        }

        public Criteria andTimesIsNotNull() {
            addCriterion("times is not null");
            return (Criteria) this;
        }

        public Criteria andTimesEqualTo(Integer value) {
            addCriterion("times =", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotEqualTo(Integer value) {
            addCriterion("times <>", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThan(Integer value) {
            addCriterion("times >", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("times >=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThan(Integer value) {
            addCriterion("times <", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThanOrEqualTo(Integer value) {
            addCriterion("times <=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesIn(List<Integer> values) {
            addCriterion("times in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotIn(List<Integer> values) {
            addCriterion("times not in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesBetween(Integer value1, Integer value2) {
            addCriterion("times between", value1, value2, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("times not between", value1, value2, "times");
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