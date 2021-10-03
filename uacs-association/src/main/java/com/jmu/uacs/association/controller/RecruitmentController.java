package com.jmu.uacs.association.controller;

import com.jmu.uacs.association.service.RecruitmentService;
import com.jmu.uacs.vo.request.AddRecruitmentRequestVo;
import com.jmu.uacs.vo.response.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "社团模块--纳新")
@RequestMapping("/association") // 父路径
@RestController
public class RecruitmentController {

    @Autowired
    RecruitmentService recruitmentService;

    @ApiOperation("添加社团纳新信息")
    @ResponseBody
    @PostMapping("/addRecruitment")
    public AppResponse<String> addRecruitment(AddRecruitmentRequestVo reqVo){

        int affectNum = recruitmentService.addRecruitment(reqVo);

        return null;
    }


}