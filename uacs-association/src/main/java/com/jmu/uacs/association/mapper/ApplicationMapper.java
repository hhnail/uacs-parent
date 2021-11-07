package com.jmu.uacs.association.mapper;

import com.jmu.uacs.association.bean.Application;
import com.jmu.uacs.association.bean.ApplicationExample;

import java.util.List;

import com.jmu.uacs.vo.response.ApplicationResponseVO;
import org.apache.ibatis.annotations.Param;

public interface ApplicationMapper {
    long countByExample(ApplicationExample example);

    int deleteByExample(ApplicationExample example);

    int deleteByPrimaryKey(Integer applicationId);

    int insert(Application record);

    int insertSelective(Application record);

    List<Application> selectByExample(ApplicationExample example);

    Application selectByPrimaryKey(Integer applicationId);

    int updateByExampleSelective(@Param("record") Application record, @Param("example") ApplicationExample example);

    int updateByExample(@Param("record") Application record, @Param("example") ApplicationExample example);

    int updateByPrimaryKeySelective(Application record);

    int updateByPrimaryKey(Application record);

    List<ApplicationResponseVO> getApplicationList(@Param("associationIds") Integer[] associationIds);

    ApplicationResponseVO getApplicationDetail(@Param("applicationId") Integer applicationId);

    List<ApplicationResponseVO> getApplicationByUserId(@Param("userId")String userId);
}