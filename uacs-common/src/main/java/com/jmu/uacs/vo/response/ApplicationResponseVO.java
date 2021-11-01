package com.jmu.uacs.vo.response;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class ApplicationResponseVO {
    private Integer applicationId;

    private String photoUrl;

    private String intentionDepartment;

    private String selfProfile;

    private String joinPurpose;

    private String viewOfAssociation;

    private Integer state;

    private Date applicationTime;

    private Date interviewTime;

    private String interviewAddress;

    private String userId;

    private Integer recruitmentId;

    private Integer associationId;
}
