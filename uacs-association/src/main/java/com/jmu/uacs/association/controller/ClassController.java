package com.jmu.uacs.association.controller;

import com.jmu.uacs.association.service.ClassService;
import com.jmu.uacs.association.service.PermissionService;
import com.jmu.uacs.vo.response.AppResponse;
import com.jmu.uacs.vo.response.CascaderClassVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Api(tags = "社团模块--班级")
@RequestMapping("/association") // 父路径
@Controller
public class ClassController {

    @Autowired
    ClassService classService;

    @Autowired
    PermissionService permissionService;

    /**
     * 查询学院-专业-班级的包含结构信息
     * 供user填写个人简历选择班级时使用
     * 系统管理员可以CURD相关信息
     */
    @ApiOperation("获取所有学院专业班级（带层次结构）")
    @ResponseBody
    @GetMapping("/getCascaderClass")
    public AppResponse<List<CascaderClassVo>> getCascaderClass() {
        log.debug("==1 后台服务-获取班级级联信息");

        List<CascaderClassVo> list = classService.getCascaderClass();

        AppResponse<List<CascaderClassVo>> resp = AppResponse.ok(list);

        return resp;
    }

}
