package com.jmu.uacs.association.service;

import com.jmu.uacs.vo.request.ApplicationRequestVo;
import com.jmu.uacs.vo.response.ApplicationResponseVO;

import java.util.List;

public interface ApplicationService {

    void saveApplication(ApplicationRequestVo vo);

    List<ApplicationResponseVO> getApplicationList(Integer associationId);
}
