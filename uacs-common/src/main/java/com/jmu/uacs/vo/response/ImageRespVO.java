package com.jmu.uacs.vo.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ImageRespVO {

    private String uid;

    private String name;

    private String status;

    private String url;

    private String imageId;
}
