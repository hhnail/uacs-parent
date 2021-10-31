package com.jmu.uacs.bulletin.bean;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Share {
    private Integer shareId;

    private String title;

    private Date shareTime;

    private String shortDescription;

    private String state;

    private Integer view;

    private Integer thumbs;

    private String refuseReason;

    private Integer associationId;

    private String userId;

    private Integer isDel;

    private byte[] shareContent;


}