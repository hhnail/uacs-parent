package com.jmu.uacs.association.service.impl;

import com.jmu.uacs.association.bean.PieData;
import com.jmu.uacs.association.bean.RingGauge;
import com.jmu.uacs.association.mapper.AssociationMapper;
import com.jmu.uacs.association.mapper.RecruitmentMapper;
import com.jmu.uacs.association.service.DataViewService;
import com.jmu.uacs.enums.ApplicationStateEnum;
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
}
