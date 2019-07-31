package com.liyang.servicelmpl;

import com.liyang.entity.Case;
import com.liyang.mapper.CaseMapper;
import com.liyang.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseServicelmpl implements CaseService {
    @Autowired
    CaseMapper caseMapper;

    @Override
    public int insertNew(Case cases) {
        return caseMapper.insertNew(cases);
    }
}
