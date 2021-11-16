package com.jmu.uacs.association.bean;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class Association {
    private Integer associationId;

    private String associationName;

    private String adminUnit;

    private Date requestTime;

    private Date createTime;

    private String type;

    private String state;

    private String info;

    private String imgUrl;

}