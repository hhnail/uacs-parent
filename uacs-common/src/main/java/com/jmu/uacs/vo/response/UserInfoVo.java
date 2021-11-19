package com.jmu.uacs.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@ApiModel
public class UserInfoVo implements Serializable {

    @ApiModelProperty(value="访问令牌")
    private String accessToken;

    private String userId;

    private String name;

    private String gender;

    private String birthday;

    private String nation;

    private String email;

    private String phone;

    private String qq;

    private String selfLike;

    private String className;

    @ApiModelProperty(value="权限路径集合")
    private List<String> permissionRoutePathList;


}
