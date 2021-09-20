package com.jmu.uacs.enums;

public enum AssociationStateEnum {

    APPROVED(1,"审核通过"),
    APPROVING(2,"审核中"),
    APPROVE_FAIL(3,"审核未通过"),
    LOCKED(4,"社团被锁定");

    private Integer code;
    private String state;

    AssociationStateEnum(Integer code, String state) {
        this.code = code;
        this.state = state;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
