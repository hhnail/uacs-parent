package com.jmu.uacs.association.service;

import com.jmu.uacs.vo.request.PermissionUpdateVo;
import com.jmu.uacs.vo.response.PermissionVo;

import java.util.List;
import java.util.Map;

public interface PermissionService {

    List<PermissionVo> getPermissionList();

    Integer deletePermissionById(Integer permissionId);

    Integer updatePermissionById(PermissionUpdateVo permissionUpdateVo);
}
