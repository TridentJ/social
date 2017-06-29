package com.jiyufei.social.bean;

import java.util.ArrayList;
import java.util.List;

public class SocialRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SocialRecordExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRecordNumIsNull() {
            addCriterion("record_num is null");
            return (Criteria) this;
        }

        public Criteria andRecordNumIsNotNull() {
            addCriterion("record_num is not null");
            return (Criteria) this;
        }

        public Criteria andRecordNumEqualTo(Integer value) {
            addCriterion("record_num =", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumNotEqualTo(Integer value) {
            addCriterion("record_num <>", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumGreaterThan(Integer value) {
            addCriterion("record_num >", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_num >=", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumLessThan(Integer value) {
            addCriterion("record_num <", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumLessThanOrEqualTo(Integer value) {
            addCriterion("record_num <=", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumIn(List<Integer> values) {
            addCriterion("record_num in", values, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumNotIn(List<Integer> values) {
            addCriterion("record_num not in", values, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumBetween(Integer value1, Integer value2) {
            addCriterion("record_num between", value1, value2, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumNotBetween(Integer value1, Integer value2) {
            addCriterion("record_num not between", value1, value2, "recordNum");
            return (Criteria) this;
        }

        public Criteria andSelectNumIsNull() {
            addCriterion("select_num is null");
            return (Criteria) this;
        }

        public Criteria andSelectNumIsNotNull() {
            addCriterion("select_num is not null");
            return (Criteria) this;
        }

        public Criteria andSelectNumEqualTo(Integer value) {
            addCriterion("select_num =", value, "selectNum");
            return (Criteria) this;
        }

        public Criteria andSelectNumNotEqualTo(Integer value) {
            addCriterion("select_num <>", value, "selectNum");
            return (Criteria) this;
        }

        public Criteria andSelectNumGreaterThan(Integer value) {
            addCriterion("select_num >", value, "selectNum");
            return (Criteria) this;
        }

        public Criteria andSelectNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("select_num >=", value, "selectNum");
            return (Criteria) this;
        }

        public Criteria andSelectNumLessThan(Integer value) {
            addCriterion("select_num <", value, "selectNum");
            return (Criteria) this;
        }

        public Criteria andSelectNumLessThanOrEqualTo(Integer value) {
            addCriterion("select_num <=", value, "selectNum");
            return (Criteria) this;
        }

        public Criteria andSelectNumIn(List<Integer> values) {
            addCriterion("select_num in", values, "selectNum");
            return (Criteria) this;
        }

        public Criteria andSelectNumNotIn(List<Integer> values) {
            addCriterion("select_num not in", values, "selectNum");
            return (Criteria) this;
        }

        public Criteria andSelectNumBetween(Integer value1, Integer value2) {
            addCriterion("select_num between", value1, value2, "selectNum");
            return (Criteria) this;
        }

        public Criteria andSelectNumNotBetween(Integer value1, Integer value2) {
            addCriterion("select_num not between", value1, value2, "selectNum");
            return (Criteria) this;
        }

        public Criteria andHitNumIsNull() {
            addCriterion("hit_num is null");
            return (Criteria) this;
        }

        public Criteria andHitNumIsNotNull() {
            addCriterion("hit_num is not null");
            return (Criteria) this;
        }

        public Criteria andHitNumEqualTo(Integer value) {
            addCriterion("hit_num =", value, "hitNum");
            return (Criteria) this;
        }

        public Criteria andHitNumNotEqualTo(Integer value) {
            addCriterion("hit_num <>", value, "hitNum");
            return (Criteria) this;
        }

        public Criteria andHitNumGreaterThan(Integer value) {
            addCriterion("hit_num >", value, "hitNum");
            return (Criteria) this;
        }

        public Criteria andHitNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("hit_num >=", value, "hitNum");
            return (Criteria) this;
        }

        public Criteria andHitNumLessThan(Integer value) {
            addCriterion("hit_num <", value, "hitNum");
            return (Criteria) this;
        }

        public Criteria andHitNumLessThanOrEqualTo(Integer value) {
            addCriterion("hit_num <=", value, "hitNum");
            return (Criteria) this;
        }

        public Criteria andHitNumIn(List<Integer> values) {
            addCriterion("hit_num in", values, "hitNum");
            return (Criteria) this;
        }

        public Criteria andHitNumNotIn(List<Integer> values) {
            addCriterion("hit_num not in", values, "hitNum");
            return (Criteria) this;
        }

        public Criteria andHitNumBetween(Integer value1, Integer value2) {
            addCriterion("hit_num between", value1, value2, "hitNum");
            return (Criteria) this;
        }

        public Criteria andHitNumNotBetween(Integer value1, Integer value2) {
            addCriterion("hit_num not between", value1, value2, "hitNum");
            return (Criteria) this;
        }

        public Criteria andDropsNumIsNull() {
            addCriterion("drops_num is null");
            return (Criteria) this;
        }

        public Criteria andDropsNumIsNotNull() {
            addCriterion("drops_num is not null");
            return (Criteria) this;
        }

        public Criteria andDropsNumEqualTo(Integer value) {
            addCriterion("drops_num =", value, "dropsNum");
            return (Criteria) this;
        }

        public Criteria andDropsNumNotEqualTo(Integer value) {
            addCriterion("drops_num <>", value, "dropsNum");
            return (Criteria) this;
        }

        public Criteria andDropsNumGreaterThan(Integer value) {
            addCriterion("drops_num >", value, "dropsNum");
            return (Criteria) this;
        }

        public Criteria andDropsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("drops_num >=", value, "dropsNum");
            return (Criteria) this;
        }

        public Criteria andDropsNumLessThan(Integer value) {
            addCriterion("drops_num <", value, "dropsNum");
            return (Criteria) this;
        }

        public Criteria andDropsNumLessThanOrEqualTo(Integer value) {
            addCriterion("drops_num <=", value, "dropsNum");
            return (Criteria) this;
        }

        public Criteria andDropsNumIn(List<Integer> values) {
            addCriterion("drops_num in", values, "dropsNum");
            return (Criteria) this;
        }

        public Criteria andDropsNumNotIn(List<Integer> values) {
            addCriterion("drops_num not in", values, "dropsNum");
            return (Criteria) this;
        }

        public Criteria andDropsNumBetween(Integer value1, Integer value2) {
            addCriterion("drops_num between", value1, value2, "dropsNum");
            return (Criteria) this;
        }

        public Criteria andDropsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("drops_num not between", value1, value2, "dropsNum");
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