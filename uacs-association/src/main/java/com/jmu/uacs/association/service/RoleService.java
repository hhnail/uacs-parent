package com.jmu.uacs.association.service;

import com.jmu.uacs.vo.request.ReGrantPermissions2RoleReqVo;
import com.jmu.uacs.vo.response.RoleRespVo;

import java.util.List;

public interface RoleService {
    List<RoleRespVo> getRoleList();

    /**
     * 重新为角色授予权限
     * @param reGrantPermissions2RoleReqVo
     * @return
     */
    int reGrantPermissions2Role(ReGrantPermissions2RoleReqVo reGrantPermissions2RoleReqVo);

    /**
     * 根据userId获取其拥有的角色
     * @param userId
     * @return
     */
    List<RoleRespVo> getRoleListByUserId(String userId);
}
