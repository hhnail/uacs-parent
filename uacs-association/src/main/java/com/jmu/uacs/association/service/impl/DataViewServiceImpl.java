package com.jmu.uacs.association.service.impl;

import com.jmu.uacs.association.bean.*;
import com.jmu.uacs.association.mapper.AssociationMapper;
import com.jmu.uacs.association.mapper.RecruitmentMapper;
import com.jmu.uacs.association.mapper.TreeNodeMapper;
import com.jmu.uacs.association.service.DataViewService;
import com.jmu.uacs.enums.ApplicationStateEnum;
import com.jmu.uacs.enums.TreeNodeEnum;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class DataViewServiceImpl implements DataViewService {

    @Autowired
    AssociationMapper associationMapper;
    @Autowired
    RecruitmentMapper recruitmentMapper;
    @Autowired
    TreeNodeMapper treeNodeMapper;

    @Override
    public List<PieData> countAssociationGender(Integer associationId) {
        return associationMapper.countAssociationGender(associationId);
    }

    @Override
    public HashMap<String, Double> countAssociationRecruitment(Integer recruitmentId) {
        HashMap<String, Double> resultMap = new HashMap<>();
        resultMap.put("录用人数", 0.0);
        resultMap.put("被拒人数", 0.0);

        List<RingGauge> applicationStateCount = recruitmentMapper.countAssociationRecruitment(recruitmentId);
        log.debug("统计结果：{}", applicationStateCount);

        double applicationNum = 0.0;
        for (RingGauge stateAndNum : applicationStateCount) {
            if (stateAndNum.getName().equals(ApplicationStateEnum.CONFIRM.getState())) {
                resultMap.remove("录用人数");
                resultMap.put("录用人数", stateAndNum.getValue());
            }
            if (stateAndNum.getName().equals(ApplicationStateEnum.APPLY_REFUSE.getState())) {
                resultMap.remove("被拒人数");
                resultMap.put("被拒人数", stateAndNum.getValue());
            }
            applicationNum += stateAndNum.getValue();
        }
        resultMap.put("投递人数", applicationNum);
        return resultMap;
    }

    @Override
    public HashMap<String, Integer> countAssociationTypeAndNum() {
        HashMap<String, Integer> resultMap = new HashMap<>();

        // 查询目前所有类型，初始化数量为0
        TreeNodeExample treeExp = new TreeNodeExample();
        treeExp.createCriteria().andTypeEqualTo(TreeNodeEnum.ASSOCIATION_TYPE.getValue());
        List<TreeNode> treeNodes = treeNodeMapper.selectByExample(treeExp);
        for (TreeNode node : treeNodes) {
            resultMap.put(node.getValue(), 0);
        }

        // 查询对应类型的数量
        List<CountAssociationType> countResult = associationMapper.countAssociationType();
        for (CountAssociationType countType : countResult) {
            resultMap.remove(countType.getType());
            resultMap.put(countType.getType(), countType.getValue());
        }

        return resultMap;
    }
}
