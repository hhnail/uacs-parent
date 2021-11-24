package com.jmu.uacs.association.service.impl;

import com.jmu.uacs.association.bean.*;
import com.jmu.uacs.association.mapper.ApplicationMapper;
import com.jmu.uacs.association.mapper.RecruitmentMapper;
import com.jmu.uacs.association.mapper.UserRoleMapper;
import com.jmu.uacs.association.service.ApplicationService;
import com.jmu.uacs.association.service.RecruitmentService;
import com.jmu.uacs.enums.DateTemplate;
import com.jmu.uacs.enums.RoleTypeEnum;
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
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    ApplicationMapper applicationMapper;


    @Override
    public int addRecruitment(AddRecruitmentRequestVo reqVo) {
        Recruitment record = new Recruitment();
        BeanUtils.copyProperties(reqVo, record);

        record.setStartTime(StringUtils.parseString2Date(reqVo.getStartTime(), DateTemplate.yyyyMMdd));
        record.setEndTime(StringUtils.parseString2Date(reqVo.getEndTime(), DateTemplate.yyyyMMdd));
        record.setView(0); // 默认浏览量 0

//        log.debug("==24 纳新S 开始时间：{}", reqVo);
//        log.debug("==24 纳新S 开始时间：{}", StringUtils.formatDate2String(record.getStartTime(), DateTemplate.yyyyMMdd));
//        log.debug("==24 纳新S 结束时间：{}", StringUtils.formatDate2String(record.getEndTime(), DateTemplate.yyyyMMdd));
//        log.debug("==24 纳新S record ={}", record);


        int affectedNum = recruitmentMapper.insertSelective(record);
        return affectedNum;
    }

    @Override
    public List<RecruitmentRespVo> getRecruitment(RecruitmentReqVo requestVo) {
        // 如果userId非空，并且其角色是超级管理员。排除userId的查询条件，查出所有的纳新通知
        if (requestVo.getUserId() != null) {
            UserRoleExample exp = new UserRoleExample();
            exp.createCriteria().andUserIdEqualTo(requestVo.getUserId()).andRoleIdEqualTo(RoleTypeEnum.SUPER_ADMIN.getCode());
            List<UserRole> userRoles = userRoleMapper.selectByExample(exp);
            if (userRoles.size() > 0) {
                requestVo.setUserId(null);
            }
        }

        List<RecruitmentRespVo> respList = recruitmentMapper.getRecruitment(requestVo);

        return respList;
    }

    public Recruitment getRecruitmentById(Integer recruitmentId) {
        return recruitmentMapper.selectByPrimaryKey(recruitmentId);
    }

    @Override
    public Boolean updateRecruitmentState(Integer recruitmentId, String state) {
        RecruitmentExample exp = new RecruitmentExample();
        exp.createCriteria().andRecruitmentIdEqualTo(recruitmentId);

        Recruitment rec = new Recruitment();
        rec.setRecruitmentId(recruitmentId);
        rec.setState(state);
        rec.setUpdateTime(new Date());

        int affectedRow = recruitmentMapper.updateByExampleSelective(rec, exp);
        return affectedRow > 0;
    }

    @Override
    public List<RecruitmentRespVo> getRecentRecruitment(Integer associationId, Integer size) {
        List<RecruitmentRespVo> voList = recruitmentMapper.getRecentRecruitment(associationId, size);
        return voList;
    }

    @Override
    public Boolean checkCanRecruitment(String userId, Integer recruitmentId) {
        ApplicationExample exp = new ApplicationExample();
        exp.createCriteria().andUserIdEqualTo(userId).andRecruitmentIdEqualTo(recruitmentId);
        List<Application> applications = applicationMapper.selectByExample(exp);
        if (applications.size() > 0) {
            return false;
        }
        return true;
    }
}
