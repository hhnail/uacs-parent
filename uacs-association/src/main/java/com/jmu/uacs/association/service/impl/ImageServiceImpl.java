package com.jmu.uacs.association.service.impl;

import com.jmu.uacs.association.bean.Image;
import com.jmu.uacs.association.bean.ImageExample;
import com.jmu.uacs.association.mapper.ImageMapper;
import com.jmu.uacs.association.service.ImageService;
import com.jmu.uacs.enums.ImageTypeEnum;
import com.jmu.uacs.vo.response.ImageRespVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageMapper imageMapper;

    @Override
    public ImageRespVO saveImage(MultipartFile image, String type, String ownerId) throws IOException {
        String imageId = UUID.randomUUID().toString().replaceAll("-", "");
        String url = "http://localhost:7100/association/getImageById/" + imageId;
        // 封装save的Record
        Image record = new Image();
        record.setData(image.getBytes());
        record.setUrl(url);
        record.setImageId(imageId);
        record.setImageName(image.getOriginalFilename());
        record.setOwnerId(ownerId);
        ImageTypeEnum enumByValue = ImageTypeEnum.getEnumByValue(type);
        switch (enumByValue) {
            case USER_AVATAR:
                record.setType(ImageTypeEnum.USER_AVATAR.getValue());
                break;
            case USER_PHOTO_ALBUM:
                record.setType(ImageTypeEnum.USER_PHOTO_ALBUM.getValue());
                break;
            case ASSOCIATION_HOMEPAGE:
                record.setType(ImageTypeEnum.ASSOCIATION_HOMEPAGE.getValue());
                break;
            case ASSOCIATION_PHOTO_ALBUM:
                record.setType(ImageTypeEnum.ASSOCIATION_PHOTO_ALBUM.getValue());
                break;
        }
        imageMapper.insert(record);


        // 封装返回VO
        ImageRespVO vo = new ImageRespVO();
        vo.setName(image.getOriginalFilename());
        vo.setStatus("done");
        vo.setUrl(url);
        return vo;
    }

    @Override
    public Image getImageById(String imageId) {
        ImageExample imageExample = new ImageExample();
        imageExample.createCriteria().andImageIdEqualTo(imageId);
        Image image = imageMapper.selectByExampleWithBLOBs(imageExample).get(0);
        return image;
    }

    @Override
    public List<ImageRespVO> getAssociationImageUrl(String ownerId, String type) {

        ImageExample imageExample = new ImageExample();
        imageExample.createCriteria().andOwnerIdEqualTo(ownerId).andTypeEqualTo(type);

        List<Image> images = imageMapper.selectByExample(imageExample);
        List<ImageRespVO> voList = new ArrayList<>();
        for (Image image : images) {
            ImageRespVO vo = new ImageRespVO();
            BeanUtils.copyProperties(image, vo);
            vo.setUid(image.getImageId());
            vo.setStatus("done");
            vo.setName(image.getImageName());
            voList.add(vo);
        }
        return voList;
    }

    @Override
    public void deleteImage(String imageId) {
        ImageExample imageExample = new ImageExample();
        imageExample.createCriteria().andImageIdEqualTo(imageId);
        imageMapper.deleteByExample(imageExample);
    }
}
