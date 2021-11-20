package com.jmu.uacs.association.service.impl;

import com.jmu.uacs.association.bean.Role;
import com.jmu.uacs.association.bean.RolePermissionExample;
import com.jmu.uacs.association.mapper.RoleMapper;
import com.jmu.uacs.association.mapper.RolePermissionMapper;
import com.jmu.uacs.association.service.RoleService;
import com.jmu.uacs.bean.Permission;
import com.jmu.uacs.vo.request.ReGrantPermissions2RoleReqVo;
import com.jmu.uacs.vo.response.PermissionVo;
import com.jmu.uacs.vo.response.RoleRespVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;
    @Autowired
    RolePermissionMapper rolePermissionMapper;


    @Override
    public List<RoleRespVo> getRoleList() {
        List<RoleRespVo> respVo = new ArrayList<>();

        List<Role> all = roleMapper.selectByExample(null);
        log.debug("==301 角色基本信息={}", all);
        for (Role role : all) {
            // 1、角色基本信息
            RoleRespVo vo = new RoleRespVo();
            BeanUtils.copyProperties(role, vo);
            // 2、角色对应权限列表
            log.debug("==305 roleI={}", role.getRoleId());
            List<PermissionVo> permissionVoList = new ArrayList<>();
            List<Permission> permissionDoList = roleMapper.getPermissionIdsByRoleId(role.getRoleId(), 0);
            log.debug("==302 角色对应权限列表={}", permissionDoList);
            // 3、将权限列表转换为VO再注入到角色，从而完善角色的权限列表
            for (Permission pms : permissionDoList) {
                PermissionVo pmsVo = new PermissionVo();
                BeanUtils.copyProperties(pms, pmsVo);
                pmsVo.setKey(pms.getPermissionId());
                permissionVoList.add(pmsVo);
            }
            log.debug("==303 角色对应权限VO列表={}", permissionVoList);
            // 将权限列表set到角色中
            vo.setPermissions(permissionVoList);
            // 完整vo加入集合
            respVo.add(vo);
        }
        return respVo;
    }

    @Override
    public int reGrantPermissions2Role(ReGrantPermissions2RoleReqVo reGrantPermissions2RoleReqVo) {
        Integer roleId = reGrantPermissions2RoleReqVo.getRoleId();
        List<Integer> permissionIds = reGrantPermissions2RoleReqVo.getPermissionIds();

        // 后端校验
        boolean errorFlag = true;
        for (int i = 0; i < permissionIds.size(); i++) {
//            log.debug("current permissionId={},比较结果{}", permissionIds.get(i),permissionIds.get(i) == 13);
            // 如果新权限列表有13。即有角色管理权限，才能更新
            if (permissionIds.get(i) == 13) {
                errorFlag = false;
            }
        }
        if (errorFlag) {
            throw new RuntimeException("操作非法！");
        }

        // 1、把该角色的全部permission都删掉
        RolePermissionExample rolePermissionExp = new RolePermissionExample();
        rolePermissionExp.createCriteria().andRoleIdEqualTo(roleId);
        rolePermissionMapper.deleteByExample(rolePermissionExp);

        // 2、把permission批量插入
        log.debug("==205 permissionIds", permissionIds);
        int affectedRowNums = roleMapper.insertRolePermissionIds(roleId, permissionIds);

//        return 1;
        return affectedRowNums;
    }


    @Override
    public List<RoleRespVo> getRoleListByUserId(String userId) {
        List<RoleRespVo> roleList = roleMapper.getRoleListByUserId(userId, 0);
        log.debug("==1 未set权限列表的角色集合", roleList);
//        for (RoleRespVo roleVo : roleList) {
//            List<PermissionVo> pmsVoList = rolePermissionMapper.getPermissionListByRoleId(roleVo.getRoleId(),0);
//            roleVo.setPermissions(pmsVoList);
//        }
        log.debug("==1 service层最终的role集合", roleList);
        return roleList;
    }


}
