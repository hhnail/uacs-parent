package com.jmu.uacs.association.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Application {
    private Integer applicationId;

    private String photoUrl;

    private String intentionDepartmentName;

    private String selfProfile;

    private String joinPurpose;

    private String viewOfAssociation;

    private Integer state;

    private Integer userId;

}