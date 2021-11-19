package com.jmu.uacs.vo.response;

import com.jmu.uacs.enums.DateTemplate;
import com.jmu.uacs.util.StringUtils;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ToString
@Data
@ApiModel
public class UserManageVo {
    private Integer id;

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

    private String state;

    private Integer canDel;

    private Integer canView;

    private Integer treeId;

    private String collegeMajorClass;

    private List<RoleRespVo> roleList = new ArrayList<RoleRespVo>();

    private String personalSignature;

    public String getBirthday() {
        if (birthday != null) {
            return StringUtils.formatDate2String(birthday, DateTemplate.yyyyMMdd);
        }
        return "";
    }
}
