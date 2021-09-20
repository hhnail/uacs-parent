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

    private String roleName;

    private String associationName;
}
