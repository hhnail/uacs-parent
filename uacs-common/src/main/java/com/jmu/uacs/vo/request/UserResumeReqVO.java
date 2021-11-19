package com.jmu.uacs.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class UserResumeReqVO {

    private String userId;

    private String name;

    private String gender;

    private Date birthday;

    private String nation;

    private String email;

    private String phone;

    private String wechat;

    private String qq;

    private String selfLike;

    private String selfProfile;

    private Integer canView;

    @ApiModelProperty(value = "班级编号")
    private Integer treeId;

    // 学院/专业/班级
    @ApiModelProperty(value = "班级名称")
    private String className;
}
