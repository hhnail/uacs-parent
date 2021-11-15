package com.jmu.uacs.association.controller;

import com.jmu.uacs.association.service.DepartmentService;
import com.jmu.uacs.vo.request.DepartmentReqVO;
import com.jmu.uacs.vo.response.AppResponse;
import com.jmu.uacs.vo.response.AssoicationResponseVo;
import com.netflix.discovery.converters.Auto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "社团模块--部门")
@RequestMapping("/association") // 父路径
@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @ResponseBody
    @ApiOperation(value = "新增社团部门")
    @PostMapping("/addDepartment")
    public AppResponse<String> addDepartment(@RequestBody DepartmentReqVO addVO) {
        departmentService.addDepartment(addVO);
        return AppResponse.ok("新增成功！");
    }

    @ResponseBody
    @ApiOperation(value = "删除社团部门")
    @DeleteMapping("/deleteDepartment/{departmentId}")
    public AppResponse<String> deleteDepartment(@PathVariable("departmentId") Integer departmentId) {
        departmentService.deleteDepartment(departmentId);
        return AppResponse.ok("删除成功！");
    }


}
