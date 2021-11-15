package com.jmu.uacs.association.controller;

import com.jmu.uacs.association.service.UserService;
import com.jmu.uacs.vo.request.UserAddReqVo;
import com.jmu.uacs.vo.response.AppResponse;
import com.jmu.uacs.vo.response.UserManageVo;
import com.jmu.uacs.vo.response.UserResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

        log.debug("==删除成员 userId={}",userId);

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
}
