package com.jmu.uacs.user.controller;

import com.jmu.uacs.user.bean.User;
import com.jmu.uacs.user.service.UserService;
import com.jmu.uacs.user.util.SmsTemplate;
import com.jmu.uacs.util.StringUtils;
import com.jmu.uacs.vo.request.UserInfoReqVo;
import com.jmu.uacs.vo.request.UserRegistVo;
import com.jmu.uacs.vo.request.UserResumeReqVO;
import com.jmu.uacs.vo.request.UserSettingsUpdateReqVO;
import com.jmu.uacs.vo.response.AppResponse;
import com.jmu.uacs.vo.response.UserInfoVo;
import com.jmu.uacs.vo.response.UserResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
@Api(tags = "用户模块")
@RequestMapping("/user") // 父路径
@RestController
public class UserController {

    @Autowired
    SmsTemplate smsTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    UserService userService;

    @ApiOperation(value = "发送短信验证码")
    @PostMapping("/sendsms")
    public AppResponse<Object> sendsms(String phone) {
        // 随机生成4个10以内的数作为验证码。也可以截取UUID的一部分作为验证码
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            code.append(new Random().nextInt(10));
        }

        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", phone);
        querys.put("param", "code:" + code.toString());// 验证码
        querys.put("tpl_id", "TP1711063");// 短信模板

        smsTemplate.sendSms(querys);

        // 将验证码存到redis中
        // stringRedisTemplate.opsForValue().set(phone, code.toString());
        stringRedisTemplate.opsForValue().set(phone, code.toString(), 5, TimeUnit.MINUTES);

        log.debug("发送短信成功-验证码:{}", code.toString());

