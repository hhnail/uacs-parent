package com.jmu.uacs.association.service.impl;

import com.jmu.uacs.association.mapper.RecruitmentMapper;
import com.jmu.uacs.association.service.RecruitmentService;
import com.jmu.uacs.vo.request.AddRecruitmentRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {

    @Autowired
    RecruitmentMapper recruitmentMapper;


    @Override
    public int addRecruitment(AddRecruitmentRequestVo reqVo) {

        return 0;
    }
}