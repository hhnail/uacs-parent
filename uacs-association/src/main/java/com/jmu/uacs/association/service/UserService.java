package com.jmu.uacs.association.service;

import com.jmu.uacs.vo.request.UserAddReqVo;
import com.jmu.uacs.vo.response.UserManageVo;

import java.util.List;

public interface UserService {
    List<UserManageVo> getAllUsers();

    Integer addUser(UserAddReqVo userAddReqVo);

    UserManageVo getUserById(String userId);

    int deleteUserById(String userId);
}
