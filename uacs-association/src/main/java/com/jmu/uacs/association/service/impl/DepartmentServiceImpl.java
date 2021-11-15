package com.jmu.uacs.association.service.impl;

import com.jmu.uacs.association.bean.Department;
import com.jmu.uacs.association.mapper.DepartmentMapper;
import com.jmu.uacs.association.service.DepartmentService;
import com.jmu.uacs.vo.request.DepartmentReqVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public void deleteDepartment(Integer departmentId) {
        departmentMapper.deleteByPrimaryKey(departmentId);
    }

    @Override
    public void addDepartment(DepartmentReqVO addVO) {
        Department department = new Department();
        BeanUtils.copyProperties(addVO, department);
        departmentMapper.insert(department);
    }
}
