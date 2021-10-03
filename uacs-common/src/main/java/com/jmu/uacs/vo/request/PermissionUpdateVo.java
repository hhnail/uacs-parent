package com.jmu.uacs.vo.request;

import com.jmu.uacs.vo.response.PermissionVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApiModel("权限requestVO")
@Data
@ToString
public class PermissionUpdateVo implements Serializable {

    @ApiModelProperty(value="permissionId")
    private Integer permissionId;

    @ApiModelProperty(value="文本内容")
    private String title;

    @ApiModelProperty(value="路由路径（也是元素的key）")
    private String routePath;

    @ApiModelProperty(value="菜单级别")
    private Integer grade;

    @ApiModelProperty(value="权限元素类型")
    private String type;

    @ApiModelProperty(value="父菜单id")
    private Integer pId;

    @ApiModelProperty(value="子菜单列表")
    private List<PermissionVo> children = new ArrayList<PermissionVo>();
}
