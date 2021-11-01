package com.jmu.uacs.association.bean;

public class Application {
    private Integer applicationId;

    private String photoUrl;

    private String intentionDepartmentName;

    private String selfProfile;

    private String joinPurpose;

    private String viewOfAssociation;

    private Integer state;

    private Integer userId;

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    public String getIntentionDepartmentName() {
        return intentionDepartmentName;
    }

    public void setIntentionDepartmentName(String intentionDepartmentName) {
        this.intentionDepartmentName = intentionDepartmentName == null ? null : intentionDepartmentName.trim();
    }

    public String getSelfProfile() {
        return selfProfile;
    }

    public void setSelfProfile(String selfProfile) {
        this.selfProfile = selfProfile == null ? null : selfProfile.trim();
    }

    public String getJoinPurpose() {
        return joinPurpose;
    }

    public void setJoinPurpose(String joinPurpose) {
        this.joinPurpose = joinPurpose == null ? null : joinPurpose.trim();
    }

    public String getViewOfAssociation() {
        return viewOfAssociation;
    }

    public void setViewOfAssociation(String viewOfAssociation) {
        this.viewOfAssociation = viewOfAssociation == null ? null : viewOfAssociation.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}