package com.jmu.uacs.association.feign.exception;

import com.jmu.uacs.association.feign.UserServiceFeign;
import com.jmu.uacs.vo.response.AppResponse;
import com.jmu.uacs.vo.response.UserInfoVo;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class UserServiceFeignHandleException implements UserServiceFeign {

    @Override
    public AppResponse<List<UserInfoVo>> getUserList(List<String> userIdList) {
        AppResponse<List<UserInfoVo>> resp = AppResponse.fail(null);
        resp.setMsg("后台服务association-调用远程user远程服务-getUserList失败！");
        log.debug("后台服务association-调用远程user远程服务-getUserList{} 失败！",userIdList);
        return resp;
    }
}
