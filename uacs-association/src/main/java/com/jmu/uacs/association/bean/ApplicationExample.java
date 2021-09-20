package com.jmu.uacs.association.bean;

import java.util.ArrayList;
import java.util.List;

public class ApplicationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplicationExample() {
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

        public Criteria andApplicationIdIsNull() {
            addCriterion("application_id is null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIsNotNull() {
            addCriterion("application_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdEqualTo(Integer value) {
            addCriterion("application_id =", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotEqualTo(Integer value) {
            addCriterion("application_id <>", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThan(Integer value) {
            addCriterion("application_id >", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("application_id >=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThan(Integer value) {
            addCriterion("application_id <", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThanOrEqualTo(Integer value) {
            addCriterion("application_id <=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIn(List<Integer> values) {
            addCriterion("application_id in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotIn(List<Integer> values) {
            addCriterion("application_id not in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdBetween(Integer value1, Integer value2) {
            addCriterion("application_id between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("application_id not between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlIsNull() {
            addCriterion("photo_url is null");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlIsNotNull() {
            addCriterion("photo_url is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlEqualTo(String value) {
            addCriterion("photo_url =", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotEqualTo(String value) {
            addCriterion("photo_url <>", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlGreaterThan(String value) {
            addCriterion("photo_url >", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("photo_url >=", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlLessThan(String value) {
            addCriterion("photo_url <", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlLessThanOrEqualTo(String value) {
            addCriterion("photo_url <=", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlLike(String value) {
            addCriterion("photo_url like", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotLike(String value) {
            addCriterion("photo_url not like", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlIn(List<String> values) {
            addCriterion("photo_url in", values, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotIn(List<String> values) {
            addCriterion("photo_url not in", values, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlBetween(String value1, String value2) {
            addCriterion("photo_url between", value1, value2, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotBetween(String value1, String value2) {
            addCriterion("photo_url not between", value1, value2, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentNameIsNull() {
            addCriterion("intention_department_name is null");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentNameIsNotNull() {
            addCriterion("intention_department_name is not null");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentNameEqualTo(String value) {
            addCriterion("intention_department_name =", value, "intentionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentNameNotEqualTo(String value) {
            addCriterion("intention_department_name <>", value, "intentionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentNameGreaterThan(String value) {
            addCriterion("intention_department_name >", value, "intentionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("intention_department_name >=", value, "intentionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentNameLessThan(String value) {
            addCriterion("intention_department_name <", value, "intentionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("intention_department_name <=", value, "intentionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentNameLike(String value) {
            addCriterion("intention_department_name like", value, "intentionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentNameNotLike(String value) {
            addCriterion("intention_department_name not like", value, "intentionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentNameIn(List<String> values) {
            addCriterion("intention_department_name in", values, "intentionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentNameNotIn(List<String> values) {
            addCriterion("intention_department_name not in", values, "intentionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentNameBetween(String value1, String value2) {
            addCriterion("intention_department_name between", value1, value2, "intentionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("intention_department_name not between", value1, value2, "intentionDepartmentName");
            return (Criteria) this;
        }

        public Criteria andSelfProfileIsNull() {
            addCriterion("self_profile is null");
            return (Criteria) this;
        }

        public Criteria andSelfProfileIsNotNull() {
            addCriterion("self_profile is not null");
            return (Criteria) this;
        }

        public Criteria andSelfProfileEqualTo(String value) {
            addCriterion("self_profile =", value, "selfProfile");
            return (Criteria) this;
        }

        public Criteria andSelfProfileNotEqualTo(String value) {
            addCriterion("self_profile <>", value, "selfProfile");
            return (Criteria) this;
        }

        public Criteria andSelfProfileGreaterThan(String value) {
            addCriterion("self_profile >", value, "selfProfile");
            return (Criteria) this;
        }

        public Criteria andSelfProfileGreaterThanOrEqualTo(String value) {
            addCriterion("self_profile >=", value, "selfProfile");
            return (Criteria) this;
        }

        public Criteria andSelfProfileLessThan(String value) {
            addCriterion("self_profile <", value, "selfProfile");
            return (Criteria) this;
        }

        public Criteria andSelfProfileLessThanOrEqualTo(String value) {
            addCriterion("self_profile <=", value, "selfProfile");
            return (Criteria) this;
        }

        public Criteria andSelfProfileLike(String value) {
            addCriterion("self_profile like", value, "selfProfile");
            return (Criteria) this;
        }

        public Criteria andSelfProfileNotLike(String value) {
            addCriterion("self_profile not like", value, "selfProfile");
            return (Criteria) this;
        }

        public Criteria andSelfProfileIn(List<String> values) {
            addCriterion("self_profile in", values, "selfProfile");
            return (Criteria) this;
        }

        public Criteria andSelfProfileNotIn(List<String> values) {
            addCriterion("self_profile not in", values, "selfProfile");
            return (Criteria) this;
        }

        public Criteria andSelfProfileBetween(String value1, String value2) {
            addCriterion("self_profile between", value1, value2, "selfProfile");
            return (Criteria) this;
        }

        public Criteria andSelfProfileNotBetween(String value1, String value2) {
            addCriterion("self_profile not between", value1, value2, "selfProfile");
            return (Criteria) this;
        }

        public Criteria andJoinPurposeIsNull() {
            addCriterion("join_purpose is null");
            return (Criteria) this;
        }

        public Criteria andJoinPurposeIsNotNull() {
            addCriterion("join_purpose is not null");
            return (Criteria) this;
        }

        public Criteria andJoinPurposeEqualTo(String value) {
            addCriterion("join_purpose =", value, "joinPurpose");
            return (Criteria) this;
        }

        public Criteria andJoinPurposeNotEqualTo(String value) {
            addCriterion("join_purpose <>", value, "joinPurpose");
            return (Criteria) this;
        }

        public Criteria andJoinPurposeGreaterThan(String value) {
            addCriterion("join_purpose >", value, "joinPurpose");
            return (Criteria) this;
        }

        public Criteria andJoinPurposeGreaterThanOrEqualTo(String value) {
            addCriterion("join_purpose >=", value, "joinPurpose");
            return (Criteria) this;
        }

        public Criteria andJoinPurposeLessThan(String value) {
            addCriterion("join_purpose <", value, "joinPurpose");
            return (Criteria) this;
        }

        public Criteria andJoinPurposeLessThanOrEqualTo(String value) {
            addCriterion("join_purpose <=", value, "joinPurpose");
            return (Criteria) this;
        }

        public Criteria andJoinPurposeLike(String value) {
            addCriterion("join_purpose like", value, "joinPurpose");
            return (Criteria) this;
        }

        public Criteria andJoinPurposeNotLike(String value) {
            addCriterion("join_purpose not like", value, "joinPurpose");
            return (Criteria) this;
        }

        public Criteria andJoinPurposeIn(List<String> values) {
            addCriterion("join_purpose in", values, "joinPurpose");
            return (Criteria) this;
        }

        public Criteria andJoinPurposeNotIn(List<String> values) {
            addCriterion("join_purpose not in", values, "joinPurpose");
            return (Criteria) this;
        }

        public Criteria andJoinPurposeBetween(String value1, String value2) {
            addCriterion("join_purpose between", value1, value2, "joinPurpose");
            return (Criteria) this;
        }

        public Criteria andJoinPurposeNotBetween(String value1, String value2) {
            addCriterion("join_purpose not between", value1, value2, "joinPurpose");
            return (Criteria) this;
        }

        public Criteria andViewOfAssociationIsNull() {
            addCriterion("view_of_association is null");
            return (Criteria) this;
        }

        public Criteria andViewOfAssociationIsNotNull() {
            addCriterion("view_of_association is not null");
            return (Criteria) this;
        }

        public Criteria andViewOfAssociationEqualTo(String value) {
            addCriterion("view_of_association =", value, "viewOfAssociation");
            return (Criteria) this;
        }

        public Criteria andViewOfAssociationNotEqualTo(String value) {
            addCriterion("view_of_association <>", value, "viewOfAssociation");
            return (Criteria) this;
        }

        public Criteria andViewOfAssociationGreaterThan(String value) {
            addCriterion("view_of_association >", value, "viewOfAssociation");
            return (Criteria) this;
        }

        public Criteria andViewOfAssociationGreaterThanOrEqualTo(String value) {
            addCriterion("view_of_association >=", value, "viewOfAssociation");
            return (Criteria) this;
        }

        public Criteria andViewOfAssociationLessThan(String value) {
            addCriterion("view_of_association <", value, "viewOfAssociation");
            return (Criteria) this;
        }

        public Criteria andViewOfAssociationLessThanOrEqualTo(String value) {
            addCriterion("view_of_association <=", value, "viewOfAssociation");
            return (Criteria) this;
        }

        public Criteria andViewOfAssociationLike(String value) {
            addCriterion("view_of_association like", value, "viewOfAssociation");
            return (Criteria) this;
        }

        public Criteria andViewOfAssociationNotLike(String value) {
            addCriterion("view_of_association not like", value, "viewOfAssociation");
            return (Criteria) this;
        }

        public Criteria andViewOfAssociationIn(List<String> values) {
            addCriterion("view_of_association in", values, "viewOfAssociation");
            return (Criteria) this;
        }

        public Criteria andViewOfAssociationNotIn(List<String> values) {
            addCriterion("view_of_association not in", values, "viewOfAssociation");
            return (Criteria) this;
        }

        public Criteria andViewOfAssociationBetween(String value1, String value2) {
            addCriterion("view_of_association between", value1, value2, "viewOfAssociation");
            return (Criteria) this;
        }

        public Criteria andViewOfAssociationNotBetween(String value1, String value2) {
            addCriterion("view_of_association not between", value1, value2, "viewOfAssociation");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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