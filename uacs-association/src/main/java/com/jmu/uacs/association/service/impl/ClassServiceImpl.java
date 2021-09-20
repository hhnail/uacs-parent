package com.jmu.uacs.association.service.impl;

import com.jmu.uacs.association.bean.*;
import com.jmu.uacs.association.bean.Class;
import com.jmu.uacs.association.mapper.ClassMapper;
import com.jmu.uacs.association.mapper.CollegeMapper;
import com.jmu.uacs.association.mapper.MajorMapper;
import com.jmu.uacs.association.service.ClassService;
import com.jmu.uacs.vo.response.CascaderClassVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    CollegeMapper collegeMapper;

    @Autowired
    MajorMapper majorMapper;

    @Autowired
    ClassMapper classMapper;

    @Override
    public List<CascaderClassVo> getCascaderClass() {
        List<CascaderClassVo> cascaderClassList = new ArrayList<>();
        // 尝试一条sql解决
        // cascaderClassList = classMapper.getCascaderClass();

        // 先用MBG的API
        // 封装College
        // 1.一级节点-学院
        //
        List<College> collegeDOList = collegeMapper.selectByExample(null);
        for (College collegeItem : collegeDOList) {
            CascaderClassVo ccv = new CascaderClassVo();//准备将DO转化为VO
            Integer collegeId = collegeItem.getCollegeId();
            String collegeName = collegeItem.getCollegeName();
            ccv.setValue(collegeId + "");//数据拷贝-id作为value
            ccv.setLable(collegeName);//数据拷贝-name作为lable
            // 2.二级节点-专业
            MajorExample majorExample = new MajorExample();
            majorExample.createCriteria().andCollegeIdEqualTo(collegeId);
            List<Major> majorDOList = majorMapper.selectByExample(majorExample);
            List<CascaderClassVo> majorCcvList = new ArrayList<>();//用来装ClassVO
            for (Major majorItem : majorDOList) {
                CascaderClassVo majorCcv = new CascaderClassVo();//准备将DO转化为VO
                Integer majorId = majorItem.getMajorId();
                String majorName = majorItem.getMajorName();
                majorCcv.setValue(majorId + "");//数据拷贝-id作为value
                majorCcv.setLable(majorName);//数据拷贝-name作为lable

                // 3.三级节点-班级
                ClassExample classExample = new ClassExample();
                classExample.createCriteria().andMajorIdEqualTo(majorId);
                List<Class> classDOList = classMapper.selectByExample(classExample);
                List<CascaderClassVo> classCcvList = new ArrayList<>();//用来装ClassVO
                for (Class classItem : classDOList) {
                    CascaderClassVo classCco = new CascaderClassVo();
                    Integer classId = classItem.getClassId();
                    String className = classItem.getClassName();
                    classCco.setValue(classId + "");
                    classCco.setLable(className);
                    classCcvList.add(classCco);
                }
                majorCcv.setCcvList(classCcvList);
                majorCcvList.add(majorCcv);
            }
            ccv.setCcvList(majorCcvList);
            cascaderClassList.add(ccv);
        }
        return cascaderClassList;
    }
}
