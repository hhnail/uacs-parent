package com.jmu.uacs.association.controller;

import com.jmu.uacs.association.service.RoleService;
import com.jmu.uacs.vo.request.ReGrantPermissions2RoleReqVo;
import com.jmu.uacs.vo.response.AppResponse;
import com.jmu.uacs.vo.response.RoleRespVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Api(tags = "社团模块--角色")
@RequestMapping("/association") // 父路径
public class RoleController {

    @Autowired
    RoleService roleService;

    @ApiOperation("SELECT 角色列表")
    @GetMapping("/getRoleList")
    public AppResponse<List<RoleRespVo>> getRoleList() {
        try {
            List<RoleRespVo> roleList = roleService.getRoleList();
            AppResponse<List<RoleRespVo>> resp = AppResponse.ok(roleList);
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<List<RoleRespVo>> fail = AppResponse.fail(null);
            fail.setMsg("获取角色列表失败");
            return fail;
        }
    }

    // TODO 超管权限分配失败
    @ApiOperation("重新为角色授予权限")
    @PostMapping("/reGrantPermissions2Role")
    public AppResponse<String> reGrantPermissions2Role(@RequestBody ReGrantPermissions2RoleReqVo reGrantPermissions2RoleReqVo) {
        try {
            log.debug("==204 重新为角色授予权限 reGrantPermissions2Role={}", reGrantPermissions2RoleReqVo);
            Integer affectedRows = roleService.reGrantPermissions2Role(reGrantPermissions2RoleReqVo);
            AppResponse<String> resp = AppResponse.ok(null);
            resp.setMsg("操作成功，受影响的行数：" + affectedRows);
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<String> fail = AppResponse.fail(null);
            fail.setMsg("ILLEGAL_ACTION");
            return fail;
        }
    }
}
