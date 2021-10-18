package com.jmu.uacs.user.feign.exception;

import com.jmu.uacs.user.feign.AssociationServiceFeign;
import com.jmu.uacs.vo.response.AppResponse;
import com.jmu.uacs.vo.response.UserManageVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AssociationServiceFeignHandleException implements AssociationServiceFeign {

    @Override
    public AppResponse<UserManageVo> getUserById(String userId) {
        AppResponse<UserManageVo> resp = AppResponse.fail(null);
        resp.setMsg("后台服务user-调用远程association远程服务-getUserById失败！");
        log.debug("后台服务user-调用远程association远程服务-getUserById失败！userId，", userId);
        return resp;
    }
}