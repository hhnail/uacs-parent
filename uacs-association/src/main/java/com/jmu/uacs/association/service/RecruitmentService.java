package com.jmu.uacs.association.service;

import com.jmu.uacs.vo.request.AddRecruitmentRequestVo;
import com.jmu.uacs.vo.request.RecruitmentReqVo;
import com.jmu.uacs.vo.response.RecruitmentRespVo;

import java.util.List;

public interface RecruitmentService {
    int addRecruitment(AddRecruitmentRequestVo reqVo);

    List<RecruitmentRespVo> getRecruitment(RecruitmentReqVo requestVo);

    Boolean updateRecruitmentState(Integer recruitmentId, String state);
}
