package com.jmu.uacs.association.bean;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
@ApiModel
public class Application {
    private Integer applicationId;

    private String photoUrl;

    private String intentionDepartment;

    private String selfProfile;

    private String joinPurpose;

    private String viewOfAssociation;

    private String state;

    private Date applicationTime;

    private Date interviewTime;

    private String interviewAddress;

    private String userId;

    private Integer recruitmentId;



}