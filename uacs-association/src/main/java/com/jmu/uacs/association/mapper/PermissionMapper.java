package com.jmu.uacs.association.mapper;

import com.jmu.uacs.association.bean.Permission;
import com.jmu.uacs.association.bean.PermissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {
    long countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(Integer permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Integer permissionId);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    /**
     * 根据菜单（权限）级别获取单层权限列表
     * @param grade 菜单级别 1 为一级菜单 2为二级菜单。。。以此类推
     * @return
     */
    List<Permission> getPermissionListByGrade(@Param("grade") Integer grade);

    /**
     * 查询用户id拥有的二级权限权限列表
     * @param userId
     * @param permissionId 此处permissionId也是pId，即父菜单id为pId的二级菜单列表
     * @return
     */
    List<Permission> getChildrenByPid(@Param("userId") String userId, @Param("pId") Integer permissionId);
}