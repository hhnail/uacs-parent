package com.jmu.uacs.association.service.impl;

import com.jmu.uacs.association.bean.Image;
import com.jmu.uacs.association.mapper.ImageMapper;
import com.jmu.uacs.association.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageMapper imageMapper;

    @Override
    public void saveImage(MultipartFile image) throws IOException {
        Image record = new Image();
        byte[] bytes = image.getBytes();
        record.setData(bytes);
        imageMapper.insert(record);
    }

    @Override
    public Image getImageById(Integer imageId) {
        Image image = imageMapper.selectByPrimaryKey(imageId);
        return image;
    }
}
