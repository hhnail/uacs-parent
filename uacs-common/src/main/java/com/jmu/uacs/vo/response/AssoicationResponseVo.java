package com.jmu.uacs.vo.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

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
}
