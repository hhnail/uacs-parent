package com.jmu.uacs.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@ApiModel
@ToString
@Data
public class DepartmentReqVO {

    private String departmentName;

    private String job;

    private Integer associationId;

    @ApiModelProperty("部长学号")
    private String userId;
}
