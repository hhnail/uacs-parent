package com.jmu.uacs.user.enums;

public enum UserStateEnum {

    OPEN("OPEN"), // 正常开启
    CLOSE("CLOSE"); // 被关闭，无法使用（登录）

    private String state;

    private UserStateEnum(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
