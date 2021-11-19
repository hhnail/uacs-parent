package com.jmu.uacs.association.bean;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class User {
    private Integer id;

    private String userId;

    private String password;

    private String name;

    private String gender;

    private Date birthday;

    private String nation;

    private String email;

    private String phone;

    private String wechat;

    private String qq;

    private String selfProfile;

    private String personalSignature;

    private Integer canView;

    private String state;

    private Integer canDel;

    private Integer classId;

    private Integer isDel;

    private String comprehensiveQuality;
}