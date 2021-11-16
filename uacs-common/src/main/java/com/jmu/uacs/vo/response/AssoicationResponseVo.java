package com.jmu.uacs.vo.response;

import com.jmu.uacs.bean.Department;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ToString
@Data
public class AssoicationResponseVo implements Serializable {

    // 社团信息
    private Integer associationId;
    private String associationName;
    private String adminUnit;
    private String requestTime;
    private String createTime;
    private String type;
    private String state;
    private String info;
    private String imgUrl;

    // 用户信息
    private String userId;
    private String name;

    // 用户在社团担任的角色
    private Integer roleId;
    private String roleName;

    private List<Department> departments = new ArrayList<Department>();
}
