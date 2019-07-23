package com.liyang.servicelmpl;

import com.liyang.entity.Judge;
import com.liyang.entity.Law;
import com.liyang.mapper.JudgeMapper;
import com.liyang.service.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JudgeServicelmpl implements JudgeService {
    @Autowired
    JudgeMapper judgeMapper;

    @Override
    public Judge getInfo(String name) {
        return judgeMapper.getInfo(name);
    }

    @Override
    public int insertNew(Judge judge) {
        return judgeMapper.insertNew(judge);
    }

}
