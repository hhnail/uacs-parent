package com.jmu.uacs.vo.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@ToString
@Data
@ApiModel
public class UserManageVo {
    private Integer id;

    private String userId;

//    private String password;

    private String name;

    private String gender;

    private Date birthday;

    private String nation;

    private String email;

    private String phone;

    private String wechat;

    private String qq;

    private String headUrl;

    private String state;

    private Integer canDel;

    private Integer classId;

    private List<RoleRespVo> roleList;
}
