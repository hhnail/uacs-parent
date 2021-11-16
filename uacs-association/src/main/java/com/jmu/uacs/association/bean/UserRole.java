package com.jmu.uacs.association.bean;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class UserRole {
    private Integer userRoleId;

    private String userId;

    private Integer roleId;

    private Integer associationId;

    private Integer departmentId;
}