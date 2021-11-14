package com.jmu.uacs.association.service.impl;

import com.jmu.uacs.association.bean.TreeNode;
import com.jmu.uacs.association.bean.TreeNodeExample;
import com.jmu.uacs.association.mapper.TreeNodeMapper;
import com.jmu.uacs.association.service.TreeNodeService;
import com.jmu.uacs.enums.TreeNodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeNodeServiceImpl implements TreeNodeService {

    @Autowired
    TreeNodeMapper treeNodeMapper;

    @Override
    public List<TreeNode> getInterviewAddress() {
        TreeNodeExample treeNodeExample = new TreeNodeExample();

        treeNodeExample.or().andTypeEqualTo(TreeNodeEnum.CAMPUS.getValue());
        treeNodeExample.or().andTypeEqualTo(TreeNodeEnum.BUILDING.getValue());
        treeNodeExample.or().andTypeEqualTo(TreeNodeEnum.CLASSROOM.getValue());


        return treeNodeMapper.selectByExample(treeNodeExample);
    }
}
