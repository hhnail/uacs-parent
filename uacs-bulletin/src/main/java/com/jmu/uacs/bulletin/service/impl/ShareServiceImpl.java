package com.jmu.uacs.bulletin.service.impl;

import com.jmu.uacs.bulletin.bean.Share;
import com.jmu.uacs.bulletin.mapper.ShareMapper;
import com.jmu.uacs.bulletin.service.ShareService;
import com.jmu.uacs.vo.request.AddShareRequestVO;
import com.jmu.uacs.vo.response.ShareResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {

    @Autowired
    ShareMapper shareMapper;

    @Override
    public List<ShareResponseVo> getShareList() {
        List<ShareResponseVo> shares = shareMapper.getShareList(null, null);
        return shares;
    }

    @Override
    public void addShare(AddShareRequestVO reqVO) {
        Share share = new Share();
        BeanUtils.copyProperties(reqVO, share);
        share.setShareContent(reqVO.getShareContent().getBytes());
        share.setIsDel(0);
        share.setView(0);
        shareMapper.insert(share);
    }

    @Override
    public ShareResponseVo getShareById(String shareId) {
        List<ShareResponseVo> shares = shareMapper.getShareList(shareId, null);
        return shares.get(0);
    }

    @Override
    public List<ShareResponseVo> getShareByAssociation(String associationId) {
        List<ShareResponseVo> shares = shareMapper.getShareList(null, associationId);
        return shares;
    }
}
