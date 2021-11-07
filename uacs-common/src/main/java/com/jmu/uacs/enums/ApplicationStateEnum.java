package com.jmu.uacs.enums;

public enum ApplicationStateEnum {

    APPROVED(1,"审核通过"),
    APPROVING(2,"审核中"),
    APPROVE_FAIL(3,"审核未通过");
//【UN_COMMIT】未提交申请
//【APPLYING】申请中
//【APPLY_REFUSE】申请被拒
//【INTERVIEW_INVITING】邀请面试中
//【REFUSE_INVITING】拒绝面试邀请
//【UN_INTERVIEW】待面试
//【INTERVIEW_PASS】面试通过
//【CONFIRM】确认加入
//【REGRET】取消流程

    private Integer code;
    private String state;

    ApplicationStateEnum(Integer code, String state) {
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
