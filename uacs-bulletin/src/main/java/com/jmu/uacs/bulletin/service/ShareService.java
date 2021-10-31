package com.jmu.uacs.bulletin.service;

import com.jmu.uacs.vo.request.AddShareRequestVO;
import com.jmu.uacs.vo.response.ShareResponseVo;

import java.util.List;

public interface ShareService {
    List<ShareResponseVo> getShareList();

    void addShare(AddShareRequestVO reqVO);

    ShareResponseVo getShareById(String shareId);

    List<ShareResponseVo> getShareByAssociation(String associationId);
}
