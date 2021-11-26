package com.jmu.uacs.bulletin.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserRole {
    private Integer userRoleId;

    private String userId;

    private Integer roleId;

    private Integer associationId;

    private Integer departmentId;

}