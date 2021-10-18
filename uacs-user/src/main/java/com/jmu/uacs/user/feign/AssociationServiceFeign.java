package com.jmu.uacs.user.feign;


import com.jmu.uacs.user.feign.exception.AssociationServiceFeignHandleException;
import com.jmu.uacs.vo.response.AppResponse;
import com.jmu.uacs.vo.response.UserManageVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "UACS-ASSOCIATION", fallback = AssociationServiceFeignHandleException.class)
public interface AssociationServiceFeign {

    @GetMapping("/association/getUserById/{userId}")
    AppResponse<UserManageVo> getUserById(@PathVariable(name = "userId") String userId);
}