package com.jmu.uacs.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Department {
    private Integer departmentId;

    private String departmentName;

    private String job;

    private Integer associationId;
}