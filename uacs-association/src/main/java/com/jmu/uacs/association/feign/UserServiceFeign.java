package com.jmu.uacs.association.feign;

import com.jmu.uacs.association.feign.exception.UserServiceFeignHandleException;
import com.jmu.uacs.vo.response.AppResponse;
import com.jmu.uacs.vo.response.UserInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "UACS-USER", fallback = UserServiceFeignHandleException.class)
public interface UserServiceFeign {

    @PostMapping("/user/getUserList")
    AppResponse<List<UserInfoVo>> getUserList(@RequestBody List<String> userIdList);


}