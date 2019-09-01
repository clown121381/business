package com.hd_business.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysResourcesExample implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysResourcesExample() {
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

        public Criteria andResourcesNameIsNull() {
            addCriterion("resources_name is null");
            return (Criteria) this;
        }

        public Criteria andResourcesNameIsNotNull() {
            addCriterion("resources_name is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesNameEqualTo(String value) {
            addCriterion("resources_name =", value, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameNotEqualTo(String value) {
            addCriterion("resources_name <>", value, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameGreaterThan(String value) {
            addCriterion("resources_name >", value, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameGreaterThanOrEqualTo(String value) {
            addCriterion("resources_name >=", value, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameLessThan(String value) {
            addCriterion("resources_name <", value, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameLessThanOrEqualTo(String value) {
            addCriterion("resources_name <=", value, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameLike(String value) {
            addCriterion("resources_name like", value, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameNotLike(String value) {
            addCriterion("resources_name not like", value, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameIn(List<String> values) {
            addCriterion("resources_name in", values, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameNotIn(List<String> values) {
            addCriterion("resources_name not in", values, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameBetween(String value1, String value2) {
            addCriterion("resources_name between", value1, value2, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesNameNotBetween(String value1, String value2) {
            addCriterion("resources_name not between", value1, value2, "resourcesName");
            return (Criteria) this;
        }

        public Criteria andResourcesTypeIsNull() {
            addCriterion("resources_type is null");
            return (Criteria) this;
        }

        public Criteria andResourcesTypeIsNotNull() {
            addCriterion("resources_type is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesTypeEqualTo(String value) {
            addCriterion("resources_type =", value, "resourcesType");
            return (Criteria) this;
        }

        public Criteria andResourcesTypeNotEqualTo(String value) {
            addCriterion("resources_type <>", value, "resourcesType");
            return (Criteria) this;
        }

        public Criteria andResourcesTypeGreaterThan(String value) {
            addCriterion("resources_type >", value, "resourcesType");
            return (Criteria) this;
        }

        public Criteria andResourcesTypeGreaterThanOrEqualTo(String value) {
            addCriterion("resources_type >=", value, "resourcesType");
            return (Criteria) this;
        }

        public Criteria andResourcesTypeLessThan(String value) {
            addCriterion("resources_type <", value, "resourcesType");
            return (Criteria) this;
        }

        public Criteria andResourcesTypeLessThanOrEqualTo(String value) {
            addCriterion("resources_type <=", value, "resourcesType");
            return (Criteria) this;
        }

        public Criteria andResourcesTypeLike(String value) {
            addCriterion("resources_type like", value, "resourcesType");
            return (Criteria) this;
        }

        public Criteria andResourcesTypeNotLike(String value) {
            addCriterion("resources_type not like", value, "resourcesType");
            return (Criteria) this;
        }

        public Criteria andResourcesTypeIn(List<String> values) {
            addCriterion("resources_type in", values, "resourcesType");
            return (Criteria) this;
        }

        public Criteria andResourcesTypeNotIn(List<String> values) {
            addCriterion("resources_type not in", values, "resourcesType");
            return (Criteria) this;
        }

        public Criteria andResourcesTypeBetween(String value1, String value2) {
            addCriterion("resources_type between", value1, value2, "resourcesType");
            return (Criteria) this;
        }

        public Criteria andResourcesTypeNotBetween(String value1, String value2) {
            addCriterion("resources_type not between", value1, value2, "resourcesType");
            return (Criteria) this;
        }

        public Criteria andResourcesParentIsNull() {
            addCriterion("resources_parent is null");
            return (Criteria) this;
        }

        public Criteria andResourcesParentIsNotNull() {
            addCriterion("resources_parent is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesParentEqualTo(String value) {
            addCriterion("resources_parent =", value, "resourcesParent");
            return (Criteria) this;
        }

        public Criteria andResourcesParentNotEqualTo(String value) {
            addCriterion("resources_parent <>", value, "resourcesParent");
            return (Criteria) this;
        }

        public Criteria andResourcesParentGreaterThan(String value) {
            addCriterion("resources_parent >", value, "resourcesParent");
            return (Criteria) this;
        }

        public Criteria andResourcesParentGreaterThanOrEqualTo(String value) {
            addCriterion("resources_parent >=", value, "resourcesParent");
            return (Criteria) this;
        }

        public Criteria andResourcesParentLessThan(String value) {
            addCriterion("resources_parent <", value, "resourcesParent");
            return (Criteria) this;
        }

        public Criteria andResourcesParentLessThanOrEqualTo(String value) {
            addCriterion("resources_parent <=", value, "resourcesParent");
            return (Criteria) this;
        }

        public Criteria andResourcesParentLike(String value) {
            addCriterion("resources_parent like", value, "resourcesParent");
            return (Criteria) this;
        }

        public Criteria andResourcesParentNotLike(String value) {
            addCriterion("resources_parent not like", value, "resourcesParent");
            return (Criteria) this;
        }

        public Criteria andResourcesParentIn(List<String> values) {
            addCriterion("resources_parent in", values, "resourcesParent");
            return (Criteria) this;
        }

        public Criteria andResourcesParentNotIn(List<String> values) {
            addCriterion("resources_parent not in", values, "resourcesParent");
            return (Criteria) this;
        }

        public Criteria andResourcesParentBetween(String value1, String value2) {
            addCriterion("resources_parent between", value1, value2, "resourcesParent");
            return (Criteria) this;
        }

        public Criteria andResourcesParentNotBetween(String value1, String value2) {
            addCriterion("resources_parent not between", value1, value2, "resourcesParent");
            return (Criteria) this;
        }

        public Criteria andResourcesLinkIsNull() {
            addCriterion("resources_link is null");
            return (Criteria) this;
        }

        public Criteria andResourcesLinkIsNotNull() {
            addCriterion("resources_link is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesLinkEqualTo(String value) {
            addCriterion("resources_link =", value, "resourcesLink");
            return (Criteria) this;
        }

        public Criteria andResourcesLinkNotEqualTo(String value) {
            addCriterion("resources_link <>", value, "resourcesLink");
            return (Criteria) this;
        }

        public Criteria andResourcesLinkGreaterThan(String value) {
            addCriterion("resources_link >", value, "resourcesLink");
            return (Criteria) this;
        }

        public Criteria andResourcesLinkGreaterThanOrEqualTo(String value) {
            addCriterion("resources_link >=", value, "resourcesLink");
            return (Criteria) this;
        }

        public Criteria andResourcesLinkLessThan(String value) {
            addCriterion("resources_link <", value, "resourcesLink");
            return (Criteria) this;
        }

        public Criteria andResourcesLinkLessThanOrEqualTo(String value) {
            addCriterion("resources_link <=", value, "resourcesLink");
            return (Criteria) this;
        }

        public Criteria andResourcesLinkLike(String value) {
            addCriterion("resources_link like", value, "resourcesLink");
            return (Criteria) this;
        }

        public Criteria andResourcesLinkNotLike(String value) {
            addCriterion("resources_link not like", value, "resourcesLink");
            return (Criteria) this;
        }

        public Criteria andResourcesLinkIn(List<String> values) {
            addCriterion("resources_link in", values, "resourcesLink");
            return (Criteria) this;
        }

        public Criteria andResourcesLinkNotIn(List<String> values) {
            addCriterion("resources_link not in", values, "resourcesLink");
            return (Criteria) this;
        }

        public Criteria andResourcesLinkBetween(String value1, String value2) {
            addCriterion("resources_link between", value1, value2, "resourcesLink");
            return (Criteria) this;
        }

        public Criteria andResourcesLinkNotBetween(String value1, String value2) {
            addCriterion("resources_link not between", value1, value2, "resourcesLink");
            return (Criteria) this;
        }

        public Criteria andResourcesNoteIsNull() {
            addCriterion("resources_note is null");
            return (Criteria) this;
        }

        public Criteria andResourcesNoteIsNotNull() {
            addCriterion("resources_note is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesNoteEqualTo(String value) {
            addCriterion("resources_note =", value, "resourcesNote");
            return (Criteria) this;
        }

        public Criteria andResourcesNoteNotEqualTo(String value) {
            addCriterion("resources_note <>", value, "resourcesNote");
            return (Criteria) this;
        }

        public Criteria andResourcesNoteGreaterThan(String value) {
            addCriterion("resources_note >", value, "resourcesNote");
            return (Criteria) this;
        }

        public Criteria andResourcesNoteGreaterThanOrEqualTo(String value) {
            addCriterion("resources_note >=", value, "resourcesNote");
            return (Criteria) this;
        }

        public Criteria andResourcesNoteLessThan(String value) {
            addCriterion("resources_note <", value, "resourcesNote");
            return (Criteria) this;
        }

        public Criteria andResourcesNoteLessThanOrEqualTo(String value) {
            addCriterion("resources_note <=", value, "resourcesNote");
            return (Criteria) this;
        }

        public Criteria andResourcesNoteLike(String value) {
            addCriterion("resources_note like", value, "resourcesNote");
            return (Criteria) this;
        }

        public Criteria andResourcesNoteNotLike(String value) {
            addCriterion("resources_note not like", value, "resourcesNote");
            return (Criteria) this;
        }

        public Criteria andResourcesNoteIn(List<String> values) {
            addCriterion("resources_note in", values, "resourcesNote");
            return (Criteria) this;
        }

        public Criteria andResourcesNoteNotIn(List<String> values) {
            addCriterion("resources_note not in", values, "resourcesNote");
            return (Criteria) this;
        }

        public Criteria andResourcesNoteBetween(String value1, String value2) {
            addCriterion("resources_note between", value1, value2, "resourcesNote");
            return (Criteria) this;
        }

        public Criteria andResourcesNoteNotBetween(String value1, String value2) {
            addCriterion("resources_note not between", value1, value2, "resourcesNote");
            return (Criteria) this;
        }

        public Criteria andResourcesCodeIsNull() {
            addCriterion("resources_code is null");
            return (Criteria) this;
        }

        public Criteria andResourcesCodeIsNotNull() {
            addCriterion("resources_code is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesCodeEqualTo(String value) {
            addCriterion("resources_code =", value, "resourcesCode");
            return (Criteria) this;
        }

        public Criteria andResourcesCodeNotEqualTo(String value) {
            addCriterion("resources_code <>", value, "resourcesCode");
            return (Criteria) this;
        }

        public Criteria andResourcesCodeGreaterThan(String value) {
            addCriterion("resources_code >", value, "resourcesCode");
            return (Criteria) this;
        }

        public Criteria andResourcesCodeGreaterThanOrEqualTo(String value) {
            addCriterion("resources_code >=", value, "resourcesCode");
            return (Criteria) this;
        }

        public Criteria andResourcesCodeLessThan(String value) {
            addCriterion("resources_code <", value, "resourcesCode");
            return (Criteria) this;
        }

        public Criteria andResourcesCodeLessThanOrEqualTo(String value) {
            addCriterion("resources_code <=", value, "resourcesCode");
            return (Criteria) this;
        }

        public Criteria andResourcesCodeLike(String value) {
            addCriterion("resources_code like", value, "resourcesCode");
            return (Criteria) this;
        }

        public Criteria andResourcesCodeNotLike(String value) {
            addCriterion("resources_code not like", value, "resourcesCode");
            return (Criteria) this;
        }

        public Criteria andResourcesCodeIn(List<String> values) {
            addCriterion("resources_code in", values, "resourcesCode");
            return (Criteria) this;
        }

        public Criteria andResourcesCodeNotIn(List<String> values) {
            addCriterion("resources_code not in", values, "resourcesCode");
            return (Criteria) this;
        }

        public Criteria andResourcesCodeBetween(String value1, String value2) {
            addCriterion("resources_code between", value1, value2, "resourcesCode");
            return (Criteria) this;
        }

        public Criteria andResourcesCodeNotBetween(String value1, String value2) {
            addCriterion("resources_code not between", value1, value2, "resourcesCode");
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

        public Criteria andRankIsNull() {
            addCriterion("rank is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("rank is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(String value) {
            addCriterion("rank =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(String value) {
            addCriterion("rank <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(String value) {
            addCriterion("rank >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(String value) {
            addCriterion("rank >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(String value) {
            addCriterion("rank <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(String value) {
            addCriterion("rank <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLike(String value) {
            addCriterion("rank like", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotLike(String value) {
            addCriterion("rank not like", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(List<String> values) {
            addCriterion("rank in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(List<String> values) {
            addCriterion("rank not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(String value1, String value2) {
            addCriterion("rank between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(String value1, String value2) {
            addCriterion("rank not between", value1, value2, "rank");
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