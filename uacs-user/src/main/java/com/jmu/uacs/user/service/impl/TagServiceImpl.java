package com.jmu.uacs.user.service.impl;

import com.jmu.uacs.user.bean.Tag;
import com.jmu.uacs.user.bean.UserTag;
import com.jmu.uacs.user.bean.UserTagExample;
import com.jmu.uacs.user.mapper.TagMapper;
import com.jmu.uacs.user.mapper.UserTagMapper;
import com.jmu.uacs.user.service.TagService;
import com.jmu.uacs.vo.response.TagRespVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Autowired
    UserTagMapper userTagMapper;

//    据说service层之间最好不要相互调用
//    @Autowired
//    UserService userService;

    @Override
    public List<TagRespVo> getUserTagById(String userId) {
        //根据userId获取用户的标签Id
        UserTagExample example = new UserTagExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<UserTag> userTagIdList = userTagMapper.selectByExample(example);
        //创建返回的TagList，遍历添加
        List<TagRespVo> respTagList = new ArrayList<>();
        TagRespVo tagVo = new TagRespVo();//提取出来，这对象在foreach反复使用
        for (UserTag userTag : userTagIdList) {
            Tag tag = tagMapper.selectByPrimaryKey(userTag.getTagId());
            BeanUtils.copyProperties(tag, tagVo);
            respTagList.add(tagVo);
        }
        return respTagList;
    }

    /**
     * 获取标签的map集合
     * key：父标签名
     * value：子标签集合
     *
     * @return
     */
    @Override
    public Map<String, List<TagRespVo>> getAllTags() {
        Map<String, List<TagRespVo>> allTagsMap = new HashMap<>();
        List<Tag> allTags = tagMapper.selectByExample(null);
        //第一次遍历list，得到一级tag，存储到map中
        Map<Integer, String> parentTagMap = new HashMap<>();
        for (Tag tag : allTags) {
            if (tag.getPId() == 0) {//0表示父标签
                //key：父标签名 value：子标签list
                parentTagMap.put(tag.getTagId(), tag.getTagName());
                allTagsMap.put(tag.getTagName(), new ArrayList<>());
            }
        }
        log.debug("==25 后台服务-service-父标签map={}", parentTagMap);

        /*第二次遍历list,构建tag父子结构
         *下面这个不能放在foreach外面，因为vo指向了list中的对象
         * 在copy拷贝对象的时候，改变了vo，list里的东西就都变了
         */
//        TagRespVo vo = new TagRespVo();，
        for (Tag tag : allTags) {
            TagRespVo vo = new TagRespVo();
            //若不是父Tag
            Integer pid = tag.getPId();
            if (pid != 0) {//0表示父标签
                String pTagName = parentTagMap.get(pid);
                List<TagRespVo> tagList = allTagsMap.get(pTagName);
                BeanUtils.copyProperties(tag, vo);
                tagList.add(vo);
            }
        }
        log.debug("==24 后台服务-service-获取所有标签={}", allTagsMap);
        return allTagsMap;
    }
}
