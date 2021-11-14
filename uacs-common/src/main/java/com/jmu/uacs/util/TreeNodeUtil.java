package com.jmu.uacs.util;

import com.jmu.uacs.bean.ITreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 树形结构工具类
 */
public class TreeNodeUtil {

    /**
     * 将List转化为Antd Cascader组件所需结构
     *
     * @param source 树节点。各节点处在同一平面内的List
     * @return Tree形结构
     */
    public static List<ITreeNode> createCascaderTree(List<ITreeNode> source) {
        List<ITreeNode> target = new ArrayList<ITreeNode>();
        for (ITreeNode treeNode : source) {
            if (treeNode.getLevel() == 1) {
                for (ITreeNode node2 : source) {
                    if ((node2.getLevel() == 2) && (node2.getPId() == treeNode.getTreeId())) {
                        for (ITreeNode node3 : source) {
                            if ((node3.getLevel() == 3) && (node3.getPId() == node2.getTreeId())) {
                                node2.getChildren().add(node3);
                            }
                        }
                        treeNode.getChildren().add(node2);
                    }
                }
                target.add(treeNode);
            }
        }
        return target;
    }
}
