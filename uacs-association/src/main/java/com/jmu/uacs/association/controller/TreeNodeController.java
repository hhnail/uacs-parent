package com.jmu.uacs.association.controller;

import com.jmu.uacs.association.bean.TreeNode;
import com.jmu.uacs.association.service.TreeNodeService;
import com.jmu.uacs.bean.ITreeNode;
import com.jmu.uacs.util.TreeNodeUtil;
import com.jmu.uacs.vo.request.TreeNodeReqVO;
import com.jmu.uacs.vo.response.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Api(tags = "社团模块--树结构")
@RequestMapping("/association") // 父路径
@RestController
public class TreeNodeController {

    @Autowired
    TreeNodeService treeNodeService;

    @ApiOperation("查询面试地点")
    @GetMapping("/getInterviewAddress")
    public AppResponse<List<ITreeNode>> getInterviewAddress() {
        try {
            List<TreeNode> tree = treeNodeService.getInterviewAddress();
            List<ITreeNode> iTreeList = new ArrayList<>();
            for (TreeNode treeNode : tree) {
                ITreeNode iTreeNode = new ITreeNode();
                BeanUtils.copyProperties(treeNode, iTreeNode);
                iTreeList.add(iTreeNode);
            }
            List<ITreeNode> cascaderTree = TreeNodeUtil.createCascaderTree(iTreeList);
            AppResponse<List<ITreeNode>> resp = AppResponse.ok(cascaderTree);
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<List<ITreeNode>> fail = AppResponse.fail(null);
            fail.setMsg("树节点获取失败！");
            return fail;
        }
    }


    @ApiOperation("查询专业班级")
    @GetMapping("/getClassTree")
    public AppResponse<List<ITreeNode>> getClassTree() {
        try {
            List<TreeNode> tree = treeNodeService.getClassTree();
            List<ITreeNode> iTreeList = new ArrayList<>();
            for (TreeNode treeNode : tree) {
                ITreeNode iTreeNode = new ITreeNode();
                BeanUtils.copyProperties(treeNode, iTreeNode);
                iTreeList.add(iTreeNode);
            }
            List<ITreeNode> cascaderTree = TreeNodeUtil.createCascaderTree(iTreeList);
            AppResponse<List<ITreeNode>> resp = AppResponse.ok(cascaderTree);
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<List<ITreeNode>> fail = AppResponse.fail(null);
            fail.setMsg("树节点获取失败！");
            return fail;
        }
    }

    @ApiOperation("新增树节点")
    @PostMapping("/addTreeNode")
    public AppResponse<String> addTreeNode(@RequestBody TreeNodeReqVO reqVO) {
        try {
            log.debug("reqVO = {}", reqVO);
            treeNodeService.addTreeNode(reqVO);
            AppResponse<String> resp = AppResponse.ok(null);
            resp.setMsg("操作成功！");
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            AppResponse<String> fail = AppResponse.fail(null);
            fail.setMsg("操作失败！");
            return fail;
        }
    }

}
