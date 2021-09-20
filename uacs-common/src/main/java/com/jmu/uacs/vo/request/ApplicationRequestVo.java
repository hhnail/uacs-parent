package com.jmu.uacs.vo.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel
public class ApplicationRequestVo extends BaseUserVo {

    //个人信息
//    private Integer id;
//    private String userId;//学号
//    private String name;
//    private String gender;
//    private Date birthday;
//    private String nation;
//    private String phone;
//    private String qq;
//    private Integer classId;

    //社团申请信息
    private String photoUrl;
    private String intentionDepartmentName;
    private String selfProfile;
    private String joinPurpose;
    private String viewOfAssociation;
//    private Integer state;
}
