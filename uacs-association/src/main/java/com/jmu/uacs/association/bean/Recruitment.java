package com.jmu.uacs.association.bean;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Recruitment {
    private Integer recruitmentId;

    private String title;

    private Integer newNum;

    private String description;

    private String content;

    private String state;

    private Date startTime;

    private Date endTime;

    private Integer view;

    private Integer userId;

    private Integer associationId;
 }