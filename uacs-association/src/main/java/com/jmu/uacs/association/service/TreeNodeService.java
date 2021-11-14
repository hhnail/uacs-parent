package com.jmu.uacs.association.service;

import com.jmu.uacs.association.bean.TreeNode;
import com.jmu.uacs.vo.request.TreeNodeReqVO;

import java.util.List;

public interface TreeNodeService {
    List<TreeNode> getInterviewAddress();

    List<TreeNode> getClassTree();

    void addTreeNode(TreeNodeReqVO reqVO);

    void deleteTreeNode(Integer treeId);
}
