package com.jmu.uacs.association.service;

import com.jmu.uacs.association.bean.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    void saveImage(MultipartFile image) throws IOException;

    Image getImageById(Integer imageId);
}
