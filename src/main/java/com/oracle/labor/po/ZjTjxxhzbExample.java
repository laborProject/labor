package com.oracle.labor.po;

import java.util.ArrayList;
import java.util.List;

public class ZjTjxxhzbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZjTjxxhzbExample() {
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

        public Criteria andTjxidIsNull() {
            addCriterion("TJXID is null");
            return (Criteria) this;
        }

        public Criteria andTjxidIsNotNull() {
            addCriterion("TJXID is not null");
            return (Criteria) this;
        }

        public Criteria andTjxidEqualTo(String value) {
            addCriterion("TJXID =", value, "tjxid");
            return (Criteria) this;
        }

        public Criteria andTjxidNotEqualTo(String value) {
            addCriterion("TJXID <>", value, "tjxid");
            return (Criteria) this;
        }

        public Criteria andTjxidGreaterThan(String value) {
            addCriterion("TJXID >", value, "tjxid");
            return (Criteria) this;
        }

        public Criteria andTjxidGreaterThanOrEqualTo(String value) {
            addCriterion("TJXID >=", value, "tjxid");
            return (Criteria) this;
        }

        public Criteria andTjxidLessThan(String value) {
            addCriterion("TJXID <", value, "tjxid");
            return (Criteria) this;
        }

        public Criteria andTjxidLessThanOrEqualTo(String value) {
            addCriterion("TJXID <=", value, "tjxid");
            return (Criteria) this;
        }

        public Criteria andTjxidLike(String value) {
            addCriterion("TJXID like", value, "tjxid");
            return (Criteria) this;
        }

        public Criteria andTjxidNotLike(String value) {
            addCriterion("TJXID not like", value, "tjxid");
            return (Criteria) this;
        }

        public Criteria andTjxidIn(List<String> values) {
            addCriterion("TJXID in", values, "tjxid");
            return (Criteria) this;
        }

        public Criteria andTjxidNotIn(List<String> values) {
            addCriterion("TJXID not in", values, "tjxid");
            return (Criteria) this;
        }

        public Criteria andTjxidBetween(String value1, String value2) {
            addCriterion("TJXID between", value1, value2, "tjxid");
            return (Criteria) this;
        }

        public Criteria andTjxidNotBetween(String value1, String value2) {
            addCriterion("TJXID not between", value1, value2, "tjxid");
            return (Criteria) this;
        }

        public Criteria andTjxlxIsNull() {
            addCriterion("TJXLX is null");
            return (Criteria) this;
        }

        public Criteria andTjxlxIsNotNull() {
            addCriterion("TJXLX is not null");
            return (Criteria) this;
        }

        public Criteria andTjxlxEqualTo(String value) {
            addCriterion("TJXLX =", value, "tjxlx");
            return (Criteria) this;
        }

        public Criteria andTjxlxNotEqualTo(String value) {
            addCriterion("TJXLX <>", value, "tjxlx");
            return (Criteria) this;
        }

        public Criteria andTjxlxGreaterThan(String value) {
            addCriterion("TJXLX >", value, "tjxlx");
            return (Criteria) this;
        }

        public Criteria andTjxlxGreaterThanOrEqualTo(String value) {
            addCriterion("TJXLX >=", value, "tjxlx");
            return (Criteria) this;
        }

        public Criteria andTjxlxLessThan(String value) {
            addCriterion("TJXLX <", value, "tjxlx");
            return (Criteria) this;
        }

        public Criteria andTjxlxLessThanOrEqualTo(String value) {
            addCriterion("TJXLX <=", value, "tjxlx");
            return (Criteria) this;
        }

        public Criteria andTjxlxLike(String value) {
            addCriterion("TJXLX like", value, "tjxlx");
            return (Criteria) this;
        }

        public Criteria andTjxlxNotLike(String value) {
            addCriterion("TJXLX not like", value, "tjxlx");
            return (Criteria) this;
        }

        public Criteria andTjxlxIn(List<String> values) {
            addCriterion("TJXLX in", values, "tjxlx");
            return (Criteria) this;
        }

        public Criteria andTjxlxNotIn(List<String> values) {
            addCriterion("TJXLX not in", values, "tjxlx");
            return (Criteria) this;
        }

        public Criteria andTjxlxBetween(String value1, String value2) {
            addCriterion("TJXLX between", value1, value2, "tjxlx");
            return (Criteria) this;
        }

