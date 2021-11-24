package com.jmu.uacs.vo.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@ApiModel
public class ApplicationRequestVo extends BaseUserVo {

    //社团申请所需信息
    private String intentionDepartment;
    private String selfProfile;
    private String joinPurpose;
    private String viewOfAssociation;
    private String state;
    private Date applicationTime;
    private Date interviewTime;
    private String interviewAddress;

    private Integer departmentId;

    private String userId;

    private Integer canAdjust;

    private Integer recruitmentId;
}
