package com.jmu.uacs.association.service.impl;

import com.jmu.uacs.association.bean.*;
import com.jmu.uacs.association.mapper.*;
import com.jmu.uacs.association.service.AssociationService;
import com.jmu.uacs.enums.AssociationStateEnum;
import com.jmu.uacs.enums.ImageTypeEnum;
import com.jmu.uacs.enums.RoleTypeEnum;
import com.jmu.uacs.enums.TreeNodeEnum;
import com.jmu.uacs.util.MyCollectionUtils;
import com.jmu.uacs.vo.request.AssociationRequestVo;
import com.jmu.uacs.vo.response.AssoicationResponseVo;
import com.jmu.uacs.vo.response.UserAssociationVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Service
public class AssociationServiceImpl implements AssociationService {

    @Autowired
    AssociationMapper associationMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    ImageMapper imageMapper;
    @Autowired
    TreeNodeMapper treeNodeMapper;

    @Override
    public List<AssoicationResponseVo> getAllAssociationList() {
        //获取数据库中所有社团信息
        List<Association> list = associationMapper.selectByExample(null);

        log.debug("==8 ServiceImpl association-list{}", list);

        //供保存社团信息的responseList
        List<AssoicationResponseVo> respList = new ArrayList<AssoicationResponseVo>();
        for (Association association : list) {
            //返回的vo
            AssoicationResponseVo respVo = new AssoicationResponseVo();
            //将do拷贝到vo中
            BeanUtils.copyProperties(association, respVo);
            //格式化日期
            Date dateCreateTime = association.getCreateTime();
            Integer intStateCode = -1;
            try {
                intStateCode = Integer.parseInt(association.getState());
            } catch (NumberFormatException e) {
                log.error("数据格式转换异常={}", e.getMessage());
            }

            log.debug("==11 后台社团模块-ServiceImpl 获取社团状态码={}", intStateCode);

//            if (dateCreateTime != null) {
//                //非空则格式化
//                respVo.setCreateTime(MyDateUtil.parseToFormatTime(dateCreateTime));
//            } else {
//                //为空则使用当前时间
//                respVo.setCreateTime(MyDateUtil.parseToFormatTime(new Date()));
//            }
            // 文字化社团状态 ”1“代表社团审核通过
            if (intStateCode == AssociationStateEnum.APPROVED.getCode()) {
                respVo.setState(AssociationStateEnum.APPROVED.getState());
            } else if (intStateCode == AssociationStateEnum.APPROVING.getCode()) {
                respVo.setState(AssociationStateEnum.APPROVING.getState());
            } else if (intStateCode == AssociationStateEnum.APPROVE_FAIL.getCode()) {
                respVo.setState(AssociationStateEnum.APPROVE_FAIL.getState());
            } else if (intStateCode == AssociationStateEnum.LOCKED.getCode()) {
                respVo.setState(AssociationStateEnum.LOCKED.getState());
            }
            log.debug("==12 后台社团模块-ServiceImpl 获取社团状态字符串={}", respVo.getState());

            ImageExample exp = new ImageExample();
            exp.createCriteria().andOwnerIdEqualTo(association.getAssociationId() + "").andTypeEqualTo(ImageTypeEnum.ASSOCIATION_HOMEPAGE.getValue());
            List<Image> images = imageMapper.selectByExample(exp);
            if (!MyCollectionUtils.isEmpty(images)) {
                respVo.setImgUrl(images.get(0).getUrl());
            }

            respList.add(respVo);


        }
        log.debug("==8 后台服务-返回社团list{}", respList);
        return respList;
    }

    @Override
    @Transactional
    public void saveAssociation(AssociationRequestVo vo) {
        // 1 保存社团信息
        Association association = new Association();
        BeanUtils.copyProperties(vo, association);
        association.setCreateTime(new Date());
        association.setState(AssociationStateEnum.APPROVED.getCode() + "");
        log.debug("==17 后台服务-创建社团 DO={}", association);
        associationMapper.insertSelective(association);


        // 保存管理员信息
        log.debug("==17 后台服务-创建社团 自增主键={}", association.getAssociationId());
        UserRole userRole = new UserRole();
        userRole.setUserId(vo.getUserId());
        userRole.setAssociationId(association.getAssociationId());
        userRole.setRoleId(RoleTypeEnum.ASSOCIATION_ADMIN.getCode());
        userRole.setDepartmentId(-1);
        userRoleMapper.insertSelective(userRole);

    }

    @Override
    public void updateAssociationState(String associationId, Integer stateCode) {
        log.debug("==20 后台服务-更新社团状态-serviceImpl associationId={}，stateCode={}", associationId, stateCode);
        Association association = new Association();
        try {
            association.setAssociationId(Integer.parseInt(associationId));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            log.error("数据类型转换异常,msg={}", e.getMessage());
        }
        association.setState(stateCode + "");
        associationMapper.updateByPrimaryKey(association);
    }

