package com.jmu.uacs.bulletin.service.impl;

import com.jmu.uacs.bulletin.bean.Share;
import com.jmu.uacs.bulletin.bean.ShareExample;
import com.jmu.uacs.bulletin.bean.UserRole;
import com.jmu.uacs.bulletin.bean.UserRoleExample;
import com.jmu.uacs.bulletin.mapper.ShareMapper;
import com.jmu.uacs.bulletin.mapper.UserRoleMapper;
import com.jmu.uacs.bulletin.service.ShareService;
import com.jmu.uacs.enums.RoleTypeEnum;
import com.jmu.uacs.vo.request.AddShareRequestVO;
import com.jmu.uacs.vo.response.ShareResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {

    @Autowired
    ShareMapper shareMapper;
    @Autowired
    UserRoleMapper userRoleMapper;


    @Override
    public List<ShareResponseVo> getShareList(String userId) {
        UserRoleExample exp = new UserRoleExample();
        exp.createCriteria().andUserIdEqualTo(userId);
        List<UserRole> userRoles = userRoleMapper.selectByExample(exp);
        boolean isSuperAdmin = false;
        for (UserRole ur : userRoles) {
            if (ur.getRoleId().equals(RoleTypeEnum.SUPER_ADMIN.getCode()) || ur.getRoleId().equals(RoleTypeEnum.ASSOCIATION_ADMIN.getCode())) {
                isSuperAdmin = true;
            }
        }
        if (isSuperAdmin) {
            List<ShareResponseVo> shares = shareMapper.getShareList(null, null);
            return shares;
        } else {
            ShareExample shareExample = new ShareExample();
            shareExample.createCriteria().andUserIdEqualTo(userId);
            List<Share> shares = shareMapper.selectByExample(shareExample);
            List<ShareResponseVo> shareVOList = new ArrayList<>();
            for (Share share : shares) {
                ShareResponseVo vo = new ShareResponseVo();
                BeanUtils.copyProperties(share, vo);
                shareVOList.add(vo);
            }
            return shareVOList;
        }
    }

    @Override
    public void addShare(AddShareRequestVO reqVO) {
        Share share = new Share();
        BeanUtils.copyProperties(reqVO, share);
        share.setShareContent(reqVO.getShareContent().getBytes());
        share.setIsDel(0);
        share.setView(0);
        share.setShareTime(new Date());
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
