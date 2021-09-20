package com.jmu.uacs.association.service.impl;

import com.jmu.uacs.association.bean.Application;
import com.jmu.uacs.association.mapper.ApplicationMapper;
import com.jmu.uacs.association.service.ApplicationService;
import com.jmu.uacs.vo.request.ApplicationRequestVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
