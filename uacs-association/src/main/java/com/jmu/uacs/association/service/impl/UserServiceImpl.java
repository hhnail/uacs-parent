package com.jmu.uacs.association.service.impl;

import com.jmu.uacs.association.bean.*;
import com.jmu.uacs.association.mapper.*;
import com.jmu.uacs.association.service.AssociationService;
import com.jmu.uacs.association.service.RoleService;
import com.jmu.uacs.association.service.TreeNodeService;
import com.jmu.uacs.association.service.UserService;
import com.jmu.uacs.enums.GenderEnum;
import com.jmu.uacs.enums.RoleTypeEnum;
import com.jmu.uacs.util.MyCollectionUtils;
import com.jmu.uacs.util.StringUtils;
import com.jmu.uacs.vo.request.UserAddReqVo;
import com.jmu.uacs.vo.response.RoleRespVo;
import com.jmu.uacs.vo.response.UserManageVo;
import com.jmu.uacs.vo.response.UserResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    UserAssociationMapper userAssociationMapper;
    @Autowired
    AssociationMapper associationMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    TreeNodeService treeNodeService;
    @Autowired
    RoleService roleService;
    @Autowired
    AssociationService associationService;

    @Override
    public List<UserManageVo> getAllUsers() {
        // 准备返回的VO集合
        List<UserManageVo> allUsersVoList = new ArrayList<>();

        List<User> userDoList = userMapper.selectByExample(null);
        for (User userDo : userDoList) {
            UserManageVo userRespVo = new UserManageVo();
            BeanUtils.copyProperties(userDo, userRespVo);

            // 获取（没有set权限列表的）角色列表 并 set到VO中
            List<RoleRespVo> roleListByUserId = roleService.getRoleListByUserId(userDo.getUserId());
            userRespVo.setRoleList(roleListByUserId);

            allUsersVoList.add(userRespVo);
        }
        return allUsersVoList;
    }

    @Override
    @Transactional // 该方法开启事务
    public Integer addUser(UserAddReqVo userAddReqVo) {
        // user信息
        User user = new User();
        BeanUtils.copyProperties(userAddReqVo, user);
        user.setCanDel(1); // 默认可编辑
        user.setState("OPEN"); // 默认开启状态
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode("123456")); // 默认初始密码123456，在数据库中加密存储
        int affectedRowNum2TUser = userMapper.insert(user);

        // user_association信息
        List<Association> associations = new ArrayList<>();
        int affectedRowNum2TUserAssociation = 0;
        if (!StringUtils.isEmpty(userAddReqVo.getAssociationName())) {
            UserAssociation userAssociation = new UserAssociation();
            AssociationExample associationExp = new AssociationExample();
            associationExp.createCriteria().andAssociationNameEqualTo(userAddReqVo.getAssociationName());
            associations = associationMapper.selectByExample(associationExp);// 根据社团name获取社团id
            userAssociation.setAssociationId(associations.get(0).getAssociationId());
            userAssociation.setUserId(userAddReqVo.getUserId());
            affectedRowNum2TUserAssociation = userAssociationMapper.insert(userAssociation);
        }

        // user_role信息
        UserRole userRole = new UserRole();
        userRole.setUserId(userAddReqVo.getUserId()); //id
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andRoleNameEqualTo(userAddReqVo.getRoleName());// 根据角色name获取角色id
        List<Role> roles = roleMapper.selectByExample(roleExample);
        // 超级管理员 没有所属社团 社团id默认为-1
        if (MyCollectionUtils.hasOneEle(associations)) {
            userRole.setAssociationId(associations.get(0).getAssociationId());
        } else {
            userRole.setAssociationId(-1);
        }
        userRole.setRoleId(roles.get(0).getRoleId());
        userRole.setUserId(userAddReqVo.getUserId());
        int affectedRowNum2TUserRole = userRoleMapper.insert(userRole);

        return affectedRowNum2TUser + affectedRowNum2TUserAssociation + affectedRowNum2TUserRole;
    }

    @Override
    public UserManageVo getUserById(String userId) {
        UserManageVo userVo = new UserManageVo();

        // 查询user基本信息
        UserExample userExp = new UserExample();
        userExp.createCriteria().andUserIdEqualTo(userId);
        List<User> users = userMapper.selectByExample(userExp);
        User user = users.get(0);
        BeanUtils.copyProperties(user, userVo);

        // set角色列表
        List<RoleRespVo> roleListByUserId = roleMapper.getRoleListByUserId(user.getUserId(), 0);
        userVo.setRoleList(roleListByUserId);

        // 班级信息
        if (user.getTreeId() != null) {
            CascaderClass cascaderClass = treeNodeService.getClass4Cascader(user.getTreeId());
            userVo.setCollegeMajorClass(cascaderClass.toString());
        }
        return userVo;
    }


    public User getDBUserByUserId(String userId) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(userId);
        List<User> users = userMapper.selectByExample(userExample);
        if (MyCollectionUtils.hasOneEle(users)) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public int deleteUserById(String userId) {
//        暂时不做软删除
//        User dbUserByUserId = getDBUserByUserId(userId);
//        dbUserByUserId.set
        UserExample userExp = new UserExample();
        userExp.createCriteria().andUserIdEqualTo(userId);
//        userMapper.updateByExampleSelective(dbUserByUserId,userExp)
        int affectedRowNum = userMapper.deleteByExample(userExp);
        return affectedRowNum;
    }

    @Override
    public List<UserResponseVo> getUserByAssociationId(Integer associationId) {
        List<UserResponseVo> users = userMapper.getUserByAssociationId(associationId);
        return users;
    }

    @Override
    @Transactional
    public void batchImportUser(List<UserAddReqVo> users) {
        HashMap<String, Integer> nameIdmap = associationService.getNameIdMap();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        for (UserAddReqVo addUserVO : users) {
            // 社团可选。默认-1，没有社团
            if (addUserVO.getAssociationName() == null) {
                addUserVO.setAssociationId(-1);
            } else {
                Integer associationId = nameIdmap.get(addUserVO.getAssociationName());
                addUserVO.setAssociationId(associationId);
            }
            // 角色可选。默认普通学生
            if (addUserVO.getRoleName() == null) {
                addUserVO.setRoleId(4);
            } else {
                Integer roleId = RoleTypeEnum.getCodeByName(addUserVO.getRoleName());
                addUserVO.setRoleId(roleId);
            }
            // 密码默认123456。并进行加密
            if (addUserVO.getPassword() == null) {
                addUserVO.setPassword(encoder.encode("123456"));
            } else {
                addUserVO.setPassword(encoder.encode(addUserVO.getPassword()));
            }
            // 性别格式化。出错则为 未知
            if (addUserVO.getGender() != null) {
                addUserVO.setGender(GenderEnum.getGender(addUserVO.getGender()));
            }
        }
        // 批量insert User
        userMapper.batchImportUser(users);
        // 批量insert User_Role


    }
}
