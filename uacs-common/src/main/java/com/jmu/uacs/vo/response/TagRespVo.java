package com.jmu.uacs.vo.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;


@ToString
@Data
public class TagRespVo implements Serializable {

    private Integer tagId;

    private String tagName;

    private Integer pId;

}
