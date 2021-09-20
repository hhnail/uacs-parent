package com.jmu.uacs.association.bean;

import lombok.ToString;

import java.util.Date;

public class Association {
    private Integer associationId;

    private String associationName;

    private String adminUnit;

    private Date requestTime;

    private Date createTime;

    private String state;

    private String info;

    private String imgUrl;

    public Integer getAssociationId() {
        return associationId;
    }

    public void setAssociationId(Integer associationId) {
        this.associationId = associationId;
    }

    public String getAssociationName() {
        return associationName;
    }

    public void setAssociationName(String associationName) {
        this.associationName = associationName == null ? null : associationName.trim();
    }

    public String getAdminUnit() {
        return adminUnit;
    }

    public void setAdminUnit(String adminUnit) {
        this.adminUnit = adminUnit == null ? null : adminUnit.trim();
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }
}