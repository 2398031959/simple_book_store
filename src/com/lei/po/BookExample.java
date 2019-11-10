package com.lei.po;

import java.util.ArrayList;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookExample() {
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

        public Criteria andBidIsNull() {
            addCriterion("bId is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("bId is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(Integer value) {
            addCriterion("bId =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(Integer value) {
            addCriterion("bId <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(Integer value) {
            addCriterion("bId >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bId >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(Integer value) {
            addCriterion("bId <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(Integer value) {
            addCriterion("bId <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<Integer> values) {
            addCriterion("bId in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<Integer> values) {
            addCriterion("bId not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(Integer value1, Integer value2) {
            addCriterion("bId between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(Integer value1, Integer value2) {
            addCriterion("bId not between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBnameIsNull() {
            addCriterion("bName is null");
            return (Criteria) this;
        }

        public Criteria andBnameIsNotNull() {
            addCriterion("bName is not null");
            return (Criteria) this;
        }

        public Criteria andBnameEqualTo(String value) {
            addCriterion("bName =", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotEqualTo(String value) {
            addCriterion("bName <>", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameGreaterThan(String value) {
            addCriterion("bName >", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameGreaterThanOrEqualTo(String value) {
            addCriterion("bName >=", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLessThan(String value) {
            addCriterion("bName <", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLessThanOrEqualTo(String value) {
            addCriterion("bName <=", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLike(String value) {
            addCriterion("bName like", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotLike(String value) {
            addCriterion("bName not like", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameIn(List<String> values) {
            addCriterion("bName in", values, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotIn(List<String> values) {
            addCriterion("bName not in", values, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameBetween(String value1, String value2) {
            addCriterion("bName between", value1, value2, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotBetween(String value1, String value2) {
            addCriterion("bName not between", value1, value2, "bname");
            return (Criteria) this;
        }

        public Criteria andBtypeIsNull() {
            addCriterion("bType is null");
            return (Criteria) this;
        }

        public Criteria andBtypeIsNotNull() {
            addCriterion("bType is not null");
            return (Criteria) this;
        }

        public Criteria andBtypeEqualTo(Integer value) {
            addCriterion("bType =", value, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeNotEqualTo(Integer value) {
            addCriterion("bType <>", value, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeGreaterThan(Integer value) {
            addCriterion("bType >", value, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("bType >=", value, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeLessThan(Integer value) {
            addCriterion("bType <", value, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeLessThanOrEqualTo(Integer value) {
            addCriterion("bType <=", value, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeIn(List<Integer> values) {
            addCriterion("bType in", values, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeNotIn(List<Integer> values) {
            addCriterion("bType not in", values, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeBetween(Integer value1, Integer value2) {
            addCriterion("bType between", value1, value2, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("bType not between", value1, value2, "btype");
            return (Criteria) this;
        }

        public Criteria andBamountIsNull() {
            addCriterion("bAmount is null");
            return (Criteria) this;
        }

        public Criteria andBamountIsNotNull() {
            addCriterion("bAmount is not null");
            return (Criteria) this;
        }

        public Criteria andBamountEqualTo(Integer value) {
            addCriterion("bAmount =", value, "bamount");
            return (Criteria) this;
        }

        public Criteria andBamountNotEqualTo(Integer value) {
            addCriterion("bAmount <>", value, "bamount");
            return (Criteria) this;
        }

        public Criteria andBamountGreaterThan(Integer value) {
            addCriterion("bAmount >", value, "bamount");
            return (Criteria) this;
        }

        public Criteria andBamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("bAmount >=", value, "bamount");
            return (Criteria) this;
        }

        public Criteria andBamountLessThan(Integer value) {
            addCriterion("bAmount <", value, "bamount");
            return (Criteria) this;
        }

        public Criteria andBamountLessThanOrEqualTo(Integer value) {
            addCriterion("bAmount <=", value, "bamount");
            return (Criteria) this;
        }

        public Criteria andBamountIn(List<Integer> values) {
            addCriterion("bAmount in", values, "bamount");
            return (Criteria) this;
        }

        public Criteria andBamountNotIn(List<Integer> values) {
            addCriterion("bAmount not in", values, "bamount");
            return (Criteria) this;
        }

        public Criteria andBamountBetween(Integer value1, Integer value2) {
            addCriterion("bAmount between", value1, value2, "bamount");
            return (Criteria) this;
        }

        public Criteria andBamountNotBetween(Integer value1, Integer value2) {
            addCriterion("bAmount not between", value1, value2, "bamount");
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