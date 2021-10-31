package com.jmu.uacs.vo.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel
public class ShareResponseVo {
    private Integer shareId;

    private String title;
    private String shortDescription;
    private String shareContent;

    private String userId;
    private String name;
    private String roleName;
    private String shareTime;

    private String state;
    private String refuseReason;

    private Integer view;
    private Integer thumbs;

    private Integer associationId;
    private String associationName;

}
