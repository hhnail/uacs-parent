package com.jmu.uacs.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RecruitmentReqVo {

    private String userId;

    private String state;

    private Integer recruitmentId;

}
