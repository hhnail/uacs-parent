package com.jmu.uacs.association.bean;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Application {
    private Integer applicationId;

    private String photoUrl;

    private String selfProfile;

    private String joinPurpose;

    private String viewOfAssociation;

    private String state;

    private Date applicationTime;

    private Integer canAdjust;

    private Date interviewTime;

    private String interviewAddress;

    private String contacterId;

    private String contacterPhone;

    private String description;

    private Integer departmentId;

    private String userId;

    private Integer recruitmentId;
}