package com.jmu.uacs.vo.response;


import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class CascaderClassVo implements Serializable {

    private String value;

    private String lable;

    private List<CascaderClassVo> ccvList;

}
