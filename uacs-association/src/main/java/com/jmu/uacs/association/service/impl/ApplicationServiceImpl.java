package com.jmu.uacs.association.service.impl;

import com.jmu.uacs.association.bean.Application;
import com.jmu.uacs.association.bean.UserRole;
import com.jmu.uacs.association.bean.UserRoleExample;
import com.jmu.uacs.association.mapper.ApplicationMapper;
import com.jmu.uacs.association.mapper.UserRoleMapper;
import com.jmu.uacs.association.service.ApplicationService;
import com.jmu.uacs.enums.ApplicationStateEnum;
import com.jmu.uacs.enums.DateTemplate;
import com.jmu.uacs.enums.RoleTypeEnum;
import com.jmu.uacs.util.StringUtils;
import com.jmu.uacs.vo.request.ApplicationRequestVo;
import com.jmu.uacs.vo.request.InterviewReqVO;
import com.jmu.uacs.vo.response.ApplicationResponseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    ApplicationMapper applicationMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public void saveApplication(ApplicationRequestVo vo) {
        Application application = new Application();
        BeanUtils.copyProperties(vo, application);
        application.setApplicationTime(new Date());
        application.setState(ApplicationStateEnum.APPLYING.toString());
        applicationMapper.insertSelective(application);
    }

    @Override
    public List<ApplicationResponseVO> getApplicationList(Integer[] associationIds) {
        List<ApplicationResponseVO> resList = applicationMapper.getApplicationList(associationIds);
        return resList;
    }

    @Override
    public ApplicationResponseVO getApplicationDetail(Integer applicationId) {
        return applicationMapper.getApplicationDetail(applicationId);
    }

    @Override
    public List<ApplicationResponseVO> getApplicationByUserId(String userId) {
        List<ApplicationResponseVO> resList = applicationMapper.getApplicationByUserId(userId);
        return resList;
    }

    @Override
    @Transactional
    public void updateApplicationState(Integer applicationId, String state) {
        Application application = new Application();
        application.setApplicationId(applicationId);
        application.setState(state);
        // 确认加入社团。同步user-association-role表逻辑
        if (state.equals(ApplicationStateEnum.CONFIRM.getState())) {
            UserRole ur = new UserRole();
            ApplicationResponseVO applicationDetail = applicationMapper.getApplicationDetail(applicationId);
            ur.setAssociationId(applicationDetail.getAssociationId());
            ur.setDepartmentId(applicationDetail.getDepartmentId());
            ur.setUserId(applicationDetail.getUserId());
            ur.setRoleId(RoleTypeEnum.MEMBER.getCode());
            userRoleMapper.insert(ur);
        }
        applicationMapper.updateByPrimaryKeySelective(application);
    }

    @Override
    public void updateApplicationInterview(InterviewReqVO reqVO) {
        Application a = new Application();
        BeanUtils.copyProperties(reqVO, a);
        // 处理时间
        Date interviewDate = reqVO.getInterviewDate();
        String interviewDateStr = StringUtils.formatDate2String(interviewDate, DateTemplate.yyyyMMddhhmmss);
        Date interviewTime = reqVO.getInterviewTime();
        String interviewTimeStr = StringUtils.formatDate2String(interviewTime, DateTemplate.yyyyMMddhhmmss);
        // 空格前是日期，空格后是时间
        String finalDate = interviewDateStr.split(" ")[0];
        String finalTime = interviewTimeStr.split(" ")[1];
        String finalInterviewTimeStr = finalDate + " " + finalTime;
        Date finalInterviewTime = StringUtils.parseString2Date(finalInterviewTimeStr, DateTemplate.yyyyMMddhhmmss);
        a.setInterviewTime(finalInterviewTime);
        // 将状态更新为 面试邀请中状态
        a.setState(ApplicationStateEnum.INTERVIEW_INVITING.getState());
        applicationMapper.updateByPrimaryKeySelective(a);
    }
}
