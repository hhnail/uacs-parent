package com.jmu.uacs.vo.request;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class AddRecruitmentRequestVo implements Serializable {

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
