package com.jmu.uacs.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
@Data
@ApiModel
public class UserResponseVo implements Serializable {

    @ApiModelProperty(value = "访问令牌")
    private String accessToken;

    @ApiModelProperty(value = "用户ID（学号/教工号）")
    private String userId;

    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "角色列表")
    private List<RoleRespVo> roleList;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "自我评价")
    private String selfProfile;

    @ApiModelProperty(value = "个性签名")
    private String personalSignature;

    @ApiModelProperty(value = "头像路径")
    private String avatarUrl;

    @ApiModelProperty(value = "角色编号")
    private Integer roleId;



}
