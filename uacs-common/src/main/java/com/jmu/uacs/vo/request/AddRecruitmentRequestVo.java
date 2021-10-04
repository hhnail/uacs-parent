package com.jmu.uacs.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class AddRecruitmentRequestVo implements Serializable {

    private String title;

    @ApiModelProperty("纳新人数")
    private Integer newNum;

    private String description;

    private String content;

    private String state;

    private Date startTime;

    private Date endTime;

    private Integer userId;

    private Integer associationId;

}
