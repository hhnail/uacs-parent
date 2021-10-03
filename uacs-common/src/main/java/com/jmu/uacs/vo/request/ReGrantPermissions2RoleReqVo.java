package com.jmu.uacs.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApiModel
@Data
@ToString
public class ReGrantPermissions2RoleReqVo implements Serializable {

    @ApiModelProperty("待授权角色ID")
    private Integer roleId;

    @ApiModelProperty("授予的权限ID列表")
    private List<Integer> permissionIds = new ArrayList<Integer>();
}
