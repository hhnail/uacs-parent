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

    // 申请表描述信息
    private Integer applicationId;
    private String photoUrl;
    private String intentionDepartment;
    private String selfProfile;
    private String joinPurpose;
    private String viewOfAssociation;

    // 面试安排
    private Date applicationTime;
    private Date interviewTime;
    private String interviewAddress;
    private Integer state;


    private Integer associationId;
    private String associationName;

    // 入团来源
    private Integer recruitmentId;

    public String getApplicationTime() {
        return StringUtils.formatDate2String(applicationTime, DateTemplate.yyyyMMddhhmmss);
    }

    public String getInterviewTime() {
        return StringUtils.formatDate2String(interviewTime, DateTemplate.yyyyMMddhhmmss);
    }
}
