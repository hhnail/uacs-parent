package com.jmu.uacs.association.controller;

import com.jmu.uacs.association.service.ApplicationService;
import com.jmu.uacs.enums.ResponseCodeEnume;
import com.jmu.uacs.vo.request.ApplicationRequestVo;
import com.jmu.uacs.vo.response.AppResponse;
import com.jmu.uacs.vo.response.ApplicationResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "社团模块--申请表")
@RequestMapping("/association") // 父路径
@Controller
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @ApiOperation("查询申请表")
    @ResponseBody
    @PostMapping("/getApplicationList")
    public AppResponse<List<ApplicationResponseVO>> getApplicationList(@RequestParam Integer[] associationIds){
        try {
            List<ApplicationResponseVO> resList = applicationService.getApplicationList(associationIds);
            AppResponse<List<ApplicationResponseVO>> resp = AppResponse.ok(resList);
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<List<ApplicationResponseVO>> resp = AppResponse.fail(null);
            resp.setMsg(ResponseCodeEnume.FAIL.getMsg());
            return resp;
        }
    }

    @ApiOperation("保存申请表")
    @ResponseBody
    @PostMapping("/saveApplication")
    public AppResponse<String> saveApplication(ApplicationRequestVo vo) {
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
