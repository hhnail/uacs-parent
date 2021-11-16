package com.jmu.uacs.enums;

public enum ApplicationStateEnum {

    UN_COMMIT("未提交申请", "UN_COMMIT"),
    APPLYING("申请中", "APPLYING"),
    APPLY_REFUSE("申请被拒", "APPLY_REFUSE"),
    INTERVIEW_INVITING("邀请面试中", "INTERVIEW_INVITING"),
    REFUSE_INVITING("拒绝面试邀请", "REFUSE_INVITING"),
    UN_INTERVIEW("待面试", "UN_INTERVIEW"),
    INTERVIEW_PASS("面试通过", "INTERVIEW_PASS"),
    CONFIRM("确认加入", "CONFIRM"),
    REGRET("取消流程", "REGRET");

    private String label;
    private String state;

    ApplicationStateEnum(String label, String state) {
        this.label = label;
        this.state = state;
    }

    public String getLabel() {
        return label;
    }

    public String getState() {
        return state;
    }
}
