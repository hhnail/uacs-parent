package com.jmu.uacs.association.mapper;

import com.jmu.uacs.association.bean.Department;
import com.jmu.uacs.association.bean.DepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {
    long countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int deleteByPrimaryKey(Integer departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(Integer departmentId);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}