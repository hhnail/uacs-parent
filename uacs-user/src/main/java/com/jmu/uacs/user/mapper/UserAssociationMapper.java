package com.jmu.uacs.user.mapper;

import com.jmu.uacs.user.bean.UserAssociation;
import com.jmu.uacs.user.bean.UserAssociationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAssociationMapper {
    long countByExample(UserAssociationExample example);

    int deleteByExample(UserAssociationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserAssociation record);

    int insertSelective(UserAssociation record);

    List<UserAssociation> selectByExample(UserAssociationExample example);

    UserAssociation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserAssociation record, @Param("example") UserAssociationExample example);

    int updateByExample(@Param("record") UserAssociation record, @Param("example") UserAssociationExample example);

    int updateByPrimaryKeySelective(UserAssociation record);

    int updateByPrimaryKey(UserAssociation record);
}