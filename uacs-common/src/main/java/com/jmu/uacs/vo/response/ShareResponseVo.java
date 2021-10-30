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

    private String state;

    private Integer view;

    private String refuseReason;

    private Integer isDel;

    private String shareContent;

    private Integer associationId;
    private String associationName;
    private String userId;
    private String name;
}
