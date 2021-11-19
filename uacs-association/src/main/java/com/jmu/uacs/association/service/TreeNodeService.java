package com.jmu.uacs.association.service;

import com.jmu.uacs.association.bean.CascaderClass;
import com.jmu.uacs.association.bean.TreeNode;
import com.jmu.uacs.vo.request.TreeNodeReqVO;

import java.util.List;

public interface TreeNodeService {
    List<TreeNode> getInterviewAddress();

    List<TreeNode> getClassTree();

    void addTreeNode(TreeNodeReqVO reqVO);

    void deleteTreeNode(Integer treeId);

    /**
     * 查询级联班级信息 TreeNode表 type：CLASS
     * @param classId 班级ID
     * @return
     */
    CascaderClass getClass4Cascader(Integer classId);
}
