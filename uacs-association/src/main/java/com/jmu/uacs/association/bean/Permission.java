package com.jmu.uacs.association.bean;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Permission {
    private Integer permissionId;

    private String title;

    private String routePath;

    private Integer grade;

    private String type;

    private Integer pId;

    private Integer isDel;
}