package com.jmu.uacs.association.controller;

import com.jmu.uacs.association.bean.CountAssociationType;
import com.jmu.uacs.association.bean.PieData;
import com.jmu.uacs.association.bean.RingGauge;
import com.jmu.uacs.association.feign.UserServiceFeign;
import com.jmu.uacs.association.service.AssociationService;
import com.jmu.uacs.association.service.DataViewService;
import com.jmu.uacs.association.service.UserService;
import com.jmu.uacs.vo.response.AppResponse;
import com.jmu.uacs.vo.response.AssoicationResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Api(tags = "社团模块")
@RequestMapping("/association") // 父路径
@Controller
public class DataViewController {

    @Autowired
    DataViewService dataViewService;

    @ResponseBody
    @ApiOperation(value = "统计社团男女生人数")
    @GetMapping("/countAssociationGender/{associationId}")
    public AppResponse<List<PieData>> countAssociationGender(@PathVariable("associationId") Integer associationId) {
        try {
            List<PieData> list = dataViewService.countAssociationGender(associationId);
            return AppResponse.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<List<PieData>> resp = AppResponse.fail(null);
            resp.setMsg("社团信息获取失败！");
            return resp;
        }
    }

    @ResponseBody
    @ApiOperation(value = "统计纳新进度")
    @GetMapping("/countAssociationRecruitment/{recruitmentId}")
    public AppResponse<HashMap<String, Double>> countAssociationRecruitment(@PathVariable("recruitmentId") Integer recruitmentId) {
        try {
            HashMap<String, Double> resultMap = dataViewService.countAssociationRecruitment(recruitmentId);
            return AppResponse.ok(resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<HashMap<String, Double>> resp = AppResponse.fail(null);
            resp.setMsg("统计信息获取失败！");
            return resp;
        }
    }

    @ResponseBody
    @ApiOperation(value = "统计社团类型及总人数")
    @GetMapping("/countAssociationTypeAndNum")
    public AppResponse<List<CountAssociationType>> countAssociationTypeAndNum() {
        try {
            List<CountAssociationType> respList = new ArrayList<>();

            HashMap<String, Integer> resultMap = dataViewService.countAssociationTypeAndNum();
            for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
                respList.add(new CountAssociationType(entry.getKey(), entry.getValue()));
            }
            return AppResponse.ok(respList);
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<List<CountAssociationType>> resp = AppResponse.fail(null);
            resp.setMsg("统计信息获取失败！");
            return resp;
        }
    }
}


