package com.jmu.uacs.user.controller;

import com.jmu.uacs.enums.ResponseCodeEnume;
import com.jmu.uacs.user.service.TagService;
import com.jmu.uacs.user.service.UserService;
import com.jmu.uacs.vo.response.AppResponse;
import com.jmu.uacs.vo.response.TagRespVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@Api(tags = "标签模块")
@RequestMapping("/tag") // 父路径
@Controller
public class TagController {

    @Autowired
    TagService tagService;

    @Autowired
    UserService userService;


    @ApiOperation(value = "获取所有的标签")
    @ResponseBody
    @GetMapping("/getAllTags")
    public AppResponse<Map<String, List<TagRespVo>>> getAllTags() {
        try {
            Map<String, List<TagRespVo>> allTags = tagService.getAllTags();
            AppResponse<Map<String, List<TagRespVo>>> respList = AppResponse.ok(allTags);
            return respList;
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("=22 获取兴趣爱好标签失败-token{}-异常信息{}", e.getMessage());
            AppResponse<Map<String, List<TagRespVo>>> resp = AppResponse.fail(null);
            resp.setMsg(ResponseCodeEnume.FAIL.getMsg());
            return resp;
        }
    }

    /**
     * 获取用户个人的标签
     *
     * @param accessToken 访问令牌
     * @return 标签列表
     */
    @ApiOperation(value = "获取某用户的标签")
    @ResponseBody
    @PostMapping("/getUserTags")
    public AppResponse<List<TagRespVo>> getUserTags(@RequestParam("accessToken") String accessToken) {
        //顶层异常捕获
        try {
            //因为service之间要避免相互调用，所以在Controller换取id
            log.debug("==23 后台服务-controller-获取兴趣爱好 accessToken={}", accessToken);
            String userId = userService.getUserIdByToken(accessToken);
            log.debug("==24 后台服务-controller-获取兴趣爱好 userId={}", userId);
            List<TagRespVo> userTags = tagService.getUserTagById(userId);
            return AppResponse.ok(userTags);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("=22 获取兴趣爱好标签失败-token{}-异常信息{}", accessToken, e.getMessage());
            AppResponse<List<TagRespVo>> resp = AppResponse.fail(null);
            resp.setMsg(ResponseCodeEnume.FAIL.getMsg());
            return resp;
        }
    }
}
