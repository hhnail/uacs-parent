package com.jmu.uacs.association.service;

import com.jmu.uacs.vo.request.DepartmentReqVO;

public interface DepartmentService {

    void deleteDepartment(Integer departmentId);

    void addDepartment(DepartmentReqVO addVO);
}
