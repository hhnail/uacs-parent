package com.jmu.uacs.association.controller;

import com.jmu.uacs.association.bean.Image;
import com.jmu.uacs.association.service.ImageService;
import com.jmu.uacs.vo.response.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Api(tags = "文件模块")
@RequestMapping("/association") // 父路径
@Controller
public class ImageController {

    @Autowired
    ImageService imageService;

    @ResponseBody
    @ApiOperation(value = "查询图片")
    @PostMapping("/uploadImage")
    AppResponse<String> uploadImage(@RequestBody MultipartFile image) {
        try {
            imageService.saveImage(image);
            AppResponse<String> resp = AppResponse.ok(null);
            resp.setMsg("上传成功！");
            return resp;
        } catch (Exception e) {
            AppResponse<String> fail = AppResponse.fail(null);
            fail.setMsg("上传失败！");
            return fail;
        }
    }

    @ResponseBody
    @ApiOperation(value = "上传图片")
    @GetMapping("/getImageById/{imageId}")
    AppResponse<Image> getImageById(@PathVariable("imageId") Integer imageId) {
        try {
            Image image = imageService.getImageById(imageId);
            AppResponse<Image> resp = AppResponse.ok(image);
            resp.setMsg("操作成功！");
            return resp;
        } catch (Exception e) {
            AppResponse<Image> fail = AppResponse.fail(null);
            fail.setMsg("操作失败！");
            return fail;
        }
    }

}
