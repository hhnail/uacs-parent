package com.jmu.uacs.vo.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserSettingsUpdateReqVO {

    private String userId;
    private String name;

    private String phone;
    private String email;

    private String password;
    private String newPassword;
    private String confirmPassword;

    private String gender;
}
