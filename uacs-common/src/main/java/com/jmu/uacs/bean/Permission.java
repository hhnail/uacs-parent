package com.jmu.uacs.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Permission {
    private Integer permissionId;

    private String title;

    private String routePath;

    private Integer grade;

    private String type;

    private Integer pId;

}