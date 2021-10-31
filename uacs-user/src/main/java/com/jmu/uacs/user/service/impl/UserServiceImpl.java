package com.jmu.uacs.user.service.impl;

import com.jmu.uacs.user.bean.Class;
import com.jmu.uacs.user.bean.User;
import com.jmu.uacs.user.bean.UserExample;
import com.jmu.uacs.user.enums.UserExceptionEnum;
import com.jmu.uacs.user.enums.UserStateEnum;
import com.jmu.uacs.user.exception.UserException;
import com.jmu.uacs.user.feign.AssociationServiceFeign;
import com.jmu.uacs.user.mapper.ClassMapper;
import com.jmu.uacs.user.mapper.PermissionMapper;
import com.jmu.uacs.user.mapper.UserAssociationMapper;
import com.jmu.uacs.user.mapper.UserMapper;
import com.jmu.uacs.user.service.UserService;
import com.jmu.uacs.util.MyCollectionUtils;
import com.jmu.uacs.util.MyDateUtil;
import com.jmu.uacs.util.StringUtils;
import com.jmu.uacs.vo.request.UserInfoReqVo;
import com.jmu.uacs.vo.request.UserRegistVo;
import com.jmu.uacs.vo.request.UserSettingsUpdateReqVO;
import com.jmu.uacs.vo.response.AppResponse;
import com.jmu.uacs.vo.response.UserInfoVo;
import com.jmu.uacs.vo.response.UserManageVo;
import com.jmu.uacs.vo.response.UserResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@Transactional(readOnly = true) // 整个类的数据库操作——只读
public class UserServiceImpl implements UserService {

    // ============= 本模块接口 ============
    @Autowired
    UserMapper userMapper;

    @Autowired
    ClassMapper classMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Autowired
    UserAssociationMapper userAssociationMapper;


    // ============= 远程服务接口 ============
    @Autowired
    AssociationServiceFeign associationServiceFeign;


    // ============= 其他接口（redis中间件） ============
    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Override
    public User getUserById(String userId) {
        UserExample uExp = new UserExample();
        uExp.createCriteria().andUserIdEqualTo(userId);
        return userMapper.selectByExample(uExp).get(0);
    }


