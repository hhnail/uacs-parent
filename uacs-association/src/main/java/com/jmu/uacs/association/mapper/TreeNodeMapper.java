package com.jmu.uacs.association.mapper;

import com.jmu.uacs.association.bean.TreeNode;
import com.jmu.uacs.association.bean.TreeNodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TreeNodeMapper {
    long countByExample(TreeNodeExample example);

    int deleteByExample(TreeNodeExample example);

    int deleteByPrimaryKey(Integer treeId);

    int insert(TreeNode record);

    int insertSelective(TreeNode record);

    List<TreeNode> selectByExample(TreeNodeExample example);

    TreeNode selectByPrimaryKey(Integer treeId);

    int updateByExampleSelective(@Param("record") TreeNode record, @Param("example") TreeNodeExample example);

    int updateByExample(@Param("record") TreeNode record, @Param("example") TreeNodeExample example);

    int updateByPrimaryKeySelective(TreeNode record);

    int updateByPrimaryKey(TreeNode record);
}