        return AppResponse.ok("ok");
    }


    // TODO 用户一旦注册，需要到user_permission表中，注册角色（社团ID为-1，角色为普通学生！）

    /**
     * 用户注册
     */
    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public AppResponse<Object> register(@RequestBody UserRegistVo vo) {
        log.debug("==7 服务端-用户注册-接收vo={}", vo);

        // 前后端都需要校验。校验也可以放到过滤器实现
        // 校验账号非空
        String userId = vo.getUserId();
        if (StringUtils.isEmpty(userId)) {
            AppResponse<Object> resp = AppResponse.fail(null);
            resp.setMsg("用户账号不得为null！");
            return resp;
        }

        // 校验验证码非空
        String redisCode = stringRedisTemplate.opsForValue().get(vo.getPhone());
        if (StringUtils.isEmpty(redisCode)) {
            AppResponse<Object> resp = AppResponse.fail(null);
            resp.setMsg("验证码已失效，请重新发送！");
            return resp;
        }

        // 待优化的校验 1、账号是否唯一 2、email是否被占用 3、一个账号一天发送验证码短信有限制

        // 校验验证码是否正确
        if (!redisCode.equals(vo.getCheckCode())) {
            AppResponse<Object> resp = AppResponse.fail(null);
            resp.setMsg("验证码错误！");
            return resp;
        }

        // 验证全部通过，保存注册信息
        int changeNum = userService.saveUser(vo);

        // 检查是否保存成功
        if (changeNum != 1) {
            return AppResponse.fail(null);
        }
        // 保存成功后，删除缓存中的验证码
        stringRedisTemplate.delete(vo.getPhone());
        return AppResponse.ok("ok");
    }


    @ApiOperation(value = "用户登陆") // swagger-ui
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "登陆账号（学号）", name = "userId"),
            @ApiImplicitParam(value = "用户密码", name = "password")})
    @PostMapping("/login")
    public AppResponse<UserResponseVo> login(@RequestParam("userId") String userId,
                                             @RequestParam("password") String password) {
        try {
            log.debug("登录表单数据userId-{}", userId); // 生产环境不要打印密码
            UserResponseVo vo = userService.login(userId, password);
            log.debug("login vo = {}", vo);
            return AppResponse.ok(vo);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("登录失败-{}-{}", userId, e.getMessage());
            AppResponse resp = AppResponse.fail(null);
            resp.setMsg(e.getMessage());
            return resp;
        }
    }

    @ApiOperation(value = "获取个人信息")
    @PostMapping("/getUserInfo")
    public AppResponse<UserInfoVo> getUserInfo(@RequestParam("accessToken") String accessToken) {
        try {
            log.debug("==uacs-user controller accessToken={}", accessToken);

            UserInfoVo vo = userService.getUserInfo(accessToken);
            return AppResponse.ok(vo);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("获取个人信息失败-token{}-报错信息{}", accessToken, e.getMessage());
            AppResponse<UserInfoVo> resp = AppResponse.fail(null);
            resp.setMsg(e.getMessage());
            return resp;
        }
    }

    /**
     * @param vo
     * @return
     */
    @ApiOperation(value = "更新个人信息")
    @PostMapping("/updateUserInfo")
    public AppResponse<Integer> updateUserInfo(@RequestBody UserInfoReqVo vo) {
        try {
            log.debug("==2== uacs-user updateUserInfo controller vo={}", vo);
            int changedNum = userService.updateUserInfo(vo);
            return AppResponse.ok(changedNum);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("更新个人信息-{}-{}", vo.getAccessToken(), e.getMessage());
            AppResponse<Integer> resp = AppResponse.fail(null);
            resp.setMsg(e.getMessage());
            return resp;
        }
    }

    /**
     * 验证用户accessToken，并将用户主键返回
     *
     * @param accessToken
     * @return
     */
    @ApiOperation(value = "验证访问令牌")
    @PostMapping("/getUserPrimaryKey")
    public AppResponse<String> getUserPrimaryKey(@RequestParam("accessToken") String accessToken) {
        String userId = userService.getUserIdByToken(accessToken);
        AppResponse<String> resp = AppResponse.ok(userId);
        return resp;
    }

    /**
     * 通过用户userIdList批量获取用户信息
     * 用于例如社团管理员的个人信息的查询（一个社团有多个社团管理员）
     *
     * @param userIdList
     * @return
     */
    @ApiOperation(value = "根据Ids批量获取用户信息")
    @PostMapping("/getUserList")
    public AppResponse<List<UserInfoVo>> getUserList(@RequestBody List<String> userIdList) {
        log.debug("==42 uacs-user controller getUserList userIdList={}", userIdList);
        List<UserInfoVo> voList = userService.getUserList(userIdList);
        AppResponse<List<UserInfoVo>> resp = AppResponse.ok(voList);
        return resp;
    }


    @ApiOperation(value = "更新个人设置")
    @PostMapping("/reset")
    public AppResponse<String> reset(@RequestBody UserSettingsUpdateReqVO reqVO) {

        // 后端校验
        User userById = userService.getUserById(reqVO.getUserId());
        log.debug("==用户C 更新个人设置 前端User密码={}", reqVO.getPassword());
        log.debug("==用户C 更新个人设置 后端User密码={}", userById.getPassword());

        if (userById == null) {
            throw new RuntimeException("用户不存在！");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // 验证密码
        if (!encoder.matches(reqVO.getPassword(), userById.getPassword())) {
            throw new RuntimeException("密码错误！");
        }

        // 如果有新密码，说明需要重置。但是如果没有，该项就不需要更新，置空即可
        if (!StringUtils.isEmpty(reqVO.getNewPassword())) {
            reqVO.setPassword(encoder.encode(reqVO.getNewPassword()));
        } else {
            reqVO.setPassword(null);
        }

        userService.reset(reqVO);
        return AppResponse.ok("更新成功！");
    }

    @ApiOperation(value = "更新个人简历")
    @PostMapping("/updateResume")
    public AppResponse<String> updateResume(@RequestBody UserResumeReqVO reqVO) {
        try {
            log.debug("vo={}", reqVO);
            userService.updateResume(reqVO);
            AppResponse<String> resp = AppResponse.ok(null);
            resp.setMsg("更新成功！");
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<String> fail = AppResponse.fail(null);
            fail.setMsg("更新失败！");
            return fail;
        }
    }


}


