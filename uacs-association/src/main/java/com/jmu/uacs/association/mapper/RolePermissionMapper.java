package com.jmu.uacs.association.mapper;

import com.jmu.uacs.association.bean.Permission;
import com.jmu.uacs.association.bean.RolePermission;
import com.jmu.uacs.association.bean.RolePermissionExample;
import java.util.List;

import com.jmu.uacs.vo.response.PermissionVo;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionMapper {
    long countByExample(RolePermissionExample example);

    int deleteByExample(RolePermissionExample example);

    int deleteByPrimaryKey(Integer rolePermissionId);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    List<RolePermission> selectByExample(RolePermissionExample example);

    RolePermission selectByPrimaryKey(Integer rolePermissionId);

    int updateByExampleSelective(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    int updateByExample(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);

    List<PermissionVo> getPermissionListByRoleId(@Param("roleId")Integer roleId,@Param("isDel")Integer isDel);
}