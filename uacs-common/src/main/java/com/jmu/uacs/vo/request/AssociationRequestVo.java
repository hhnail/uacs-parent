package com.jmu.uacs.vo.request;

import com.jmu.uacs.enums.AssociationStateEnum;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@ApiModel
public class AssociationRequestVo implements Serializable {

    private String associationName;

    private String adminUnit;

    private String info;

    private String imgUrl;

    //默认创建的时候状态都是 ”审核中“
    private String state = AssociationStateEnum.APPROVING.getCode()+"";
	
}
