package com.jmu.uacs.vo.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AddShareRequestVO {

    private String title;

    private String state;

    private Integer view;

    private String refuseReason;

    private String shareContent;

    private Integer associationId;

    private String userId;

}
