package com.jmu.uacs.bulletin.mapper;

import com.jmu.uacs.bulletin.bean.Share;
import com.jmu.uacs.bulletin.bean.ShareExample;
import java.util.List;

import com.jmu.uacs.vo.response.ShareResponseVo;
import org.apache.ibatis.annotations.Param;

public interface ShareMapper {
    long countByExample(ShareExample example);

    int deleteByExample(ShareExample example);

    int deleteByPrimaryKey(Integer shareId);

    int insert(Share record);

    int insertSelective(Share record);

    List<Share> selectByExampleWithBLOBs(ShareExample example);

    List<Share> selectByExample(ShareExample example);

    Share selectByPrimaryKey(Integer shareId);

    int updateByExampleSelective(@Param("record") Share record, @Param("example") ShareExample example);

    int updateByExampleWithBLOBs(@Param("record") Share record, @Param("example") ShareExample example);

    int updateByExample(@Param("record") Share record, @Param("example") ShareExample example);

    int updateByPrimaryKeySelective(Share record);

    int updateByPrimaryKeyWithBLOBs(Share record);

    int updateByPrimaryKey(Share record);

    /**
     * 查询社团内经历分享
     *
     * @param shareId 根据shareId进行查询，传入null则查询全部未删除记录
     * @return
     */
    List<ShareResponseVo> getShareList(String shareId);
}