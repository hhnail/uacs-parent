package com.jmu.uacs.vo.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ApiModel
@Data
@ToString
public class RoleRespVo implements Serializable {

    private Integer roleId;

    private String roleName;

    private String roleType;

    private Integer associationId;

    private String associationName;

    private List<PermissionVo> permissions;
}
