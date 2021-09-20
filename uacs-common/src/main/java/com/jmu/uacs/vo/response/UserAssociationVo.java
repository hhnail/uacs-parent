package com.jmu.uacs.vo.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class UserAssociationVo implements Serializable {

    private Integer associationId;

    private String associationName;

    private String adminUnit;

    private String info;

}
