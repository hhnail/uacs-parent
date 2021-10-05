package com.jmu.uacs.vo.response;

import com.jmu.uacs.enums.DateTemplate;
import com.jmu.uacs.util.StringUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class RecruitmentRespVo {

    private Integer recruitmentId;

    private String title;

    private Integer newNum;

    private String description;

    private String content;

    private String state;

    private Date startTime;

    private Date endTime;

    private Date createTime;

    private Date updateTime;

    @ApiModelProperty(value = "浏览量")
    private Integer view;

    private String userId;

    @ApiModelProperty(value = "用户姓名")
    private String name;

    private Integer associationId;

    @ApiModelProperty(value = "社团名称")
    private String associationName;

    public String getStartTime() {
        if (startTime == null) {
            return StringUtils.formatDate2String(new Date(), DateTemplate.yyyyMMdd);
        }
        return StringUtils.formatDate2String(startTime, DateTemplate.yyyyMMdd);
    }

    public String getEndTime() {
        if (endTime == null) {
            return StringUtils.formatDate2String(new Date(), DateTemplate.yyyyMMdd);
        }
        return StringUtils.formatDate2String(endTime, DateTemplate.yyyyMMdd);
    }

    public String getCreateTime() {
        if (createTime == null) {
            return StringUtils.formatDate2String(new Date(), DateTemplate.yyyyMMdd);
        }
        return StringUtils.formatDate2String(createTime, DateTemplate.yyyyMMdd);
    }

    public String getUpdateTime() {
        if (updateTime == null) {
            return StringUtils.formatDate2String(new Date(), DateTemplate.yyyyMMdd);
        }
        return StringUtils.formatDate2String(updateTime, DateTemplate.yyyyMMdd);
    }
}
