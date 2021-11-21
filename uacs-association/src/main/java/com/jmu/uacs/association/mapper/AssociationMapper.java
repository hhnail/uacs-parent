package com.jmu.uacs.association.mapper;

import com.jmu.uacs.association.bean.Association;
import com.jmu.uacs.association.bean.AssociationExample;

import java.util.List;

import com.jmu.uacs.association.bean.PieData;
import com.jmu.uacs.vo.response.AssoicationResponseVo;
import org.apache.ibatis.annotations.Param;

public interface AssociationMapper {
    long countByExample(AssociationExample example);

    int deleteByExample(AssociationExample example);

    int deleteByPrimaryKey(Integer associationId);

    int insert(Association record);

    int insertSelective(Association record);

    List<Association> selectByExample(AssociationExample example);

    Association selectByPrimaryKey(Integer associationId);

    int updateByExampleSelective(@Param("record") Association record, @Param("example") AssociationExample example);

    int updateByExample(@Param("record") Association record, @Param("example") AssociationExample example);

    int updateByPrimaryKeySelective(Association record);

    int updateByPrimaryKey(Association record);

    List<Association> getAssociationByUserId(@Param("userId") String userId, @Param("roleIds") Integer[] roleIds);

    List<AssoicationResponseVo> getAssociationAsMember(@Param("userId") String userId);

    List<PieData> countAssociationGender(@Param("associationId") Integer associationId);
}