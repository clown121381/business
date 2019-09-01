package com.hd_business.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysAuthorityResourcesExample implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysAuthorityResourcesExample() {
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

        public Criteria andSysRoleAuthorityIdIsNull() {
            addCriterion("sys_role_authority_id is null");
            return (Criteria) this;
        }

        public Criteria andSysRoleAuthorityIdIsNotNull() {
            addCriterion("sys_role_authority_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysRoleAuthorityIdEqualTo(String value) {
            addCriterion("sys_role_authority_id =", value, "sysRoleAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSysRoleAuthorityIdNotEqualTo(String value) {
            addCriterion("sys_role_authority_id <>", value, "sysRoleAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSysRoleAuthorityIdGreaterThan(String value) {
            addCriterion("sys_role_authority_id >", value, "sysRoleAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSysRoleAuthorityIdGreaterThanOrEqualTo(String value) {
            addCriterion("sys_role_authority_id >=", value, "sysRoleAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSysRoleAuthorityIdLessThan(String value) {
            addCriterion("sys_role_authority_id <", value, "sysRoleAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSysRoleAuthorityIdLessThanOrEqualTo(String value) {
            addCriterion("sys_role_authority_id <=", value, "sysRoleAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSysRoleAuthorityIdLike(String value) {
            addCriterion("sys_role_authority_id like", value, "sysRoleAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSysRoleAuthorityIdNotLike(String value) {
            addCriterion("sys_role_authority_id not like", value, "sysRoleAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSysRoleAuthorityIdIn(List<String> values) {
            addCriterion("sys_role_authority_id in", values, "sysRoleAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSysRoleAuthorityIdNotIn(List<String> values) {
            addCriterion("sys_role_authority_id not in", values, "sysRoleAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSysRoleAuthorityIdBetween(String value1, String value2) {
            addCriterion("sys_role_authority_id between", value1, value2, "sysRoleAuthorityId");
            return (Criteria) this;
        }

        public Criteria andSysRoleAuthorityIdNotBetween(String value1, String value2) {
            addCriterion("sys_role_authority_id not between", value1, value2, "sysRoleAuthorityId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdIsNull() {
            addCriterion("resources_id is null");
            return (Criteria) this;
        }

        public Criteria andResourcesIdIsNotNull() {
            addCriterion("resources_id is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesIdEqualTo(String value) {
            addCriterion("resources_id =", value, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdNotEqualTo(String value) {
            addCriterion("resources_id <>", value, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdGreaterThan(String value) {
            addCriterion("resources_id >", value, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdGreaterThanOrEqualTo(String value) {
            addCriterion("resources_id >=", value, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdLessThan(String value) {
            addCriterion("resources_id <", value, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdLessThanOrEqualTo(String value) {
            addCriterion("resources_id <=", value, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdLike(String value) {
            addCriterion("resources_id like", value, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdNotLike(String value) {
            addCriterion("resources_id not like", value, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdIn(List<String> values) {
            addCriterion("resources_id in", values, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdNotIn(List<String> values) {
            addCriterion("resources_id not in", values, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdBetween(String value1, String value2) {
            addCriterion("resources_id between", value1, value2, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdNotBetween(String value1, String value2) {
            addCriterion("resources_id not between", value1, value2, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdIsNull() {
            addCriterion("authority_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdIsNotNull() {
            addCriterion("authority_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdEqualTo(String value) {
            addCriterion("authority_id =", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdNotEqualTo(String value) {
            addCriterion("authority_id <>", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdGreaterThan(String value) {
            addCriterion("authority_id >", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdGreaterThanOrEqualTo(String value) {
            addCriterion("authority_id >=", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdLessThan(String value) {
            addCriterion("authority_id <", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdLessThanOrEqualTo(String value) {
            addCriterion("authority_id <=", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdLike(String value) {
            addCriterion("authority_id like", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdNotLike(String value) {
            addCriterion("authority_id not like", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdIn(List<String> values) {
            addCriterion("authority_id in", values, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdNotIn(List<String> values) {
            addCriterion("authority_id not in", values, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdBetween(String value1, String value2) {
            addCriterion("authority_id between", value1, value2, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdNotBetween(String value1, String value2) {
            addCriterion("authority_id not between", value1, value2, "authorityId");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(String value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(String value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(String value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(String value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(String value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(String value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLike(String value) {
            addCriterion("is_del like", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotLike(String value) {
            addCriterion("is_del not like", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<String> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<String> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(String value1, String value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(String value1, String value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
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

        public Criteria andCTimeStampIsNull() {
            addCriterion("c_time_stamp is null");
            return (Criteria) this;
        }

        public Criteria andCTimeStampIsNotNull() {
            addCriterion("c_time_stamp is not null");
            return (Criteria) this;
        }

        public Criteria andCTimeStampEqualTo(Date value) {
            addCriterion("c_time_stamp =", value, "cTimeStamp");
            return (Criteria) this;
        }

        public Criteria andCTimeStampNotEqualTo(Date value) {
            addCriterion("c_time_stamp <>", value, "cTimeStamp");
            return (Criteria) this;
        }

        public Criteria andCTimeStampGreaterThan(Date value) {
            addCriterion("c_time_stamp >", value, "cTimeStamp");
            return (Criteria) this;
        }

        public Criteria andCTimeStampGreaterThanOrEqualTo(Date value) {
            addCriterion("c_time_stamp >=", value, "cTimeStamp");
            return (Criteria) this;
        }

        public Criteria andCTimeStampLessThan(Date value) {
            addCriterion("c_time_stamp <", value, "cTimeStamp");
            return (Criteria) this;
        }

        public Criteria andCTimeStampLessThanOrEqualTo(Date value) {
            addCriterion("c_time_stamp <=", value, "cTimeStamp");
            return (Criteria) this;
        }

        public Criteria andCTimeStampIn(List<Date> values) {
            addCriterion("c_time_stamp in", values, "cTimeStamp");
            return (Criteria) this;
        }

        public Criteria andCTimeStampNotIn(List<Date> values) {
            addCriterion("c_time_stamp not in", values, "cTimeStamp");
            return (Criteria) this;
        }

        public Criteria andCTimeStampBetween(Date value1, Date value2) {
            addCriterion("c_time_stamp between", value1, value2, "cTimeStamp");
            return (Criteria) this;
        }

        public Criteria andCTimeStampNotBetween(Date value1, Date value2) {
            addCriterion("c_time_stamp not between", value1, value2, "cTimeStamp");
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