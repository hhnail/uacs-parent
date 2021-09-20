package com.jmu.uacs.association.mapper;

import com.jmu.uacs.association.bean.Role;
import com.jmu.uacs.association.bean.RoleExample;

import java.util.List;

import com.jmu.uacs.bean.Permission;
import com.jmu.uacs.vo.response.RoleRespVo;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Permission> getPermissionIdsByRoleId(@Param("roleId") Integer roleId, @Param("isDel") Integer isDel);

    /**
     * 为roleId的角色，插入拥有的权限id的集合（中间表）
     *
     * @param roleId：要授权的角色id
     * @param permissionIds：授予的权限id集合
     * @return：受影响的行数，即插入的记录数量
     */
    int insertRolePermissionIds(@Param("roleId") Integer roleId, @Param("permissionIds") List<Integer> permissionIds);

    List<RoleRespVo> getRoleListByUserId(@Param("userId") String userId, @Param("isDel") Integer isDel);
}