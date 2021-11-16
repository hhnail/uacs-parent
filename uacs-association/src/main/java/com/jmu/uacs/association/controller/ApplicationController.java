package com.jmu.uacs.association.controller;

import com.jmu.uacs.association.service.ApplicationService;
import com.jmu.uacs.enums.ApplicationStateEnum;
import com.jmu.uacs.enums.ResponseCodeEnume;
import com.jmu.uacs.vo.request.ApplicationRequestVo;
import com.jmu.uacs.vo.request.InterviewReqVO;
import com.jmu.uacs.vo.response.AppResponse;
import com.jmu.uacs.vo.response.ApplicationResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
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
    public AppResponse<List<ApplicationResponseVO>> getApplicationList(@RequestParam Integer[] associationIds) {
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
    public AppResponse<String> saveApplication(@RequestBody ApplicationRequestVo reqVO) {
        try {
            log.debug("申请表提交内容：【{}】", reqVO);
            applicationService.saveApplication(reqVO);
            AppResponse<String> resp = AppResponse.ok("ok");
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<String> resp = AppResponse.fail(null);
            resp.setMsg(ResponseCodeEnume.FAIL.getMsg());
            return resp;
        }
    }


    @ApiOperation("查询申请表详情")
    @ResponseBody
    @GetMapping("/getApplicationDetail/{applicationId}")
    public AppResponse<ApplicationResponseVO> getApplicationDetail(@PathVariable("applicationId") Integer applicationId) {
        try {
            ApplicationResponseVO resList = applicationService.getApplicationDetail(applicationId);
            AppResponse<ApplicationResponseVO> resp = AppResponse.ok(resList);
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<ApplicationResponseVO> resp = AppResponse.fail(null);
            resp.setMsg(ResponseCodeEnume.FAIL.getMsg());
            return resp;
        }
    }

    @ApiOperation("查询某用户的申请列表")
    @ResponseBody
    @GetMapping("/getApplicationByUserId/{userId}")
    public AppResponse<List<ApplicationResponseVO>> getApplicationByUserId(@PathVariable("userId") String userId) {
        try {
            List<ApplicationResponseVO> resList = applicationService.getApplicationByUserId(userId);
            AppResponse<List<ApplicationResponseVO>> resp = AppResponse.ok(resList);
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<List<ApplicationResponseVO>> resp = AppResponse.fail(null);
            resp.setMsg(ResponseCodeEnume.FAIL.getMsg());
            return resp;
        }
    }

    @ApiOperation("更新申请状态")
    @ResponseBody
    @PostMapping("/updateApplicationState")
    public AppResponse<String> updateApplicationState(
            @RequestParam Integer applicationId,
            @RequestParam String state
    ) {
        try {
            applicationService.updateApplicationState(applicationId, ApplicationStateEnum.valueOf(state).toString());
            AppResponse<String> resp = AppResponse.ok(null);
            resp.setMsg("更新状态成功！");
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<String> resp = AppResponse.fail(null);
            resp.setMsg(ResponseCodeEnume.FAIL.getMsg());
            return resp;
        }
    }

    @ApiOperation("更新申请面试安排")
    @ResponseBody
    @PostMapping("/updateApplicationInterview")
    public AppResponse<String> updateApplicationInterview(@RequestBody InterviewReqVO reqVO) {
        try {
            log.debug("面试VO = {}", reqVO);
            applicationService.updateApplicationInterview(reqVO);
            AppResponse<String> resp = AppResponse.ok(null);
            resp.setMsg("更新面试安排成功！");
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<String> resp = AppResponse.fail(null);
            resp.setMsg(ResponseCodeEnume.FAIL.getMsg());
            return resp;
        }
    }

}
