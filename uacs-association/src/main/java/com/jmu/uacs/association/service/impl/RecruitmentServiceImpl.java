package com.jmu.uacs.association.service.impl;

import com.jmu.uacs.association.bean.Recruitment;
import com.jmu.uacs.association.mapper.RecruitmentMapper;
import com.jmu.uacs.association.service.RecruitmentService;
import com.jmu.uacs.enums.DateTemplate;
import com.jmu.uacs.util.StringUtils;
import com.jmu.uacs.vo.request.AddRecruitmentRequestVo;
import com.jmu.uacs.vo.request.RecruitmentReqVo;
import com.jmu.uacs.vo.response.RecruitmentRespVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class RecruitmentServiceImpl implements RecruitmentService {

    @Autowired
    RecruitmentMapper recruitmentMapper;


    @Override
    public int addRecruitment(AddRecruitmentRequestVo reqVo) {
        Recruitment record = new Recruitment();
        BeanUtils.copyProperties(reqVo, record);

        record.setStartTime(StringUtils.parseString2Date(reqVo.getStartTime(), DateTemplate.yyyyMMdd));
        record.setEndTime(StringUtils.parseString2Date(reqVo.getEndTime(), DateTemplate.yyyyMMdd));
        record.setView(0); // 默认浏览量 0

        log.debug("==24 纳新S 开始时间：{}", reqVo);
        log.debug("==24 纳新S 开始时间：{}", StringUtils.formatDate2String(record.getStartTime(), DateTemplate.yyyyMMdd));
        log.debug("==24 纳新S 结束时间：{}", StringUtils.formatDate2String(record.getEndTime(), DateTemplate.yyyyMMdd));
        log.debug("==24 纳新S record ={}", record);


        int affectedNum = recruitmentMapper.insertSelective(record);
        return affectedNum;
    }

    @Override
    public List<RecruitmentRespVo> getRecruitment(RecruitmentReqVo requestVo) {
        List<RecruitmentRespVo> respList = recruitmentMapper.getRecruitment(requestVo);
        return respList;
    }

    public Recruitment getRecruitmentById(Integer recruitmentId) {
        return recruitmentMapper.selectByPrimaryKey(recruitmentId);
    }

    @Override
    public Boolean updateRecruitmentState(Integer recruitmentId, String state) {
        Recruitment recruitmentById = getRecruitmentById(recruitmentId);
        Recruitment rec = new Recruitment();
        BeanUtils.copyProperties(recruitmentById, rec);
        rec.setState(state);
        rec.setUpdateTime(new Date());
        int affectedRow = recruitmentMapper.updateByPrimaryKey(rec);
        return affectedRow > 0;
    }
}
