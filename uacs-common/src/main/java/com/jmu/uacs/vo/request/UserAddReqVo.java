package com.jmu.uacs.vo.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@ApiModel
public class UserAddReqVo implements Serializable {

    private String userId;

    private String name;

    private Integer roleId;
    private String roleName;

    private Integer associationId;
    private String associationName;

    private String password;

    private String gender;
}
