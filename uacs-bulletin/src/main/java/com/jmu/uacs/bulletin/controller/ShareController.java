package com.jmu.uacs.bulletin.controller;

import com.jmu.uacs.bulletin.service.ShareService;
import com.jmu.uacs.vo.request.AddShareRequestVO;
import com.jmu.uacs.vo.response.AppResponse;
import com.jmu.uacs.vo.response.RoleRespVo;
import com.jmu.uacs.vo.response.ShareResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Api(tags = "论坛模块--分享")
@RequestMapping("/bulletin") // 父路径
public class ShareController {

    @Autowired
    ShareService shareService;

    @ApiOperation("查询所有社团分享列表")
    @GetMapping("/getShareList")
    public AppResponse<List<ShareResponseVo>> getShareList() {
        List<ShareResponseVo> voLists = shareService.getShareList();
        AppResponse<List<ShareResponseVo>> resp = AppResponse.ok(voLists);
        return resp;
    }

    @ApiOperation("新增社团分享")
    @PostMapping("/addShare")
    public AppResponse<String> addShare(@RequestBody AddShareRequestVO reqVO) {
        log.debug("新增社团分享 reqVO={} ",reqVO);
        shareService.addShare(reqVO);
        AppResponse<String> resp = AppResponse.ok(null);
        resp.setMsg("新增成功！");
        return resp;
    }

    @ApiOperation("查询某条经历分享详情")
    @GetMapping("/getShareById/{shareId}")
    public AppResponse<ShareResponseVo> getShareById(@PathVariable("shareId") String shareId) {
        ShareResponseVo vo = shareService.getShareById(shareId);
        AppResponse<ShareResponseVo> resp = AppResponse.ok(vo);
        return resp;
    }

    @ApiOperation("查询某社团的所有成员经历分享")
    @GetMapping("/getShareByAssociation/{associationId}")
    public AppResponse<List<ShareResponseVo>> getShareByAssociation(@PathVariable("associationId") String associationId) {
        List<ShareResponseVo> vo = shareService.getShareByAssociation(associationId);
        AppResponse<List<ShareResponseVo>> resp = AppResponse.ok(vo);
        return resp;
    }
}
