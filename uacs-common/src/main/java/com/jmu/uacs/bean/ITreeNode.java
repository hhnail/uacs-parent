package com.jmu.uacs.bean;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class ITreeNode {
    private Integer treeId;

    private String value;

    private String label;

    private String type;

    private Integer level;

    private Integer isLeaf;

    private Integer pId;

    private String description;

    private List<ITreeNode> children = new ArrayList<ITreeNode>();

}