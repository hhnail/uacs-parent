package com.jmu.uacs.association.service.impl;

import com.jmu.uacs.association.bean.Application;
import com.jmu.uacs.association.bean.ApplicationExample;
import com.jmu.uacs.association.mapper.ApplicationMapper;
import com.jmu.uacs.association.service.ApplicationService;
import com.jmu.uacs.enums.ApplicationStateEnum;
import com.jmu.uacs.vo.request.ApplicationRequestVo;
import com.jmu.uacs.vo.response.ApplicationResponseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    ApplicationMapper applicationMapper;

    @Override
    public void saveApplication(ApplicationRequestVo vo) {
        Application application = new Application();
        BeanUtils.copyProperties(vo,application);
        application.setApplicationTime(new Date());
        application.setState(ApplicationStateEnum.APPLYING.toString());
        applicationMapper.insertSelective(application);
    }

    @Override
    public List<ApplicationResponseVO> getApplicationList(Integer[] associationIds) {
        List<ApplicationResponseVO> resList= applicationMapper.getApplicationList(associationIds);
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
    public void updateApplicationState(Integer applicationId, String state) {
        Application application = new Application();
        application.setApplicationId(applicationId);
        application.setState(state);
        applicationMapper.updateByPrimaryKeySelective(application);
    }
}
