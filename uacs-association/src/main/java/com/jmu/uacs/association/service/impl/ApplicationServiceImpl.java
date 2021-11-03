package com.jmu.uacs.association.service.impl;

import com.jmu.uacs.association.bean.Application;
import com.jmu.uacs.association.mapper.ApplicationMapper;
import com.jmu.uacs.association.service.ApplicationService;
import com.jmu.uacs.vo.request.ApplicationRequestVo;
import com.jmu.uacs.vo.response.ApplicationResponseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    ApplicationMapper applicationMapper;

    @Override
    public void saveApplication(ApplicationRequestVo vo) {
        Application application = new Application();
        BeanUtils.copyProperties(vo,application);
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
}
