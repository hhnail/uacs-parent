package com.jmu.uacs.vo.request;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TreeNodeReqVO {

    private String label;

    private String type;

//    private Integer pId;
    private int pId;

    private String description;

}
