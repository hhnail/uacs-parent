package com.jmu.uacs.association.mapper;

import com.jmu.uacs.association.bean.User;
import com.jmu.uacs.association.bean.UserExample;
import com.jmu.uacs.vo.request.UserAddReqVo;
import com.jmu.uacs.vo.response.UserResponseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<UserResponseVo> getUserByAssociationId(@Param("associationId") Integer associationId);

    void batchImportUser(@Param("users") List<UserAddReqVo> users);
}