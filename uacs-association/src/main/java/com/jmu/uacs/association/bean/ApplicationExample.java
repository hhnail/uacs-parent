package com.jmu.uacs.association.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplicationExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIntentionDepartmentIsNull() {
            addCriterion("intention_department is null");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentIsNotNull() {
            addCriterion("intention_department is not null");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentEqualTo(String value) {
            addCriterion("intention_department =", value, "intentionDepartment");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentNotEqualTo(String value) {
            addCriterion("intention_department <>", value, "intentionDepartment");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentGreaterThan(String value) {
            addCriterion("intention_department >", value, "intentionDepartment");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("intention_department >=", value, "intentionDepartment");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentLessThan(String value) {
            addCriterion("intention_department <", value, "intentionDepartment");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentLessThanOrEqualTo(String value) {
            addCriterion("intention_department <=", value, "intentionDepartment");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentLike(String value) {
            addCriterion("intention_department like", value, "intentionDepartment");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentNotLike(String value) {
            addCriterion("intention_department not like", value, "intentionDepartment");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentIn(List<String> values) {
            addCriterion("intention_department in", values, "intentionDepartment");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentNotIn(List<String> values) {
            addCriterion("intention_department not in", values, "intentionDepartment");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentBetween(String value1, String value2) {
            addCriterion("intention_department between", value1, value2, "intentionDepartment");
            return (Criteria) this;
        }

        public Criteria andIntentionDepartmentNotBetween(String value1, String value2) {
            addCriterion("intention_department not between", value1, value2, "intentionDepartment");
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

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIsNull() {
            addCriterion("application_time is null");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIsNotNull() {
            addCriterion("application_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeEqualTo(Date value) {
            addCriterion("application_time =", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotEqualTo(Date value) {
            addCriterion("application_time <>", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeGreaterThan(Date value) {
            addCriterion("application_time >", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("application_time >=", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeLessThan(Date value) {
            addCriterion("application_time <", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeLessThanOrEqualTo(Date value) {
            addCriterion("application_time <=", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIn(List<Date> values) {
            addCriterion("application_time in", values, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotIn(List<Date> values) {
            addCriterion("application_time not in", values, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeBetween(Date value1, Date value2) {
            addCriterion("application_time between", value1, value2, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotBetween(Date value1, Date value2) {
            addCriterion("application_time not between", value1, value2, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeIsNull() {
            addCriterion("interview_time is null");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeIsNotNull() {
            addCriterion("interview_time is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeEqualTo(Date value) {
            addCriterion("interview_time =", value, "interviewTime");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeNotEqualTo(Date value) {
            addCriterion("interview_time <>", value, "interviewTime");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeGreaterThan(Date value) {
            addCriterion("interview_time >", value, "interviewTime");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("interview_time >=", value, "interviewTime");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeLessThan(Date value) {
            addCriterion("interview_time <", value, "interviewTime");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeLessThanOrEqualTo(Date value) {
            addCriterion("interview_time <=", value, "interviewTime");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeIn(List<Date> values) {
            addCriterion("interview_time in", values, "interviewTime");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeNotIn(List<Date> values) {
            addCriterion("interview_time not in", values, "interviewTime");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeBetween(Date value1, Date value2) {
            addCriterion("interview_time between", value1, value2, "interviewTime");
            return (Criteria) this;
        }

        public Criteria andInterviewTimeNotBetween(Date value1, Date value2) {
            addCriterion("interview_time not between", value1, value2, "interviewTime");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressIsNull() {
            addCriterion("interview_address is null");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressIsNotNull() {
            addCriterion("interview_address is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressEqualTo(String value) {
            addCriterion("interview_address =", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressNotEqualTo(String value) {
            addCriterion("interview_address <>", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressGreaterThan(String value) {
            addCriterion("interview_address >", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressGreaterThanOrEqualTo(String value) {
            addCriterion("interview_address >=", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressLessThan(String value) {
            addCriterion("interview_address <", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressLessThanOrEqualTo(String value) {
            addCriterion("interview_address <=", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressLike(String value) {
            addCriterion("interview_address like", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressNotLike(String value) {
            addCriterion("interview_address not like", value, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressIn(List<String> values) {
            addCriterion("interview_address in", values, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressNotIn(List<String> values) {
            addCriterion("interview_address not in", values, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressBetween(String value1, String value2) {
            addCriterion("interview_address between", value1, value2, "interviewAddress");
            return (Criteria) this;
        }

        public Criteria andInterviewAddressNotBetween(String value1, String value2) {
            addCriterion("interview_address not between", value1, value2, "interviewAddress");
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

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andRecruitmentIdIsNull() {
            addCriterion("recruitment_id is null");
            return (Criteria) this;
        }

        public Criteria andRecruitmentIdIsNotNull() {
            addCriterion("recruitment_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitmentIdEqualTo(Integer value) {
            addCriterion("recruitment_id =", value, "recruitmentId");
            return (Criteria) this;
        }

        public Criteria andRecruitmentIdNotEqualTo(Integer value) {
            addCriterion("recruitment_id <>", value, "recruitmentId");
            return (Criteria) this;
        }

        public Criteria andRecruitmentIdGreaterThan(Integer value) {
            addCriterion("recruitment_id >", value, "recruitmentId");
            return (Criteria) this;
        }

        public Criteria andRecruitmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("recruitment_id >=", value, "recruitmentId");
            return (Criteria) this;
        }

        public Criteria andRecruitmentIdLessThan(Integer value) {
            addCriterion("recruitment_id <", value, "recruitmentId");
            return (Criteria) this;
        }

        public Criteria andRecruitmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("recruitment_id <=", value, "recruitmentId");
            return (Criteria) this;
        }

        public Criteria andRecruitmentIdIn(List<Integer> values) {
            addCriterion("recruitment_id in", values, "recruitmentId");
            return (Criteria) this;
        }

        public Criteria andRecruitmentIdNotIn(List<Integer> values) {
            addCriterion("recruitment_id not in", values, "recruitmentId");
            return (Criteria) this;
        }

        public Criteria andRecruitmentIdBetween(Integer value1, Integer value2) {
            addCriterion("recruitment_id between", value1, value2, "recruitmentId");
            return (Criteria) this;
        }

        public Criteria andRecruitmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("recruitment_id not between", value1, value2, "recruitmentId");
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