        public Criteria andTjxlxNotBetween(String value1, String value2) {
            addCriterion("TJXLX not between", value1, value2, "tjxlx");
            return (Criteria) this;
        }

        public Criteria andQzgzbhIsNull() {
            addCriterion("QZGZBH is null");
            return (Criteria) this;
        }

        public Criteria andQzgzbhIsNotNull() {
            addCriterion("QZGZBH is not null");
            return (Criteria) this;
        }

        public Criteria andQzgzbhEqualTo(String value) {
            addCriterion("QZGZBH =", value, "qzgzbh");
            return (Criteria) this;
        }

        public Criteria andQzgzbhNotEqualTo(String value) {
            addCriterion("QZGZBH <>", value, "qzgzbh");
            return (Criteria) this;
        }

        public Criteria andQzgzbhGreaterThan(String value) {
            addCriterion("QZGZBH >", value, "qzgzbh");
            return (Criteria) this;
        }

        public Criteria andQzgzbhGreaterThanOrEqualTo(String value) {
            addCriterion("QZGZBH >=", value, "qzgzbh");
            return (Criteria) this;
        }

        public Criteria andQzgzbhLessThan(String value) {
            addCriterion("QZGZBH <", value, "qzgzbh");
            return (Criteria) this;
        }

        public Criteria andQzgzbhLessThanOrEqualTo(String value) {
            addCriterion("QZGZBH <=", value, "qzgzbh");
            return (Criteria) this;
        }

        public Criteria andQzgzbhLike(String value) {
            addCriterion("QZGZBH like", value, "qzgzbh");
            return (Criteria) this;
        }

        public Criteria andQzgzbhNotLike(String value) {
            addCriterion("QZGZBH not like", value, "qzgzbh");
            return (Criteria) this;
        }

        public Criteria andQzgzbhIn(List<String> values) {
            addCriterion("QZGZBH in", values, "qzgzbh");
            return (Criteria) this;
        }

        public Criteria andQzgzbhNotIn(List<String> values) {
            addCriterion("QZGZBH not in", values, "qzgzbh");
            return (Criteria) this;
        }

        public Criteria andQzgzbhBetween(String value1, String value2) {
            addCriterion("QZGZBH between", value1, value2, "qzgzbh");
            return (Criteria) this;
        }

        public Criteria andQzgzbhNotBetween(String value1, String value2) {
            addCriterion("QZGZBH not between", value1, value2, "qzgzbh");
            return (Criteria) this;
        }

        public Criteria andZpgzbhIsNull() {
            addCriterion("ZPGZBH is null");
            return (Criteria) this;
        }

        public Criteria andZpgzbhIsNotNull() {
            addCriterion("ZPGZBH is not null");
            return (Criteria) this;
        }

        public Criteria andZpgzbhEqualTo(String value) {
            addCriterion("ZPGZBH =", value, "zpgzbh");
            return (Criteria) this;
        }

        public Criteria andZpgzbhNotEqualTo(String value) {
            addCriterion("ZPGZBH <>", value, "zpgzbh");
            return (Criteria) this;
        }

        public Criteria andZpgzbhGreaterThan(String value) {
            addCriterion("ZPGZBH >", value, "zpgzbh");
            return (Criteria) this;
        }

        public Criteria andZpgzbhGreaterThanOrEqualTo(String value) {
            addCriterion("ZPGZBH >=", value, "zpgzbh");
            return (Criteria) this;
        }

        public Criteria andZpgzbhLessThan(String value) {
            addCriterion("ZPGZBH <", value, "zpgzbh");
            return (Criteria) this;
        }

        public Criteria andZpgzbhLessThanOrEqualTo(String value) {
            addCriterion("ZPGZBH <=", value, "zpgzbh");
            return (Criteria) this;
        }

        public Criteria andZpgzbhLike(String value) {
            addCriterion("ZPGZBH like", value, "zpgzbh");
            return (Criteria) this;
        }

        public Criteria andZpgzbhNotLike(String value) {
            addCriterion("ZPGZBH not like", value, "zpgzbh");
            return (Criteria) this;
        }

        public Criteria andZpgzbhIn(List<String> values) {
            addCriterion("ZPGZBH in", values, "zpgzbh");
            return (Criteria) this;
        }

        public Criteria andZpgzbhNotIn(List<String> values) {
            addCriterion("ZPGZBH not in", values, "zpgzbh");
            return (Criteria) this;
        }

