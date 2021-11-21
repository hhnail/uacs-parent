package com.jmu.uacs.association.service;

import com.jmu.uacs.association.bean.PieData;
import com.jmu.uacs.association.bean.RingGauge;

import java.util.HashMap;
import java.util.List;

public interface DataViewService {

    List<PieData> countAssociationGender(Integer associationId);

    HashMap<String, Double> countAssociationRecruitment(Integer associationId);
}
