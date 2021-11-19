package com.jmu.uacs.association.service.impl;

import com.jmu.uacs.association.bean.CascaderClass;
import com.jmu.uacs.association.bean.TreeNode;
import com.jmu.uacs.association.bean.TreeNodeExample;
import com.jmu.uacs.association.mapper.TreeNodeMapper;
import com.jmu.uacs.association.service.TreeNodeService;
import com.jmu.uacs.enums.TreeNodeEnum;
import com.jmu.uacs.vo.request.TreeNodeReqVO;
import org.springframework.beans.BeanUtils;
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

    @Override
    public List<TreeNode> getClassTree() {
        TreeNodeExample treeNodeExample = new TreeNodeExample();
        treeNodeExample.or().andTypeEqualTo(TreeNodeEnum.COLLEGE.getValue());
        treeNodeExample.or().andTypeEqualTo(TreeNodeEnum.MAJOR.getValue());
        treeNodeExample.or().andTypeEqualTo(TreeNodeEnum.CLASS.getValue());
        return treeNodeMapper.selectByExample(treeNodeExample);
    }

    @Override
    public void addTreeNode(TreeNodeReqVO reqVO) {
        TreeNode treeNode = new TreeNode();
        BeanUtils.copyProperties(reqVO, treeNode);
        treeNode.setValue(reqVO.getLabel());
        // 前端传过来的type是 COLLEGE(的String)
//        switch (reqVO.getType()){
//            case TreeNodeEnum.COLLEGE.getValue():
//        }

        switch (TreeNodeEnum.getEnumByValue(reqVO.getType())){
            case COLLEGE:
                treeNode.setLevel(1);
                treeNode.setIsLeaf(0);
                break;
            case MAJOR:
                treeNode.setLevel(2);
                treeNode.setIsLeaf(0);
                break;
            case CLASS:
                treeNode.setLevel(3);
                treeNode.setIsLeaf(1);
            default:
                break;
        }
        treeNodeMapper.insertSelective(treeNode);
    }

    @Override
    public void deleteTreeNode(Integer treeId) {
        treeNodeMapper.deleteByPrimaryKey(treeId);
    }

    @Override
    public CascaderClass getClass4Cascader(Integer classId) {
        return treeNodeMapper.getClass4Cascader(classId);
    }
}
