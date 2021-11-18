package com.jmu.uacs.association.controller;

import com.jmu.uacs.association.bean.Image;
import com.jmu.uacs.association.service.ImageService;
import com.jmu.uacs.vo.response.AppResponse;
import com.jmu.uacs.vo.response.ImageRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Api(tags = "图片模块")
@RequestMapping("/association") // 父路径
@Controller
public class ImageController {

    @Autowired
    ImageService imageService;

    @ResponseBody
    @ApiOperation(value = "上传图片")
    @PostMapping("/uploadImage/{type}/{ownerId}")
    AppResponse<ImageRespVO> uploadImage(
            @PathVariable("type") String type,
            @PathVariable("ownerId") String ownerId,
            @RequestBody MultipartFile image) {
        try {
            ImageRespVO respVO = imageService.saveImage(image, type, ownerId);
            AppResponse<ImageRespVO> resp = AppResponse.ok(respVO);
            resp.setMsg("上传成功！");
            return resp;
        } catch (Exception e) {
            AppResponse<ImageRespVO> fail = AppResponse.fail(null);
            fail.setMsg("上传失败！");
            return fail;
        }
    }

    /**
     * 通过类似链接 http://localhost:7100/association/getImageById/67a65ebb55db46e29b5bd18c917e9f8e
     * 在浏览器以下标签/组件中就能访问图片
     * <img src=”xxx“/>
     * <Avatar src="xxx></Avatar>
     * <p>
     * 这个接口可不要随便动。数据库里的url都是依赖他的
     */
    @ResponseBody
    @ApiOperation(value = "查询图片")
    @GetMapping("/getImageById/{imageId}")
    byte[] getImageById(@PathVariable("imageId") String imageId) {
        try {
            Image image = imageService.getImageById(imageId);
            byte[] data = image.getData();
            return data;
        } catch (Exception e) {
            byte[] failData = new byte[1];
            AppResponse<byte[]> fail = AppResponse.fail(null);
            fail.setMsg("操作失败！");
            return failData;
        }
    }


    @ResponseBody
    @ApiOperation(value = "查询图片链接")
    @GetMapping("/getAssociationImageUrl/{type}/{ownerId}")
    AppResponse<List<ImageRespVO>> getAssociationImageUrl(
            @PathVariable("type") String type,
            @PathVariable("ownerId") String ownerId
    ) {
        try {
            List<ImageRespVO> respVOs = imageService.getAssociationImageUrl(ownerId, type);
            AppResponse<List<ImageRespVO>> resp = AppResponse.ok(respVOs);
            resp.setMsg("查询成功！");
            return resp;
        } catch (Exception e) {
            AppResponse<List<ImageRespVO>> fail = AppResponse.fail(null);
            fail.setMsg("查询失败！");
            return fail;
        }

    }

    @ResponseBody
    @ApiOperation(value = "删除图片")
    @DeleteMapping("/deleteImage/{imageId}")
    AppResponse<String> deleteImage(@PathVariable("imageId") String imageId) {
        try {
            imageService.deleteImage(imageId);
            AppResponse<String> resp = AppResponse.ok(null);
            resp.setMsg("删除成功！");
            return resp;
        } catch (Exception e) {
            AppResponse<String> fail = AppResponse.fail(null);
            fail.setMsg("删除失败！");
            return fail;
        }
    }
}
