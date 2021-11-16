package com.jmu.uacs.association.service;

import com.jmu.uacs.enums.ApplicationStateEnum;
import com.jmu.uacs.vo.request.ApplicationRequestVo;
import com.jmu.uacs.vo.request.InterviewReqVO;
import com.jmu.uacs.vo.response.ApplicationResponseVO;

import java.util.List;

public interface ApplicationService {

    void saveApplication(ApplicationRequestVo vo);

    List<ApplicationResponseVO> getApplicationList(Integer[] associationIds);

    ApplicationResponseVO getApplicationDetail(Integer applicationId);

    List<ApplicationResponseVO> getApplicationByUserId(String userId);

    void updateApplicationState(Integer applicationId, String state);

    void updateApplicationInterview(InterviewReqVO reqVO);
}
