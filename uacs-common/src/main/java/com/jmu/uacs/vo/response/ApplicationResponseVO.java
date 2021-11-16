package com.jmu.uacs.vo.response;

import com.jmu.uacs.enums.DateTemplate;
import com.jmu.uacs.util.StringUtils;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author:hhnail
 */
@Data
@ToString
public class ApplicationResponseVO {

    // 成员信息
    private String userId;
    private String name;
    private String gender;
    private String phone;
    private String email;
    private String className; // 班级
    private String major; // 专业
    private String college; // 学院

    // 申请表描述信息
    private Integer applicationId;
    private String photoUrl;

    private Integer departmentId;
    private String departmentName;
    private String selfProfile;
    private String joinPurpose;
    private String viewOfAssociation;

    // 面试安排
    private Date applicationTime;
    private Date interviewTime;
    private String interviewAddress;
    private String state;

    // ==== 其他关联
    // 对应社团信息
    private Integer associationId;
    private String associationName;

    // 对应纳新通知 入团来源
    private Integer recruitmentId;

    public String getApplicationTime() {
        return StringUtils.formatDate2String(applicationTime, DateTemplate.yyyyMMddhhmmss);
    }

    public String getInterviewTime() {
        return StringUtils.formatDate2String(interviewTime, DateTemplate.yyyyMMddhhmmss);
    }
}
