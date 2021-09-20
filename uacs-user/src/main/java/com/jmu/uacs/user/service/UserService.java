package com.jmu.uacs.user.service;

import com.jmu.uacs.vo.request.UserInfoReqVo;
import com.jmu.uacs.vo.request.UserRegistVo;
import com.jmu.uacs.vo.response.UserInfoVo;
import com.jmu.uacs.vo.response.UserResponseVo;

import java.util.List;

public interface UserService {

    int saveUser(UserRegistVo vo);

    UserResponseVo login(String userId, String password);

    UserInfoVo getUserInfo(String accessToken);

    Integer getUserIdByToken(String accessToken);

    int updateUserInfo(UserInfoReqVo vo);

    List<UserInfoVo> getUserList(List<String> userIdList);
}
