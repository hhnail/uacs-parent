package com.jmu.uacs.vo.request;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class InterviewReqVO {

    private Integer applicationId;

    private Date interviewDate;

    private Date interviewTime;

    private String interviewAddress;

    private String intentionDepartment;

    private String contacterId;

    private String contacterPhone;

    private String description;

}
