package com.jmu.uacs.association.mapper;

import com.jmu.uacs.association.bean.Recruitment;
import com.jmu.uacs.association.bean.RecruitmentExample;

import java.util.List;

import com.jmu.uacs.association.bean.RingGauge;
import com.jmu.uacs.vo.request.RecruitmentReqVo;
import com.jmu.uacs.vo.response.RecruitmentRespVo;
import org.apache.ibatis.annotations.Param;

public interface RecruitmentMapper {
    long countByExample(RecruitmentExample example);

    int deleteByExample(RecruitmentExample example);

    int deleteByPrimaryKey(Integer recruitmentId);

    int insert(Recruitment record);

    int insertSelective(Recruitment record);

    List<Recruitment> selectByExample(RecruitmentExample example);

    Recruitment selectByPrimaryKey(Integer recruitmentId);

    int updateByExampleSelective(@Param("record") Recruitment record, @Param("example") RecruitmentExample example);

    int updateByExample(@Param("record") Recruitment record, @Param("example") RecruitmentExample example);

    int updateByPrimaryKeySelective(Recruitment record);

    int updateByPrimaryKey(Recruitment record);

    List<RecruitmentRespVo> getRecruitment(@Param("option") RecruitmentReqVo option);

    List<RecruitmentRespVo> getRecentRecruitment(@Param("associationId") Integer associationId, @Param("size") Integer size);

    List<RingGauge> countAssociationRecruitment(@Param("recruitmentId") Integer recruitmentId);
}