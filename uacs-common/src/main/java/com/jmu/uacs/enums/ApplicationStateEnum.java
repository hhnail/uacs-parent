package com.jmu.uacs.enums;

public enum ApplicationStateEnum {

    UN_COMMIT("未提交申请"),
    APPLYING("申请中"),
    APPLY_REFUSE("申请被拒"),
    INTERVIEW_INVITING("邀请面试中"),
    REFUSE_INVITING("拒绝面试邀请"),
    UN_INTERVIEW("待面试"),
    INTERVIEW_PASS("面试通过"),
    CONFIRM("确认加入"),
    REGRET("取消流程");

    private String state;

    ApplicationStateEnum(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
