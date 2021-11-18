package com.jmu.uacs.file;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class UserData {

    @ExcelProperty("学号")
    private String userId;
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("担任角色")
    private String roleName;
    @ExcelProperty("所属社团")
    private String associationName;
    @ExcelProperty("密码")
    private String password;
    @ExcelProperty("性别")
    private String gender;


}
