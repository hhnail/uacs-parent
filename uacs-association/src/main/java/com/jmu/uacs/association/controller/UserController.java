package com.jmu.uacs.association.controller;

import com.jmu.uacs.association.bean.User;
import com.jmu.uacs.association.service.UserService;
import com.jmu.uacs.vo.request.UserAddReqVo;
import com.jmu.uacs.vo.request.UserRegistVo;
import com.jmu.uacs.vo.response.AppResponse;
import com.jmu.uacs.vo.response.UserManageVo;
import com.jmu.uacs.vo.response.UserResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jxl.Sheet;
import jxl.Workbook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@Api(tags = "社团模块--成员")
@RequestMapping("/association") // 父路径
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @ApiOperation("成员列表")
    @GetMapping("/getAllUsers")
    public AppResponse<List<UserManageVo>> getAllUsers() {
        try {
            List<UserManageVo> allUsers = userService.getAllUsers();
            AppResponse<List<UserManageVo>> resp = AppResponse.ok(allUsers);
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<List<UserManageVo>> fail = AppResponse.fail(null);
            fail.setMsg("获取成员列表失败");
            return fail;
        }
    }

    @ResponseBody
    @ApiOperation("添加成员")
    @PostMapping("/addUser")
    public AppResponse<String> addUser(@RequestBody UserAddReqVo userAddReqVo) {

        log.debug("==1 添加成员 接收到的请求VO：", userAddReqVo);

        try {
            Integer affectedRowNum = userService.addUser(userAddReqVo);

            AppResponse<String> resp = AppResponse.ok("受影响的行数" + affectedRowNum);
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<String> fail = AppResponse.fail(null);
            fail.setMsg("添加成员失败");
            return fail;
        }
    }

    @ResponseBody
    @ApiOperation("根据用户ID获取用户信息")
    @GetMapping("/getUserById/{userId}")
    public AppResponse<UserManageVo> getUserById(@PathVariable(name = "userId") String userId) {
        try {
            UserManageVo userVo = userService.getUserById(userId);
            return AppResponse.ok(userVo);
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<UserManageVo> fail = AppResponse.fail(null);
            fail.setMsg("获取成员信息失败");
            return fail;
        }
    }

    @ResponseBody
    @ApiOperation("删除成员")
    @DeleteMapping("/deleteUserById/{userId}")
    public AppResponse<String> deleteUserById(@PathVariable(name = "userId") String userId) {

        log.debug("==删除成员 userId={}", userId);

        try {
            int affectedRowNum = userService.deleteUserById(userId);
            AppResponse<String> resp = AppResponse.ok("受影响的行数为" + affectedRowNum);
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<String> fail = AppResponse.fail(null);
            fail.setMsg("获取成员列表失败");
            return fail;
        }
    }

    @ResponseBody
    @ApiOperation("获取某社团的成员")
    @GetMapping("/getUserByAssociationId/{associationId}")
    public AppResponse<List<UserResponseVo>> getUserByAssociationId(@PathVariable("associationId") Integer associationId) {
        try {
            List<UserResponseVo> users = userService.getUserByAssociationId(associationId);
            AppResponse<List<UserResponseVo>> resp = AppResponse.ok(users);
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<List<UserResponseVo>> fail = AppResponse.fail(null);
            fail.setMsg("获取成员列表失败");
            return fail;
        }
    }

    /**
     * 批量导入社团成员
     * 必选@列1 - 学号；格式：英文或数字组合，最长不超过20个字符
     * 必选@列2 - 姓名：格式：中文或英文，最长不超过50个字符
     * 必选@列3 - 角色：【普通学生、社团成员、社团管理员、社团会长、社团副会长】
     * 必选@列4 - 所属社团：从先有社团中选择。若上述角色为普通学生，可不填。
     * 可选@列5 - 密码：格式：字符和数字的组合，最短6个字符，最长不超过50个字符。系统默认密码为学号后6位
     * 可选@列6 - 性别：格式：仅能选择【男、女或保密】，系统默认性别为保密
     */
    @ResponseBody
    @ApiOperation("批量导入社团成员")
    @PostMapping("/batchImportUser")
    public AppResponse<String> batchImportUser(@RequestBody MultipartFile file) {
        try {
            // 读excel文件流
            Workbook workbook = Workbook.getWorkbook(file.getInputStream());
            // 获取工作簿sheet
            Sheet sheet = workbook.getSheet(0);
            // 遍历获取内容
            List<UserAddReqVo> users = new ArrayList<>();
            for (int i = 0; i < sheet.getRows(); i++) {
                UserAddReqVo user = new UserAddReqVo();
                user.setUserId(sheet.getCell(0, i).getContents());
                user.setName(sheet.getCell(1, i).getContents());
                user.setRoleName(sheet.getCell(2, i).getContents());
                user.setAssociationName(sheet.getCell(3, i).getContents());
                user.setPassword(sheet.getCell(4, i).getContents());
                user.setGender(sheet.getCell(5, i).getContents());
                users.add(user);
            }
            userService.batchImportUser(users);
            AppResponse<String> resp = AppResponse.ok(null);
            resp.setMsg("批量导入成功！");
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<String> fail = AppResponse.fail(null);
            fail.setMsg("批量导入失败！原因：" + e.getMessage());
            return fail;
        }
    }
}
