package com.jmu.uacs.user.service;

import com.jmu.uacs.user.bean.Tag;
import com.jmu.uacs.vo.response.TagRespVo;

import java.util.List;
import java.util.Map;

public interface TagService {

    List<TagRespVo> getUserTagById(Integer userId);

    Map<String, List<TagRespVo>> getAllTags();
}