        public Criteria andZpgzbhBetween(String value1, String value2) {
            addCriterion("ZPGZBH between", value1, value2, "zpgzbh");
            return (Criteria) this;
        }

        public Criteria andZpgzbhNotBetween(String value1, String value2) {
            addCriterion("ZPGZBH not between", value1, value2, "zpgzbh");
            return (Criteria) this;
        }

        public Criteria andTjsjIsNull() {
            addCriterion("TJSJ is null");
            return (Criteria) this;
        }

        public Criteria andTjsjIsNotNull() {
            addCriterion("TJSJ is not null");
            return (Criteria) this;
        }

        public Criteria andTjsjEqualTo(String value) {
            addCriterion("TJSJ =", value, "tjsj");
            return (Criteria) this;
        }

        public Criteria andTjsjNotEqualTo(String value) {
            addCriterion("TJSJ <>", value, "tjsj");
            return (Criteria) this;
        }

        public Criteria andTjsjGreaterThan(String value) {
            addCriterion("TJSJ >", value, "tjsj");
            return (Criteria) this;
        }

        public Criteria andTjsjGreaterThanOrEqualTo(String value) {
            addCriterion("TJSJ >=", value, "tjsj");
            return (Criteria) this;
        }

        public Criteria andTjsjLessThan(String value) {
            addCriterion("TJSJ <", value, "tjsj");
            return (Criteria) this;
        }

        public Criteria andTjsjLessThanOrEqualTo(String value) {
            addCriterion("TJSJ <=", value, "tjsj");
            return (Criteria) this;
        }

        public Criteria andTjsjLike(String value) {
            addCriterion("TJSJ like", value, "tjsj");
            return (Criteria) this;
        }

        public Criteria andTjsjNotLike(String value) {
            addCriterion("TJSJ not like", value, "tjsj");
            return (Criteria) this;
        }

        public Criteria andTjsjIn(List<String> values) {
            addCriterion("TJSJ in", values, "tjsj");
            return (Criteria) this;
        }

        public Criteria andTjsjNotIn(List<String> values) {
            addCriterion("TJSJ not in", values, "tjsj");
            return (Criteria) this;
        }

        public Criteria andTjsjBetween(String value1, String value2) {
            addCriterion("TJSJ between", value1, value2, "tjsj");
            return (Criteria) this;
        }

        public Criteria andTjsjNotBetween(String value1, String value2) {
            addCriterion("TJSJ not between", value1, value2, "tjsj");
            return (Criteria) this;
        }

        public Criteria andSfcgIsNull() {
            addCriterion("SFCG is null");
            return (Criteria) this;
        }

        public Criteria andSfcgIsNotNull() {
            addCriterion("SFCG is not null");
            return (Criteria) this;
        }

        public Criteria andSfcgEqualTo(String value) {
            addCriterion("SFCG =", value, "sfcg");
            return (Criteria) this;
        }

        public Criteria andSfcgNotEqualTo(String value) {
            addCriterion("SFCG <>", value, "sfcg");
            return (Criteria) this;
        }

        public Criteria andSfcgGreaterThan(String value) {
            addCriterion("SFCG >", value, "sfcg");
            return (Criteria) this;
        }

        public Criteria andSfcgGreaterThanOrEqualTo(String value) {
            addCriterion("SFCG >=", value, "sfcg");
            return (Criteria) this;
        }

        public Criteria andSfcgLessThan(String value) {
            addCriterion("SFCG <", value, "sfcg");
            return (Criteria) this;
        }

        public Criteria andSfcgLessThanOrEqualTo(String value) {
            addCriterion("SFCG <=", value, "sfcg");
            return (Criteria) this;
        }

        public Criteria andSfcgLike(String value) {
            addCriterion("SFCG like", value, "sfcg");
            return (Criteria) this;
        }

        public Criteria andSfcgNotLike(String value) {
            addCriterion("SFCG not like", value, "sfcg");
            return (Criteria) this;
        }

        public Criteria andSfcgIn(List<String> values) {
            addCriterion("SFCG in", values, "sfcg");
            return (Criteria) this;
        }

        public Criteria andSfcgNotIn(List<String> values) {
            addCriterion("SFCG not in", values, "sfcg");
            return (Criteria) this;
        }

