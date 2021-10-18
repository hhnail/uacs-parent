package com.jmu.uacs.association.controller;

import com.jmu.uacs.association.service.RecruitmentService;
import com.jmu.uacs.vo.request.AddRecruitmentRequestVo;
import com.jmu.uacs.vo.request.RecruitmentReqVo;
import com.jmu.uacs.vo.response.AppResponse;
import com.jmu.uacs.vo.response.RecruitmentRespVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "社团模块--纳新")
@RequestMapping("/association") // 父路径
@RestController
public class RecruitmentController {

    @Autowired
    RecruitmentService recruitmentService;

    @ApiOperation("添加社团纳新信息")
    @PostMapping("/addRecruitment")
    public AppResponse<Integer> addRecruitment(@RequestBody AddRecruitmentRequestVo reqVo) {
        try {
            log.debug("==1 纳新C == reqVo={}", reqVo);
            int affectNum = recruitmentService.addRecruitment(reqVo);
            AppResponse<Integer> resp = AppResponse.ok(affectNum);
            resp.setMsg("保存成功！");
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<Integer> fail = AppResponse.fail(null);
            fail.setMsg("保存失败");
            return fail;
        }
    }

    @ApiOperation("查询社团纳新信息")
    @PostMapping("/listRecruitment")
    public AppResponse<List<RecruitmentRespVo>> getRecruitment(@RequestBody RecruitmentReqVo requestVo) {
        try {
            log.debug("==1 纳新列表C == requestVo={}", requestVo);
            List<RecruitmentRespVo> respList = recruitmentService.getRecruitment(requestVo);
            AppResponse<List<RecruitmentRespVo>> resp = AppResponse.ok(respList);
            resp.setMsg("查询成功！");
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<List<RecruitmentRespVo>> fail = AppResponse.fail(null);
            fail.setMsg("查询失败");
            return fail;
        }
    }

    @ApiOperation("查询某条纳新信息")
    @GetMapping("/listRecruitment/{recruitmentId}")
    public AppResponse<RecruitmentRespVo> getRecruitmentById(@PathVariable("recruitmentId") Integer recruitmentId) {

        try {
            log.debug("==1 查询某条纳新信息C == recruitmentId={}", recruitmentId);

            RecruitmentReqVo queryVo = new RecruitmentReqVo();
            queryVo.setRecruitmentId(recruitmentId);
            List<RecruitmentRespVo> data = recruitmentService.getRecruitment(queryVo);
            // 封装返回类型
            AppResponse<RecruitmentRespVo> resp = AppResponse.ok(data.get(0));
            resp.setMsg("查询成功！id：" + recruitmentId);
            return resp;

        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<RecruitmentRespVo> fail = AppResponse.fail(null);
            fail.setMsg("查询失败，id：" + recruitmentId);
            return fail;
        }
    }


}
