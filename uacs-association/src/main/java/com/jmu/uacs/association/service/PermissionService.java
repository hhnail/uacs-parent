package com.jmu.uacs.association.service;

import com.jmu.uacs.vo.request.PermissionUpdateVo;
import com.jmu.uacs.vo.response.PermissionVo;

import java.util.List;

public interface PermissionService {

    List<PermissionVo> getPermissionList();

    List<PermissionVo> getPermissionListByUserId(String userId);

    Integer deletePermissionById(Integer permissionId);

    Integer updatePermissionById(PermissionUpdateVo permissionUpdateVo);
}
