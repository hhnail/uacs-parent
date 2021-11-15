package com.jmu.uacs.vo.request;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class DepartmentReqVO {

    private String departmentName;

    private String job;

    private Integer associationId;

    private String userId;
}
