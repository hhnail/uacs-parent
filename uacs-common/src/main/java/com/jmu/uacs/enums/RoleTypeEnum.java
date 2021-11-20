package com.jmu.uacs.enums;

public enum RoleTypeEnum {

    STUDENT(1, "普通学生"),
    MEMBER(4, "社团成员"),
    LEADER(6, "社长"),
    VICE_LEADER(5, "副社长"),
    SUPER_ADMIN(3, "超级管理员"),
    ASSOCIATION_ADMIN(2, "社团管理员");


    private Integer code;
    private String role;

    RoleTypeEnum(Integer code, String role) {
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

    public static Integer getCodeByName(String name) {
        for (RoleTypeEnum item : RoleTypeEnum.values()) {
            if (item.getRole().equals(name)) {
                return item.getCode();
            }
        }
        return RoleTypeEnum.STUDENT.getCode();
    }

}
