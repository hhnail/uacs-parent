package com.jmu.uacs.association.bean;


import com.google.inject.spi.Toolable;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TreeNode {
    private Integer treeId;

    private String value;

    private String label;

    private String type;

    private Integer level;

    private Integer isLeaf;

    private Integer pId;

    private String description;

}