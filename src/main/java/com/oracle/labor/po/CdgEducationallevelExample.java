package com.oracle.labor.po;

import java.util.ArrayList;
import java.util.List;

public class CdgEducationallevelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CdgEducationallevelExample() {
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

        public Criteria andCdIdIsNull() {
            addCriterion("cd_id is null");
            return (Criteria) this;
        }

        public Criteria andCdIdIsNotNull() {
            addCriterion("cd_id is not null");
            return (Criteria) this;
        }

        public Criteria andCdIdEqualTo(String value) {
            addCriterion("cd_id =", value, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdIdNotEqualTo(String value) {
            addCriterion("cd_id <>", value, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdIdGreaterThan(String value) {
            addCriterion("cd_id >", value, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdIdGreaterThanOrEqualTo(String value) {
            addCriterion("cd_id >=", value, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdIdLessThan(String value) {
            addCriterion("cd_id <", value, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdIdLessThanOrEqualTo(String value) {
            addCriterion("cd_id <=", value, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdIdLike(String value) {
            addCriterion("cd_id like", value, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdIdNotLike(String value) {
            addCriterion("cd_id not like", value, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdIdIn(List<String> values) {
            addCriterion("cd_id in", values, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdIdNotIn(List<String> values) {
            addCriterion("cd_id not in", values, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdIdBetween(String value1, String value2) {
            addCriterion("cd_id between", value1, value2, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdIdNotBetween(String value1, String value2) {
            addCriterion("cd_id not between", value1, value2, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdNameIsNull() {
            addCriterion("cd_name is null");
            return (Criteria) this;
        }

        public Criteria andCdNameIsNotNull() {
            addCriterion("cd_name is not null");
            return (Criteria) this;
        }

        public Criteria andCdNameEqualTo(String value) {
            addCriterion("cd_name =", value, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameNotEqualTo(String value) {
            addCriterion("cd_name <>", value, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameGreaterThan(String value) {
            addCriterion("cd_name >", value, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameGreaterThanOrEqualTo(String value) {
            addCriterion("cd_name >=", value, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameLessThan(String value) {
            addCriterion("cd_name <", value, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameLessThanOrEqualTo(String value) {
            addCriterion("cd_name <=", value, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameLike(String value) {
            addCriterion("cd_name like", value, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameNotLike(String value) {
            addCriterion("cd_name not like", value, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameIn(List<String> values) {
            addCriterion("cd_name in", values, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameNotIn(List<String> values) {
            addCriterion("cd_name not in", values, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameBetween(String value1, String value2) {
            addCriterion("cd_name between", value1, value2, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameNotBetween(String value1, String value2) {
            addCriterion("cd_name not between", value1, value2, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdAvailabilityIsNull() {
            addCriterion("cd_availability is null");
            return (Criteria) this;
        }

        public Criteria andCdAvailabilityIsNotNull() {
            addCriterion("cd_availability is not null");
            return (Criteria) this;
        }

        public Criteria andCdAvailabilityEqualTo(String value) {
            addCriterion("cd_availability =", value, "cdAvailability");
            return (Criteria) this;
        }

        public Criteria andCdAvailabilityNotEqualTo(String value) {
            addCriterion("cd_availability <>", value, "cdAvailability");
            return (Criteria) this;
        }

        public Criteria andCdAvailabilityGreaterThan(String value) {
            addCriterion("cd_availability >", value, "cdAvailability");
            return (Criteria) this;
        }

        public Criteria andCdAvailabilityGreaterThanOrEqualTo(String value) {
            addCriterion("cd_availability >=", value, "cdAvailability");
            return (Criteria) this;
        }

        public Criteria andCdAvailabilityLessThan(String value) {
            addCriterion("cd_availability <", value, "cdAvailability");
            return (Criteria) this;
        }

        public Criteria andCdAvailabilityLessThanOrEqualTo(String value) {
            addCriterion("cd_availability <=", value, "cdAvailability");
            return (Criteria) this;
        }

        public Criteria andCdAvailabilityLike(String value) {
            addCriterion("cd_availability like", value, "cdAvailability");
            return (Criteria) this;
        }

        public Criteria andCdAvailabilityNotLike(String value) {
            addCriterion("cd_availability not like", value, "cdAvailability");
            return (Criteria) this;
        }

        public Criteria andCdAvailabilityIn(List<String> values) {
            addCriterion("cd_availability in", values, "cdAvailability");
            return (Criteria) this;
        }

        public Criteria andCdAvailabilityNotIn(List<String> values) {
            addCriterion("cd_availability not in", values, "cdAvailability");
            return (Criteria) this;
        }

        public Criteria andCdAvailabilityBetween(String value1, String value2) {
            addCriterion("cd_availability between", value1, value2, "cdAvailability");
            return (Criteria) this;
        }

        public Criteria andCdAvailabilityNotBetween(String value1, String value2) {
            addCriterion("cd_availability not between", value1, value2, "cdAvailability");
            return (Criteria) this;
        }

        public Criteria andCdIndexIsNull() {
            addCriterion("cd_index is null");
            return (Criteria) this;
        }

        public Criteria andCdIndexIsNotNull() {
            addCriterion("cd_index is not null");
            return (Criteria) this;
        }

        public Criteria andCdIndexEqualTo(Integer value) {
            addCriterion("cd_index =", value, "cdIndex");
            return (Criteria) this;
        }

        public Criteria andCdIndexNotEqualTo(Integer value) {
            addCriterion("cd_index <>", value, "cdIndex");
            return (Criteria) this;
        }

        public Criteria andCdIndexGreaterThan(Integer value) {
            addCriterion("cd_index >", value, "cdIndex");
            return (Criteria) this;
        }

        public Criteria andCdIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("cd_index >=", value, "cdIndex");
            return (Criteria) this;
        }

        public Criteria andCdIndexLessThan(Integer value) {
            addCriterion("cd_index <", value, "cdIndex");
            return (Criteria) this;
        }

        public Criteria andCdIndexLessThanOrEqualTo(Integer value) {
            addCriterion("cd_index <=", value, "cdIndex");
            return (Criteria) this;
        }

        public Criteria andCdIndexIn(List<Integer> values) {
            addCriterion("cd_index in", values, "cdIndex");
            return (Criteria) this;
        }

        public Criteria andCdIndexNotIn(List<Integer> values) {
            addCriterion("cd_index not in", values, "cdIndex");
            return (Criteria) this;
        }

        public Criteria andCdIndexBetween(Integer value1, Integer value2) {
            addCriterion("cd_index between", value1, value2, "cdIndex");
            return (Criteria) this;
        }

        public Criteria andCdIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("cd_index not between", value1, value2, "cdIndex");
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