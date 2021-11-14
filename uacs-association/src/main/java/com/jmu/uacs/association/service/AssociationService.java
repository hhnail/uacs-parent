package com.jmu.uacs.association.service;

import com.jmu.uacs.vo.request.AssociationRequestVo;
import com.jmu.uacs.vo.response.AssoicationResponseVo;
import com.jmu.uacs.vo.response.UserAssociationVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AssociationService {

	List<AssoicationResponseVo> getAllAssociationList();

    void saveAssociation(AssociationRequestVo vo);

    void updateAssociationState(String associationId,Integer stateCode);

    List<String> getAssociationAdminIdList(Integer associationId);

    List<UserAssociationVo> getAssociationByUserId(String userId,Integer[] roleIds);

    AssoicationResponseVo getAssociationInfo(Integer associationId);
}