    /**
     * 用户注册时，保存用户信息
     *
     * @param vo 表单requestVo
     * @return 受影响的行数，正常应该是1
     * 保存
     * 因为类上加了@Transactional(readOnly = true) // 整个类的数据库操作——只读
     * 但该方法需要数据库新增，不能只读，所以单独设置
     * propagation：传播行为
     * isolation：隔离级别
     * rollbackFor：回滚策略
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = RuntimeException.class)
    @Override
    public int saveUser(UserRegistVo vo) {


        try {
            log.debug("后端服务-serviceImpl-注册，接收用户信息={}", vo);
            //VO 对拷 DO对象中 对拷的字段属性是区分大小写的 VO里的userId对应DO中的userid
            User user = new User();
            BeanUtils.copyProperties(vo, user);
            // 初次注册默认姓名=学号
            user.setName(vo.getUserId());
            // 加密密码
            String password = vo.getPassword();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(password));
            // 返回值是受影响的行数。正常插入应该
            log.debug("后端服务-serviceImpl-注册，实际插入用户信息={}", user);
            int changeNum = userMapper.insertSelective(user);

            log.debug("用户保存成功-{}", user.getUserId());

            return changeNum;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("用户保存失败-{}", e.getMessage());
            throw new UserException(UserExceptionEnum.USER_SAVE_ERROR);
        }
    }

    /**
     * 用户登录，进行各种校验
     *
     * @param userId   学号
     * @param password 密码
     * @return
     */
    @Override
    public UserResponseVo login(String userId, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<User> list = userMapper.selectByExample(example);

        if (!MyCollectionUtils.hasOneEle(list)) {
            throw new UserException(UserExceptionEnum.USER_UNEXIST);
        }
        User dbUser = list.get(0);

        // 如果该用户状态为CLOSE
        if (UserStateEnum.CLOSE.getState().equals(dbUser.getState())) {
            throw new UserException(UserExceptionEnum.USER_CLOSE);
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // 密码验证。encoder每次加密的结果不一样，需要调用match
        if (!encoder.matches(password, dbUser.getPassword())) {
            throw new UserException(UserExceptionEnum.USER_PASSWORD_ERROR);
        }

        log.debug("DO-dbUser in Service={}", dbUser);

        // 若密码输入正确，赋予accessToken
        // 以UUID作为访问令牌，但是里可能有"-",把"-"去掉
        String accessToken = UUID.randomUUID().toString().replaceAll("-", "");
        UserResponseVo responseVo = new UserResponseVo();

        BeanUtils.copyProperties(dbUser, responseVo);// 对拷

        log.debug("responseVo in Service={}", responseVo);

        responseVo.setUserId(dbUser.getUserId());
        responseVo.setAccessToken(accessToken);// 设置accessToken

        // 将accessToken存储到redis中
        stringRedisTemplate.opsForValue().set(accessToken, dbUser.getUserId().toString(), 2, TimeUnit.HOURS);

        // 转码
        // String name = new String(responseVo.getName().getBytes(""),"UTF-8");
        // responseVo.setName();


        // 查询其所在社团
//        UserAssociationExample uaExp = new UserAssociationExample();
//        uaExp.createCriteria().andUserIdEqualTo(userId);
//        List<UserAssociation> uaRecords = userAssociationMapper.selectByExample(uaExp);

        // 调用远程服务 查询角色列表
        AppResponse<UserManageVo> userResponse = associationServiceFeign.getUserById(userId);
        log.debug("调用远程接口 获取角色列表={}", userResponse.getData().getRoleList());
        responseVo.setRoleList(userResponse.getData().getRoleList());
        return responseVo;
    }

    /**
     * @param accessToken
     * @return
     */
    @Override
    public UserInfoVo getUserInfo(String accessToken) {
        //得到用户信息，拷贝到vo并返回
        User user = getDBUserByToken(accessToken);
        log.debug("==dbUser newField-headUrl={}", user.getHeadUrl());
        UserInfoVo infoVo = new UserInfoVo();
        BeanUtils.copyProperties(user, infoVo);
        infoVo.setAccessToken(accessToken);
        // 格式化生日的日期格式
        Date dateBirthday = user.getBirthday();
        if (dateBirthday != null) {
            infoVo.setBirthday(MyDateUtil.parseToFormatTime(dateBirthday));
        }
        // 获取班级信息
        Class classInfo = classMapper.selectByPrimaryKey(user.getClassId());
        if (classInfo != null) {
            BeanUtils.copyProperties(classInfo, infoVo);
        }
        // 获取权限路径列表
        List<String> pmsList = permissionMapper.getPermissionRoutePathListByUserId(user.getUserId());
        log.debug("权限路径列表={}", pmsList);
        log.debug("权限路径列表={}", pmsList.getClass());
        // set不进去，项目编译不通过，原因？
        infoVo.setPermissionRoutePathList(pmsList);
        return infoVo;
    }

    /**
     * 私有方法！供本类其他方法调用
     * 用accessToken获取数据库中获取DO对象
     * 注意！！ 这个DO只有本类信息和外键，其他相关内容未注入
     * <p>
     * <p>
     * 看网上说service之间最好不用相互调用。但是又有该方法的需求
     * 下面紧接着提供一个方法 getUserIdByToken
     *
     * @param accessToken
     * @return
     */
    private User getDBUserByToken(String accessToken) {
        //1 根据accessToken获取redis中存储的userId
        String userId = getUserIdByToken(accessToken);
        //2 根据userId获取用户信息
        UserExample example = new UserExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<User> userList = userMapper.selectByExample(example);
        //查询得到的用户数量非1，说明有错
        if (MyCollectionUtils.isEmpty(userList)) {
            throw new UserException(UserExceptionEnum.USER_UNEXIST);
        }
        return userList.get(0);
    }

    /**
     * 供controller调用，然后再把token换到的id传给servcie
     * 这样就不用service之间相互调用啦
     * <p>
     * -1表示没拿到用户id。用户id是从1自增的，不可能是-1
     *
     * @return
     */
    @Override
    public String getUserIdByToken(String accessToken) {
        //1 根据accessToken获取redis中存储的userId
        String strUserId = stringRedisTemplate.opsForValue().get(accessToken);
        if (StringUtils.isEmpty(strUserId)) {
            throw new UserException(UserExceptionEnum.USER_TOKEN_INVALID);
        }
        return strUserId;
    }

    /**
     * 更新用户个人信息
     * 其中accessToken封装在requestVo中了，验证用户从vo里面取出来
     *
     * @param vo requestVo
     * @return 改变条数
     */
    @Transactional
    @Override
    public int updateUserInfo(UserInfoReqVo vo) {
        String accessToken = vo.getAccessToken();
        log.debug("==when updateUserInfo get accessToken{}", accessToken);
        User dbUser = getDBUserByToken(accessToken);
        BeanUtils.copyProperties(vo, dbUser);
        log.debug("==3== new dbUser");
        return userMapper.updateByPrimaryKey(dbUser);
    }

    @Override
    public List<UserInfoVo> getUserList(List<String> userIdList) {
        //写法1：用逆向工程的or
        UserExample example = new UserExample();
        for (String userId : userIdList) {
            UserExample.Criteria userCriteria = example.createCriteria();
            userCriteria.andUserIdEqualTo(userId);
            example.or(userCriteria);
        }
        UserInfoVo vo = new UserInfoVo();
        List<UserInfoVo> voList = new ArrayList<>();
        List<User> userList = userMapper.selectByExample(example);
        for (User user : userList) {
            BeanUtils.copyProperties(user, vo);
            voList.add(vo);
        }
        return voList;
        //写法2：自己写sql，把userId拼接到条件里
        //写法3：遍历userIdList，依次获取user信息
    }

    @Transactional
    @Override
    public void reset(UserSettingsUpdateReqVO reqVO) {
        // 仅更新非空的内容
        User user = new User();
        BeanUtils.copyProperties(reqVO, user);

        // 根据UserId更新
        UserExample uExp = new UserExample();
        uExp.createCriteria().andUserIdEqualTo(user.getUserId());

        userMapper.updateByExampleSelective(user, uExp);
    }
}
