package com.jmu.uacs.enums;

public enum TreeNodeEnum {

    COLLEGE("COLLEGE", "学院"),
    MAJOR("MAJOR", "专业"),
    CLASS("CLASS", "班级"),
    CAMPUS("CAMPUS", "校区"),
    BUILDING("BUILDING", "教学楼"),
    CLASSROOM("CLASSROOM", "教室"),
    TAG("TAG", "标签");

    private String value;
    private String lable;

    TreeNodeEnum(String value, String lable) {
        this.value = value;
        this.lable = lable;
    }

    public String getValue() {
        return value;
    }

    public String getLable() {
        return lable;
    }
}
