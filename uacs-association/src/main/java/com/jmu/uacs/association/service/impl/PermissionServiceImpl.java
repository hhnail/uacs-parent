package com.jmu.uacs.association.service.impl;

import com.jmu.uacs.association.bean.Permission;
import com.jmu.uacs.association.bean.PermissionExample;
import com.jmu.uacs.association.mapper.PermissionMapper;
import com.jmu.uacs.association.service.PermissionService;
import com.jmu.uacs.vo.request.PermissionUpdateVo;
import com.jmu.uacs.vo.response.PermissionVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;


    @Override
    public List<PermissionVo> getPermissionListByUserId(String userId) {
        // 为一级菜单准备vo
        List<PermissionVo> firstVoList = new ArrayList<>();
        // 查询一级菜单
        List<Permission> firstDoList = permissionMapper.getPermissionListByGrade(1);
        log.debug("==1 一级菜单列表 firstDoList={}", firstDoList);

        // 封装VO 并 注入子菜单
        for (Permission pms : firstDoList) {
            PermissionVo firstVo = new PermissionVo();
            // 1 转化vo
            BeanUtils.copyProperties(pms, firstVo);
            firstVo.setKey(pms.getPermissionId());
            firstVoList.add(firstVo);
            // 2 根据一级菜单的id获取其子菜单
            List<Permission> secondDoList = permissionMapper.getChildrenByPUserId(userId, pms.getPermissionId());
            for (Permission secondPsm : secondDoList) {
                PermissionVo secondVo = new PermissionVo();
                BeanUtils.copyProperties(secondPsm, secondVo);
                secondVo.setKey(secondPsm.getPermissionId());
                firstVo.getChildren().add(secondVo);
            }
        }
        return firstVoList;
    }

    @Override
    public List<PermissionVo> getPermissionList() {
        // 为一级菜单准备vo
        List<PermissionVo> firstVoList = new ArrayList<>();
        // 查询一级菜单
        List<Permission> firstDoList = permissionMapper.getPermissionListByGrade(1);
        log.debug("==1 一级菜单列表 firstDoList={}", firstDoList);

        for (Permission pms : firstDoList) {
            PermissionVo firstVo = new PermissionVo();
            BeanUtils.copyProperties(pms, firstVo);
            firstVo.setKey(pms.getPermissionId());
            firstVoList.add(firstVo);
            List<Permission> secondDoList = permissionMapper.getChildrenByPid(pms.getPermissionId());
            for (Permission secondPsm : secondDoList) {
                PermissionVo secondVo = new PermissionVo();
                BeanUtils.copyProperties(secondPsm, secondVo);
                secondVo.setKey(secondPsm.getPermissionId());
                firstVo.getChildren().add(secondVo);
            }
        }
        return firstVoList;
    }

    @Override
    public Integer deletePermissionById(Integer permissionId) {
        Permission permission = permissionMapper.selectByPrimaryKey(permissionId);
        permission.setIsDel(1);
        int affectedRows = permissionMapper.updateByPrimaryKey(permission);
        return affectedRows;
    }

    @Override
    public Integer updatePermissionById(PermissionUpdateVo permissionUpdateVo) {
        Integer permissionId = permissionUpdateVo.getPermissionId();
        // 需要update的记录
        Permission permissionDO = permissionMapper.selectByPrimaryKey(permissionId);
        permissionDO.setType(permissionUpdateVo.getType());
        // where条件
        PermissionExample pmsExp = new PermissionExample();
        pmsExp.createCriteria().andPermissionIdEqualTo(permissionId);
        // updateByExampleSelective。example中有的就会更新，没有的就不动，相当于前端的patch
        int affectedRows = permissionMapper.updateByExampleSelective(permissionDO, pmsExp);
        return affectedRows;
    }

}
