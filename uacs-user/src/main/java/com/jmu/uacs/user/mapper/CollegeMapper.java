package com.jmu.uacs.user.mapper;

import com.jmu.uacs.user.bean.College;
import com.jmu.uacs.user.bean.CollegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollegeMapper {
    long countByExample(CollegeExample example);

    int deleteByExample(CollegeExample example);

    int deleteByPrimaryKey(Integer collegeId);

    int insert(College record);

    int insertSelective(College record);

    List<College> selectByExample(CollegeExample example);

    College selectByPrimaryKey(Integer collegeId);

    int updateByExampleSelective(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByExample(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);
}