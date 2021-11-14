package com.jmu.uacs.association.controller;

import com.jmu.uacs.association.feign.UserServiceFeign;
import com.jmu.uacs.association.service.AssociationService;
import com.jmu.uacs.association.service.ImageService;
import com.jmu.uacs.enums.AssociationStateEnum;
import com.jmu.uacs.vo.request.AssociationRequestVo;
import com.jmu.uacs.vo.response.AppResponse;
import com.jmu.uacs.vo.response.AssoicationResponseVo;
import com.jmu.uacs.vo.response.UserAssociationVo;
import com.jmu.uacs.vo.response.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.PathParam;
import java.util.List;


@Slf4j
@Api(tags = "社团模块")
@RequestMapping("/association") // 父路径
@Controller
public class AssociationController {

    @Autowired
    AssociationService associationService;

    @Autowired
    UserServiceFeign userServiceFeign;

    @ResponseBody
    @ApiOperation(value = "查询所有社团")
    @GetMapping("/getAllAssociationList")
    public AppResponse<List<AssoicationResponseVo>> getAllAssociationList() {
        try {
            List<AssoicationResponseVo> list = associationService.getAllAssociationList();
            log.debug("==9 社团信息获取成功！list{}", list);
            return AppResponse.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("==10 社团信息获取失败！{}", e.getMessage());
            AppResponse<List<AssoicationResponseVo>> resp = AppResponse.fail(null);
            resp.setMsg("社团信息获取失败！");
            return resp;
        }
    }

    @ResponseBody
    @ApiOperation(value = "查询某社团信息")
    @GetMapping("/associationInfo/{associationId}")
    public AppResponse<AssoicationResponseVo> getAssociationInfo(@PathVariable("associationId") String associationId) {
        try {
            log.debug("==社团控制器 associationId={}", associationId);
            Integer associationId2 = Integer.parseInt(associationId);
            log.debug("==社团控制器 associationId转化为字符串={}", associationId2);
            AssoicationResponseVo assRespVo = associationService.getAssociationInfo(associationId2);
            AppResponse<AssoicationResponseVo> resp = AppResponse.ok(assRespVo);
            return resp;
        } catch (Exception e) {
            AppResponse<AssoicationResponseVo> resp = AppResponse.fail(null);
            resp.setMsg("社团信息查询失败");
            e.printStackTrace();
            log.error("社团信息查询失败:{}", e.getMessage());
            return resp;
        }
    }

    @ResponseBody
    @ApiOperation(value = "保存社团信息")
    @PostMapping("/saveAssociation")
    public AppResponse<String> saveAssociation(@RequestBody AssociationRequestVo vo) {
        try {

            log.debug("==14 后端服务-创建社团-vo={}", vo);

            associationService.saveAssociation(vo);
            AppResponse<String> resp = AppResponse.ok("ok");
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("==13 后端服务-创建社团 e={}", e.getMessage());

            AppResponse<String> resp = AppResponse.fail(null);
            resp.setMsg("创建社团失败！");
            return resp;
        }
    }

    @ResponseBody
    @ApiOperation(value = "修改社团状态-锁定社团")
    @GetMapping("/lockAssociation")
    public AppResponse<String> lockAssociation(@RequestParam String associationId) {
        try {
            log.debug("==20 后端服务-更新社团状态 associationId={}", associationId);
            associationService.updateAssociationState(associationId, AssociationStateEnum.LOCKED.getCode());
            return AppResponse.ok("ok");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("==19 后端服务-更新社团状态e={}", e.getMessage());

            AppResponse<String> resp = AppResponse.fail(null);
            resp.setMsg("更新社团状态失败！");
            return resp;
        }
    }

    @ResponseBody
    @ApiOperation(value = "查询社团详细信息")
    @GetMapping("/getAssociationDetail")
    AppResponse<AssoicationResponseVo> getAssociationDetail(@RequestParam String associationId) {
        return null;
    }


    @ResponseBody
    @ApiOperation(value = "查询社团管理员")
    @GetMapping("/getAssociationAdmin")
    AppResponse<List<UserInfoVo>> getAssociationAdmin(@RequestParam Integer associationId) {
        log.debug("==40 查询社团管理员-社团id={}", associationId);

        //根据社团ID获取对应社团的管理员
        List<String> userIdList = associationService.getAssociationAdminIdList(associationId);

        //调用远程服务获取用户信息
        AppResponse<List<UserInfoVo>> userList = userServiceFeign.getUserList(userIdList);
        return userList;
    }

    @ResponseBody
    @ApiOperation(value = "查询某用户加入或管理的社团")
    @PostMapping("/getAssociationByUserId")
    AppResponse<List<UserAssociationVo>> getAssociationByUserId(
            @RequestParam String userId,
            @RequestParam Integer[] roleIds
    ) {

        log.debug("==40 社团Impl 查询某用户加入或管理的社团-社团id={}", userId);
        log.debug("==40 查询某用户加入或管理的社团-roleId={}", roleIds);

        List<UserAssociationVo> associationList = associationService.getAssociationByUserId(userId, roleIds);
        AppResponse<List<UserAssociationVo>> resp = AppResponse.ok(associationList);
        return resp;
    }
}
