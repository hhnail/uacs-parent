package com.jmu.uacs.association.service;

import com.jmu.uacs.association.bean.Image;
import com.jmu.uacs.vo.response.ImageRespVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    ImageRespVO saveImage(MultipartFile image, String type, String ownerId) throws IOException;

    Image getImageById(String imageId);

    List<ImageRespVO> getAssociationImageUrl(String ownerId, String type);

    void deleteImage(String imageId);
}
