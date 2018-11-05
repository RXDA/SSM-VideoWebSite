package com.skyrim.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class VideoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VideoExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andVidIsNull() {
            addCriterion("vid is null");
            return (Criteria) this;
        }

        public Criteria andVidIsNotNull() {
            addCriterion("vid is not null");
            return (Criteria) this;
        }

        public Criteria andVidEqualTo(Integer value) {
            addCriterion("vid =", value, "vid");
            return (Criteria) this;
        }

        public Criteria andVidNotEqualTo(Integer value) {
            addCriterion("vid <>", value, "vid");
            return (Criteria) this;
        }

        public Criteria andVidGreaterThan(Integer value) {
            addCriterion("vid >", value, "vid");
            return (Criteria) this;
        }

        public Criteria andVidGreaterThanOrEqualTo(Integer value) {
            addCriterion("vid >=", value, "vid");
            return (Criteria) this;
        }

        public Criteria andVidLessThan(Integer value) {
            addCriterion("vid <", value, "vid");
            return (Criteria) this;
        }

        public Criteria andVidLessThanOrEqualTo(Integer value) {
            addCriterion("vid <=", value, "vid");
            return (Criteria) this;
        }

        public Criteria andVidIn(List<Integer> values) {
            addCriterion("vid in", values, "vid");
            return (Criteria) this;
        }

        public Criteria andVidNotIn(List<Integer> values) {
            addCriterion("vid not in", values, "vid");
            return (Criteria) this;
        }

        public Criteria andVidBetween(Integer value1, Integer value2) {
            addCriterion("vid between", value1, value2, "vid");
            return (Criteria) this;
        }

        public Criteria andVidNotBetween(Integer value1, Integer value2) {
            addCriterion("vid not between", value1, value2, "vid");
            return (Criteria) this;
        }

        public Criteria andSubuidIsNull() {
            addCriterion("subuid is null");
            return (Criteria) this;
        }

        public Criteria andSubuidIsNotNull() {
            addCriterion("subuid is not null");
            return (Criteria) this;
        }

        public Criteria andSubuidEqualTo(Integer value) {
            addCriterion("subuid =", value, "subuid");
            return (Criteria) this;
        }

        public Criteria andSubuidNotEqualTo(Integer value) {
            addCriterion("subuid <>", value, "subuid");
            return (Criteria) this;
        }

        public Criteria andSubuidGreaterThan(Integer value) {
            addCriterion("subuid >", value, "subuid");
            return (Criteria) this;
        }

        public Criteria andSubuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("subuid >=", value, "subuid");
            return (Criteria) this;
        }

        public Criteria andSubuidLessThan(Integer value) {
            addCriterion("subuid <", value, "subuid");
            return (Criteria) this;
        }

        public Criteria andSubuidLessThanOrEqualTo(Integer value) {
            addCriterion("subuid <=", value, "subuid");
            return (Criteria) this;
        }

        public Criteria andSubuidIn(List<Integer> values) {
            addCriterion("subuid in", values, "subuid");
            return (Criteria) this;
        }

        public Criteria andSubuidNotIn(List<Integer> values) {
            addCriterion("subuid not in", values, "subuid");
            return (Criteria) this;
        }

        public Criteria andSubuidBetween(Integer value1, Integer value2) {
            addCriterion("subuid between", value1, value2, "subuid");
            return (Criteria) this;
        }

        public Criteria andSubuidNotBetween(Integer value1, Integer value2) {
            addCriterion("subuid not between", value1, value2, "subuid");
            return (Criteria) this;
        }

        public Criteria andVtitleIsNull() {
            addCriterion("vtitle is null");
            return (Criteria) this;
        }

        public Criteria andVtitleIsNotNull() {
            addCriterion("vtitle is not null");
            return (Criteria) this;
        }

        public Criteria andVtitleEqualTo(String value) {
            addCriterion("vtitle =", value, "vtitle");
            return (Criteria) this;
        }

        public Criteria andVtitleNotEqualTo(String value) {
            addCriterion("vtitle <>", value, "vtitle");
            return (Criteria) this;
        }

        public Criteria andVtitleGreaterThan(String value) {
            addCriterion("vtitle >", value, "vtitle");
            return (Criteria) this;
        }

        public Criteria andVtitleGreaterThanOrEqualTo(String value) {
            addCriterion("vtitle >=", value, "vtitle");
            return (Criteria) this;
        }

        public Criteria andVtitleLessThan(String value) {
            addCriterion("vtitle <", value, "vtitle");
            return (Criteria) this;
        }

        public Criteria andVtitleLessThanOrEqualTo(String value) {
            addCriterion("vtitle <=", value, "vtitle");
            return (Criteria) this;
        }

        public Criteria andVtitleLike(String value) {
            addCriterion("vtitle like", value, "vtitle");
            return (Criteria) this;
        }

        public Criteria andVtitleNotLike(String value) {
            addCriterion("vtitle not like", value, "vtitle");
            return (Criteria) this;
        }

        public Criteria andVtitleIn(List<String> values) {
            addCriterion("vtitle in", values, "vtitle");
            return (Criteria) this;
        }

        public Criteria andVtitleNotIn(List<String> values) {
            addCriterion("vtitle not in", values, "vtitle");
            return (Criteria) this;
        }

        public Criteria andVtitleBetween(String value1, String value2) {
            addCriterion("vtitle between", value1, value2, "vtitle");
            return (Criteria) this;
        }

        public Criteria andVtitleNotBetween(String value1, String value2) {
            addCriterion("vtitle not between", value1, value2, "vtitle");
            return (Criteria) this;
        }

        public Criteria andVurlIsNull() {
            addCriterion("vurl is null");
            return (Criteria) this;
        }

        public Criteria andVurlIsNotNull() {
            addCriterion("vurl is not null");
            return (Criteria) this;
        }

        public Criteria andVurlEqualTo(String value) {
            addCriterion("vurl =", value, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlNotEqualTo(String value) {
            addCriterion("vurl <>", value, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlGreaterThan(String value) {
            addCriterion("vurl >", value, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlGreaterThanOrEqualTo(String value) {
            addCriterion("vurl >=", value, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlLessThan(String value) {
            addCriterion("vurl <", value, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlLessThanOrEqualTo(String value) {
            addCriterion("vurl <=", value, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlLike(String value) {
            addCriterion("vurl like", value, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlNotLike(String value) {
            addCriterion("vurl not like", value, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlIn(List<String> values) {
            addCriterion("vurl in", values, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlNotIn(List<String> values) {
            addCriterion("vurl not in", values, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlBetween(String value1, String value2) {
            addCriterion("vurl between", value1, value2, "vurl");
            return (Criteria) this;
        }

        public Criteria andVurlNotBetween(String value1, String value2) {
            addCriterion("vurl not between", value1, value2, "vurl");
            return (Criteria) this;
        }

        public Criteria andVplaytimeIsNull() {
            addCriterion("vplaytime is null");
            return (Criteria) this;
        }

        public Criteria andVplaytimeIsNotNull() {
            addCriterion("vplaytime is not null");
            return (Criteria) this;
        }

        public Criteria andVplaytimeEqualTo(Integer value) {
            addCriterion("vplaytime =", value, "vplaytime");
            return (Criteria) this;
        }

        public Criteria andVplaytimeNotEqualTo(Integer value) {
            addCriterion("vplaytime <>", value, "vplaytime");
            return (Criteria) this;
        }

        public Criteria andVplaytimeGreaterThan(Integer value) {
            addCriterion("vplaytime >", value, "vplaytime");
            return (Criteria) this;
        }

        public Criteria andVplaytimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("vplaytime >=", value, "vplaytime");
            return (Criteria) this;
        }

        public Criteria andVplaytimeLessThan(Integer value) {
            addCriterion("vplaytime <", value, "vplaytime");
            return (Criteria) this;
        }

        public Criteria andVplaytimeLessThanOrEqualTo(Integer value) {
            addCriterion("vplaytime <=", value, "vplaytime");
            return (Criteria) this;
        }

        public Criteria andVplaytimeIn(List<Integer> values) {
            addCriterion("vplaytime in", values, "vplaytime");
            return (Criteria) this;
        }

        public Criteria andVplaytimeNotIn(List<Integer> values) {
            addCriterion("vplaytime not in", values, "vplaytime");
            return (Criteria) this;
        }

        public Criteria andVplaytimeBetween(Integer value1, Integer value2) {
            addCriterion("vplaytime between", value1, value2, "vplaytime");
            return (Criteria) this;
        }

        public Criteria andVplaytimeNotBetween(Integer value1, Integer value2) {
            addCriterion("vplaytime not between", value1, value2, "vplaytime");
            return (Criteria) this;
        }

        public Criteria andVcollIsNull() {
            addCriterion("vcoll is null");
            return (Criteria) this;
        }

        public Criteria andVcollIsNotNull() {
            addCriterion("vcoll is not null");
            return (Criteria) this;
        }

        public Criteria andVcollEqualTo(Integer value) {
            addCriterion("vcoll =", value, "vcoll");
            return (Criteria) this;
        }

        public Criteria andVcollNotEqualTo(Integer value) {
            addCriterion("vcoll <>", value, "vcoll");
            return (Criteria) this;
        }

        public Criteria andVcollGreaterThan(Integer value) {
            addCriterion("vcoll >", value, "vcoll");
            return (Criteria) this;
        }

        public Criteria andVcollGreaterThanOrEqualTo(Integer value) {
            addCriterion("vcoll >=", value, "vcoll");
            return (Criteria) this;
        }

        public Criteria andVcollLessThan(Integer value) {
            addCriterion("vcoll <", value, "vcoll");
            return (Criteria) this;
        }

        public Criteria andVcollLessThanOrEqualTo(Integer value) {
            addCriterion("vcoll <=", value, "vcoll");
            return (Criteria) this;
        }

        public Criteria andVcollIn(List<Integer> values) {
            addCriterion("vcoll in", values, "vcoll");
            return (Criteria) this;
        }

        public Criteria andVcollNotIn(List<Integer> values) {
            addCriterion("vcoll not in", values, "vcoll");
            return (Criteria) this;
        }

        public Criteria andVcollBetween(Integer value1, Integer value2) {
            addCriterion("vcoll between", value1, value2, "vcoll");
            return (Criteria) this;
        }

        public Criteria andVcollNotBetween(Integer value1, Integer value2) {
            addCriterion("vcoll not between", value1, value2, "vcoll");
            return (Criteria) this;
        }

        public Criteria andVtypeIsNull() {
            addCriterion("vtype is null");
            return (Criteria) this;
        }

        public Criteria andVtypeIsNotNull() {
            addCriterion("vtype is not null");
            return (Criteria) this;
        }

        public Criteria andVtypeEqualTo(String value) {
            addCriterion("vtype =", value, "vtype");
            return (Criteria) this;
        }

        public Criteria andVtypeNotEqualTo(String value) {
            addCriterion("vtype <>", value, "vtype");
            return (Criteria) this;
        }

        public Criteria andVtypeGreaterThan(String value) {
            addCriterion("vtype >", value, "vtype");
            return (Criteria) this;
        }

        public Criteria andVtypeGreaterThanOrEqualTo(String value) {
            addCriterion("vtype >=", value, "vtype");
            return (Criteria) this;
        }

        public Criteria andVtypeLessThan(String value) {
            addCriterion("vtype <", value, "vtype");
            return (Criteria) this;
        }

        public Criteria andVtypeLessThanOrEqualTo(String value) {
            addCriterion("vtype <=", value, "vtype");
            return (Criteria) this;
        }

        public Criteria andVtypeLike(String value) {
            addCriterion("vtype like", value, "vtype");
            return (Criteria) this;
        }

        public Criteria andVtypeNotLike(String value) {
            addCriterion("vtype not like", value, "vtype");
            return (Criteria) this;
        }

        public Criteria andVtypeIn(List<String> values) {
            addCriterion("vtype in", values, "vtype");
            return (Criteria) this;
        }

        public Criteria andVtypeNotIn(List<String> values) {
            addCriterion("vtype not in", values, "vtype");
            return (Criteria) this;
        }

        public Criteria andVtypeBetween(String value1, String value2) {
            addCriterion("vtype between", value1, value2, "vtype");
            return (Criteria) this;
        }

        public Criteria andVtypeNotBetween(String value1, String value2) {
            addCriterion("vtype not between", value1, value2, "vtype");
            return (Criteria) this;
        }

        public Criteria andVcoverIsNull() {
            addCriterion("vcover is null");
            return (Criteria) this;
        }

        public Criteria andVcoverIsNotNull() {
            addCriterion("vcover is not null");
            return (Criteria) this;
        }

        public Criteria andVcoverEqualTo(String value) {
            addCriterion("vcover =", value, "vcover");
            return (Criteria) this;
        }

        public Criteria andVcoverNotEqualTo(String value) {
            addCriterion("vcover <>", value, "vcover");
            return (Criteria) this;
        }

        public Criteria andVcoverGreaterThan(String value) {
            addCriterion("vcover >", value, "vcover");
            return (Criteria) this;
        }

        public Criteria andVcoverGreaterThanOrEqualTo(String value) {
            addCriterion("vcover >=", value, "vcover");
            return (Criteria) this;
        }

        public Criteria andVcoverLessThan(String value) {
            addCriterion("vcover <", value, "vcover");
            return (Criteria) this;
        }

        public Criteria andVcoverLessThanOrEqualTo(String value) {
            addCriterion("vcover <=", value, "vcover");
            return (Criteria) this;
        }

        public Criteria andVcoverLike(String value) {
            addCriterion("vcover like", value, "vcover");
            return (Criteria) this;
        }

        public Criteria andVcoverNotLike(String value) {
            addCriterion("vcover not like", value, "vcover");
            return (Criteria) this;
        }

        public Criteria andVcoverIn(List<String> values) {
            addCriterion("vcover in", values, "vcover");
            return (Criteria) this;
        }

        public Criteria andVcoverNotIn(List<String> values) {
            addCriterion("vcover not in", values, "vcover");
            return (Criteria) this;
        }

        public Criteria andVcoverBetween(String value1, String value2) {
            addCriterion("vcover between", value1, value2, "vcover");
            return (Criteria) this;
        }

        public Criteria andVcoverNotBetween(String value1, String value2) {
            addCriterion("vcover not between", value1, value2, "vcover");
            return (Criteria) this;
        }

        public Criteria andVdateIsNull() {
            addCriterion("vdate is null");
            return (Criteria) this;
        }

        public Criteria andVdateIsNotNull() {
            addCriterion("vdate is not null");
            return (Criteria) this;
        }

        public Criteria andVdateEqualTo(Date value) {
            addCriterionForJDBCDate("vdate =", value, "vdate");
            return (Criteria) this;
        }

        public Criteria andVdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("vdate <>", value, "vdate");
            return (Criteria) this;
        }

        public Criteria andVdateGreaterThan(Date value) {
            addCriterionForJDBCDate("vdate >", value, "vdate");
            return (Criteria) this;
        }

        public Criteria andVdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("vdate >=", value, "vdate");
            return (Criteria) this;
        }

        public Criteria andVdateLessThan(Date value) {
            addCriterionForJDBCDate("vdate <", value, "vdate");
            return (Criteria) this;
        }

        public Criteria andVdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("vdate <=", value, "vdate");
            return (Criteria) this;
        }

        public Criteria andVdateIn(List<Date> values) {
            addCriterionForJDBCDate("vdate in", values, "vdate");
            return (Criteria) this;
        }

        public Criteria andVdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("vdate not in", values, "vdate");
            return (Criteria) this;
        }

        public Criteria andVdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("vdate between", value1, value2, "vdate");
            return (Criteria) this;
        }

        public Criteria andVdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("vdate not between", value1, value2, "vdate");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNull() {
            addCriterion("isdelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(Boolean value) {
            addCriterion("isdelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(Boolean value) {
            addCriterion("isdelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(Boolean value) {
            addCriterion("isdelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isdelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(Boolean value) {
            addCriterion("isdelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("isdelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<Boolean> values) {
            addCriterion("isdelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<Boolean> values) {
            addCriterion("isdelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("isdelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isdelete not between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andVintroduceIsNull() {
            addCriterion("vintroduce is null");
            return (Criteria) this;
        }

        public Criteria andVintroduceIsNotNull() {
            addCriterion("vintroduce is not null");
            return (Criteria) this;
        }

        public Criteria andVintroduceEqualTo(String value) {
            addCriterion("vintroduce =", value, "vintroduce");
            return (Criteria) this;
        }

        public Criteria andVintroduceNotEqualTo(String value) {
            addCriterion("vintroduce <>", value, "vintroduce");
            return (Criteria) this;
        }

        public Criteria andVintroduceGreaterThan(String value) {
            addCriterion("vintroduce >", value, "vintroduce");
            return (Criteria) this;
        }

        public Criteria andVintroduceGreaterThanOrEqualTo(String value) {
            addCriterion("vintroduce >=", value, "vintroduce");
            return (Criteria) this;
        }

        public Criteria andVintroduceLessThan(String value) {
            addCriterion("vintroduce <", value, "vintroduce");
            return (Criteria) this;
        }

        public Criteria andVintroduceLessThanOrEqualTo(String value) {
            addCriterion("vintroduce <=", value, "vintroduce");
            return (Criteria) this;
        }

        public Criteria andVintroduceLike(String value) {
            addCriterion("vintroduce like", value, "vintroduce");
            return (Criteria) this;
        }

        public Criteria andVintroduceNotLike(String value) {
            addCriterion("vintroduce not like", value, "vintroduce");
            return (Criteria) this;
        }

        public Criteria andVintroduceIn(List<String> values) {
            addCriterion("vintroduce in", values, "vintroduce");
            return (Criteria) this;
        }

        public Criteria andVintroduceNotIn(List<String> values) {
            addCriterion("vintroduce not in", values, "vintroduce");
            return (Criteria) this;
        }

        public Criteria andVintroduceBetween(String value1, String value2) {
            addCriterion("vintroduce between", value1, value2, "vintroduce");
            return (Criteria) this;
        }

        public Criteria andVintroduceNotBetween(String value1, String value2) {
            addCriterion("vintroduce not between", value1, value2, "vintroduce");
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