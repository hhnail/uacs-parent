package com.jmu.uacs.vo.response;

import com.jmu.uacs.bean.Department;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ToString
@Data
public class AssoicationResponseVo implements Serializable {

    private Integer associationId;

    private String associationName;

    private String adminUnit;

    private String requestTime;

    private String createTime;

    private String state;

    private String info;

    private String imgUrl;

    private List<Department> departments = new ArrayList<Department>();
}
