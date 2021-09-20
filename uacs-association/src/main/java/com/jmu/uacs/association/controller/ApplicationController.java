package com.jmu.uacs.association.controller;

import com.jmu.uacs.association.service.ApplicationService;
import com.jmu.uacs.enums.ResponseCodeEnume;
import com.jmu.uacs.vo.request.ApplicationRequestVo;
import com.jmu.uacs.vo.response.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Api(tags = "社团模块--申请表")
@RequestMapping("/application") // 父路径
@Controller
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @ApiOperation("保存申请表")
    @ResponseBody
    @PostMapping("/saveApplication")
    public AppResponse<String> saveApplication(ApplicationRequestVo vo){
        try {
            applicationService.saveApplication(vo);
            AppResponse<String> resp = AppResponse.ok("ok");
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<String> resp = AppResponse.fail(null);
            resp.setMsg(ResponseCodeEnume.FAIL.getMsg());
            return resp;
        }
    }

}
