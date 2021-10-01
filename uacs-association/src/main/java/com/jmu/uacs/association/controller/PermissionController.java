package com.jmu.uacs.association.controller;

import com.jmu.uacs.association.service.PermissionService;
import com.jmu.uacs.vo.request.PermissionUpdateVo;
import com.jmu.uacs.vo.response.AppResponse;
import com.jmu.uacs.vo.response.PermissionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Api(tags = "社团模块--权限")
@RequestMapping("/association") // 父路径
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    // TODO 接口重构（根据用户id）返回权限列表
    @ApiOperation("查询权限列表（带层次结构）")
    @GetMapping("/getPermissionList/{userId}")
    public AppResponse<List<PermissionVo>> getPermissionList(@PathVariable(name = "userId") String userId) {
        try {
            log.debug("=1=C= userId", userId);
            List<PermissionVo> permissionList = permissionService.getPermissionList(userId);
            AppResponse<List<PermissionVo>> resp = AppResponse.ok(permissionList);
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<List<PermissionVo>> fail = AppResponse.fail(null);
            fail.setMsg("获取权限列表失败");
            return fail;
        }
    }

    @ApiOperation("根据权限ID删除权限")
    @GetMapping("/deletePermissionById/{key}")
    public AppResponse<String> deletePermissionById(@PathVariable(name = "key") Integer permissionId) {
        try {
            log.debug("==101 根据权限ID删除权限 key（permissionId）={}", permissionId);
            Integer affectedRows = permissionService.deletePermissionById(permissionId);
            AppResponse<String> resp = AppResponse.ok(null);
            resp.setMsg("操作成功，受影响的行数：" + affectedRows);
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ApiOperation("根据权限ID更新权限type")
    @PostMapping("/updatePermissionById")
    public AppResponse<String> updatePermissionById(@RequestBody PermissionUpdateVo permissionUpdateVo) {
        try {
            log.debug("==102 根据权限ID更新权限 permissionUpdateVo={}", permissionUpdateVo);
            Integer affectedRows = permissionService.updatePermissionById(permissionUpdateVo);
            AppResponse<String> resp = AppResponse.ok(null);
//            resp.setMsg("操作成功，受影响的行数：" + affectedRows);
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
