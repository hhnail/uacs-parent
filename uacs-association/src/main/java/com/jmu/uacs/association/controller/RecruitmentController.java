package com.jmu.uacs.association.controller;

import com.jmu.uacs.association.service.RecruitmentService;
import com.jmu.uacs.vo.request.AddRecruitmentRequestVo;
import com.jmu.uacs.vo.response.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
