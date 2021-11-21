package com.jmu.uacs.association.service;

import com.jmu.uacs.association.bean.TreeNode;
import com.jmu.uacs.vo.request.AssociationRequestVo;
import com.jmu.uacs.vo.response.AssoicationResponseVo;
import com.jmu.uacs.vo.response.UserAssociationVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AssociationService {

	List<AssoicationResponseVo> getAllAssociationList();

    void saveAssociation(AssociationRequestVo vo);

    void updateAssociationState(String associationId,Integer stateCode);

    List<String> getAssociationAdminIdList(Integer associationId);

    List<UserAssociationVo> getAssociationByUserId(String userId,Integer[] roleIds);

    AssoicationResponseVo getAssociationInfo(Integer associationId);

    /**
     * 【普通学生、社团管理员】的社团管理列表中VO
     * 查询某用户所在的社团及其在社团中担任的角色
     * @param userId
     * @return
     */
    List<AssoicationResponseVo> getAssociationAsMember(String userId);

    /**
     * 获取社团 Name 和 Id 的映射关系
     * @return
     */
    HashMap<String, Integer> getNameIdMap();

    /**
     * 获取社团类型
     * @return
     */
    List<TreeNode> getAssociationType();

    /**
     * 查询当前name社团是否已经存在
     * 社团名称不允许同名
     * @param associationName
     * @return
     */
    Boolean checkAssociationExist(String associationName);
}
