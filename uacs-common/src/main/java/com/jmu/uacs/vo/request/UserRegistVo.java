package com.jmu.uacs.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel
@Data
public class UserRegistVo implements Serializable{

	@ApiModelProperty(value="用户学号/教工号")
	private String userId;
	
	@ApiModelProperty(value="用户密码")
	private String password;
	
	@ApiModelProperty(value="用户手机号")
	private String phone;
	
	@ApiModelProperty(value="验证码")
	private String checkCode;
}