        public Criteria andSfcgBetween(String value1, String value2) {
            addCriterion("SFCG between", value1, value2, "sfcg");
            return (Criteria) this;
        }

        public Criteria andSfcgNotBetween(String value1, String value2) {
            addCriterion("SFCG not between", value1, value2, "sfcg");
            return (Criteria) this;
        }

        public Criteria andJyyxIsNull() {
            addCriterion("JYYX is null");
            return (Criteria) this;
        }

        public Criteria andJyyxIsNotNull() {
            addCriterion("JYYX is not null");
            return (Criteria) this;
        }

        public Criteria andJyyxEqualTo(String value) {
            addCriterion("JYYX =", value, "jyyx");
            return (Criteria) this;
        }

        public Criteria andJyyxNotEqualTo(String value) {
            addCriterion("JYYX <>", value, "jyyx");
            return (Criteria) this;
        }

        public Criteria andJyyxGreaterThan(String value) {
            addCriterion("JYYX >", value, "jyyx");
            return (Criteria) this;
        }

        public Criteria andJyyxGreaterThanOrEqualTo(String value) {
            addCriterion("JYYX >=", value, "jyyx");
            return (Criteria) this;
        }

        public Criteria andJyyxLessThan(String value) {
            addCriterion("JYYX <", value, "jyyx");
            return (Criteria) this;
        }

        public Criteria andJyyxLessThanOrEqualTo(String value) {
            addCriterion("JYYX <=", value, "jyyx");
            return (Criteria) this;
        }

        public Criteria andJyyxLike(String value) {
            addCriterion("JYYX like", value, "jyyx");
            return (Criteria) this;
        }

        public Criteria andJyyxNotLike(String value) {
            addCriterion("JYYX not like", value, "jyyx");
            return (Criteria) this;
        }

        public Criteria andJyyxIn(List<String> values) {
            addCriterion("JYYX in", values, "jyyx");
            return (Criteria) this;
        }

        public Criteria andJyyxNotIn(List<String> values) {
            addCriterion("JYYX not in", values, "jyyx");
            return (Criteria) this;
        }

        public Criteria andJyyxBetween(String value1, String value2) {
            addCriterion("JYYX between", value1, value2, "jyyx");
            return (Criteria) this;
        }

        public Criteria andJyyxNotBetween(String value1, String value2) {
            addCriterion("JYYX not between", value1, value2, "jyyx");
            return (Criteria) this;
        }

        public Criteria andBcgyyIsNull() {
            addCriterion("BCGYY is null");
            return (Criteria) this;
        }

        public Criteria andBcgyyIsNotNull() {
            addCriterion("BCGYY is not null");
            return (Criteria) this;
        }

        public Criteria andBcgyyEqualTo(String value) {
            addCriterion("BCGYY =", value, "bcgyy");
            return (Criteria) this;
        }

        public Criteria andBcgyyNotEqualTo(String value) {
            addCriterion("BCGYY <>", value, "bcgyy");
            return (Criteria) this;
        }

        public Criteria andBcgyyGreaterThan(String value) {
            addCriterion("BCGYY >", value, "bcgyy");
            return (Criteria) this;
        }

        public Criteria andBcgyyGreaterThanOrEqualTo(String value) {
            addCriterion("BCGYY >=", value, "bcgyy");
            return (Criteria) this;
        }

        public Criteria andBcgyyLessThan(String value) {
            addCriterion("BCGYY <", value, "bcgyy");
            return (Criteria) this;
        }

        public Criteria andBcgyyLessThanOrEqualTo(String value) {
            addCriterion("BCGYY <=", value, "bcgyy");
            return (Criteria) this;
        }

        public Criteria andBcgyyLike(String value) {
            addCriterion("BCGYY like", value, "bcgyy");
            return (Criteria) this;
        }

        public Criteria andBcgyyNotLike(String value) {
            addCriterion("BCGYY not like", value, "bcgyy");
            return (Criteria) this;
        }

        public Criteria andBcgyyIn(List<String> values) {
            addCriterion("BCGYY in", values, "bcgyy");
            return (Criteria) this;
        }

        public Criteria andBcgyyNotIn(List<String> values) {
            addCriterion("BCGYY not in", values, "bcgyy");
            return (Criteria) this;
        }

        public Criteria andBcgyyBetween(String value1, String value2) {
            addCriterion("BCGYY between", value1, value2, "bcgyy");
            return (Criteria) this;
        }