    @Override
    public List<String> getAssociationAdminIdList(Integer associationId) {
        UserRoleExample example = new UserRoleExample();
        //查询对应社团id，且角色为的ASSOCIATION_ADMIN即为对应社团管理员
        example.createCriteria()
                .andRoleIdEqualTo(RoleTypeEnum.ASSOCIATION_ADMIN.getCode())
                .andAssociationIdEqualTo(associationId);
        List<UserRole> user_roleList = userRoleMapper.selectByExample(example);

        List<String> adminIdList = new ArrayList<>();
        for (UserRole user_role : user_roleList) {
            String userId = user_role.getUserId();
            adminIdList.add(userId);
        }

        log.debug("==41 社团服务-service-查询{}社团管理员ID结果={}", associationId, adminIdList);

        return adminIdList;
    }

    @Override
    public List<UserAssociationVo> getAssociationByUserId(String userId, Integer[] roleIds) {


        List<Association> associationDOList = associationMapper.getAssociationByUserId(userId, roleIds);

        List<UserAssociationVo> voList = new ArrayList<>();

        // do 2 vo
        Iterator<Association> iterator = associationDOList.iterator();
        while (iterator.hasNext()) {
            UserAssociationVo vo = new UserAssociationVo();
            BeanUtils.copyProperties(iterator.next(), vo);
            voList.add(vo);
        }
        return voList;
    }

    @Override
    public AssoicationResponseVo getAssociationInfo(Integer associationId) {
        AssoicationResponseVo vo = new AssoicationResponseVo();
        Association associationDO = associationMapper.selectByPrimaryKey(associationId);
        BeanUtils.copyProperties(associationDO, vo);
//        vo.setCreateTime(StringUtils.formatDate2String(associationDO.getCreateTime(), DateTemplate.yyyyMMdd));
//        vo.setRequestTime(StringUtils.formatDate2String(associationDO.getRequestTime(), DateTemplate.yyyyMMdd));

        // 注入社团部门信息
        DepartmentExample dExp = new DepartmentExample();
        dExp.createCriteria().andAssociationIdEqualTo(associationId);
        List<Department> departments = departmentMapper.selectByExample(dExp);
        List<com.jmu.uacs.bean.Department> departmentVOList = new ArrayList<>();
        for (Department d : departments) {
            com.jmu.uacs.bean.Department dVO = new com.jmu.uacs.bean.Department();
            BeanUtils.copyProperties(d, dVO);
            departmentVOList.add(dVO);
        }
        vo.setDepartments(departmentVOList);
        return vo;
    }


    @Override
    public List<AssoicationResponseVo> getAssociationAsMember(String userId) {
        if (userId != null) {
            UserRoleExample exp = new UserRoleExample();
            exp.createCriteria().andUserIdEqualTo(userId);
            List<UserRole> userRoles = userRoleMapper.selectByExample(exp);
            // 如果是超级管理员，则查询所有的社团
            if (MyCollectionUtils.hasOneEle(userRoles) && userRoles.get(0).getRoleId() == RoleTypeEnum.SUPER_ADMIN.getCode()) {
                List<Association> all = associationMapper.selectByExample(null);
                List<AssoicationResponseVo> voList = new ArrayList<>();
                for (Association association : all) {
                    AssoicationResponseVo vo = new AssoicationResponseVo();
                    BeanUtils.copyProperties(association, vo);
                    vo.setRoleId(RoleTypeEnum.SUPER_ADMIN.getCode());
                    vo.setRoleName(RoleTypeEnum.SUPER_ADMIN.getRole());
                    voList.add(vo);
                }
                return voList;
            }
        }


        List<AssoicationResponseVo> res = associationMapper.getAssociationAsMember(userId);
        return res;
    }

    @Override
    public HashMap<String, Integer> getNameIdMap() {
        List<AssoicationResponseVo> all = getAllAssociationList();
        HashMap<String, Integer> map = new HashMap<>();
        for (AssoicationResponseVo vo : all) {
            map.put(vo.getAssociationName(), vo.getAssociationId());
        }
        return map;
    }

    @Override
    public List<TreeNode> getAssociationType() {
        TreeNodeExample exp = new TreeNodeExample();
        exp.createCriteria().andTypeEqualTo(TreeNodeEnum.ASSOCIATION_TYPE.getValue());
        return treeNodeMapper.selectByExample(exp);
    }

    @Override
    public Boolean checkAssociationExist(String associationName) {
        AssociationExample exp = new AssociationExample();
        exp.createCriteria().andAssociationNameEqualTo(associationName).andIsDelEqualTo(0);
        List<Association> associations = associationMapper.selectByExample(exp);
        if (associations.size() > 0) {
            return true;
        }
        return false;
    }
}
