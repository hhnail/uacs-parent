package com.jmu.uacs.association.mapper;

import com.jmu.uacs.association.bean.Class;
import com.jmu.uacs.association.bean.ClassExample;
import java.util.List;

import com.jmu.uacs.vo.response.CascaderClassVo;
import org.apache.ibatis.annotations.Param;

public interface ClassMapper {
    long countByExample(ClassExample example);

    int deleteByExample(ClassExample example);

    int deleteByPrimaryKey(Integer classId);

    int insert(Class record);

    int insertSelective(Class record);

    List<Class> selectByExample(ClassExample example);

    Class selectByPrimaryKey(Integer classId);

    int updateByExampleSelective(@Param("record") Class record, @Param("example") ClassExample example);

    int updateByExample(@Param("record") Class record, @Param("example") ClassExample example);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);

//    List<CascaderClassVo> getCascaderClass();
}