package com.jmu.uacs.vo.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TreeNodeReqVO {

    private String label;

    private String type;

//    private Integer pId; 生成出来的接口是pid！！ 小写的i！！
    private int pId;

    private String description;

}
