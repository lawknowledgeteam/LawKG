package com.liyang.service;

import com.liyang.entity.Judge;
import com.liyang.entity.Law;

public interface JudgeService {
    Judge getInfo(String name);
    int insertNew(Judge judge);
}
