package com.jmu.uacs.enums;

public enum UserRoleEnum {

    STUDENT(0,"user"),
    ADMIN(1,"admin");

    private Integer code;
    private String role;

    private UserRoleEnum(Integer code, String role) {
        this.code = code;
        this.role = role;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
