package com.jmu.uacs.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@ApiModel
public class UserInfoReqVo implements Serializable {

    @ApiModelProperty(value="访问令牌")
    private String accessToken;

    private String email;

    private String phone;

    private String qq;

}