        public Criteria andBcgyyNotBetween(String value1, String value2) {
            addCriterion("BCGYY not between", value1, value2, "bcgyy");
            return (Criteria) this;
        }

        public Criteria andSfhzIsNull() {
            addCriterion("SFHZ is null");
            return (Criteria) this;
        }

        public Criteria andSfhzIsNotNull() {
            addCriterion("SFHZ is not null");
            return (Criteria) this;
        }

        public Criteria andSfhzEqualTo(String value) {
            addCriterion("SFHZ =", value, "sfhz");
            return (Criteria) this;
        }

        public Criteria andSfhzNotEqualTo(String value) {
            addCriterion("SFHZ <>", value, "sfhz");
            return (Criteria) this;
        }

        public Criteria andSfhzGreaterThan(String value) {
            addCriterion("SFHZ >", value, "sfhz");
            return (Criteria) this;
        }

        public Criteria andSfhzGreaterThanOrEqualTo(String value) {
            addCriterion("SFHZ >=", value, "sfhz");
            return (Criteria) this;
        }

        public Criteria andSfhzLessThan(String value) {
            addCriterion("SFHZ <", value, "sfhz");
            return (Criteria) this;
        }

        public Criteria andSfhzLessThanOrEqualTo(String value) {
            addCriterion("SFHZ <=", value, "sfhz");
            return (Criteria) this;
        }

        public Criteria andSfhzLike(String value) {
            addCriterion("SFHZ like", value, "sfhz");
            return (Criteria) this;
        }

        public Criteria andSfhzNotLike(String value) {
            addCriterion("SFHZ not like", value, "sfhz");
            return (Criteria) this;
        }

        public Criteria andSfhzIn(List<String> values) {
            addCriterion("SFHZ in", values, "sfhz");
            return (Criteria) this;
        }

        public Criteria andSfhzNotIn(List<String> values) {
            addCriterion("SFHZ not in", values, "sfhz");
            return (Criteria) this;
        }

        public Criteria andSfhzBetween(String value1, String value2) {
            addCriterion("SFHZ between", value1, value2, "sfhz");
            return (Criteria) this;
        }

        public Criteria andSfhzNotBetween(String value1, String value2) {
            addCriterion("SFHZ not between", value1, value2, "sfhz");
            return (Criteria) this;
        }

        public Criteria andHzsjIsNull() {
            addCriterion("HZSJ is null");
            return (Criteria) this;
        }

        public Criteria andHzsjIsNotNull() {
            addCriterion("HZSJ is not null");
            return (Criteria) this;
        }

        public Criteria andHzsjEqualTo(String value) {
            addCriterion("HZSJ =", value, "hzsj");
            return (Criteria) this;
        }

        public Criteria andHzsjNotEqualTo(String value) {
            addCriterion("HZSJ <>", value, "hzsj");
            return (Criteria) this;
        }

        public Criteria andHzsjGreaterThan(String value) {
            addCriterion("HZSJ >", value, "hzsj");
            return (Criteria) this;
        }

        public Criteria andHzsjGreaterThanOrEqualTo(String value) {
            addCriterion("HZSJ >=", value, "hzsj");
            return (Criteria) this;
        }

        public Criteria andHzsjLessThan(String value) {
            addCriterion("HZSJ <", value, "hzsj");
            return (Criteria) this;
        }

        public Criteria andHzsjLessThanOrEqualTo(String value) {
            addCriterion("HZSJ <=", value, "hzsj");
            return (Criteria) this;
        }

        public Criteria andHzsjLike(String value) {
            addCriterion("HZSJ like", value, "hzsj");
            return (Criteria) this;
        }

        public Criteria andHzsjNotLike(String value) {
            addCriterion("HZSJ not like", value, "hzsj");
            return (Criteria) this;
        }

        public Criteria andHzsjIn(List<String> values) {
            addCriterion("HZSJ in", values, "hzsj");
            return (Criteria) this;
        }

        public Criteria andHzsjNotIn(List<String> values) {
            addCriterion("HZSJ not in", values, "hzsj");
            return (Criteria) this;
        }

        public Criteria andHzsjBetween(String value1, String value2) {
            addCriterion("HZSJ between", value1, value2, "hzsj");
            return (Criteria) this;
        }

        public Criteria andHzsjNotBetween(String value1, String value2) {
            addCriterion("HZSJ not between", value1, value2, "hzsj");
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