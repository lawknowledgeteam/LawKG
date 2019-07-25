package com.liyang.servicelmpl;

import com.liyang.entity.ObjectNodeRelation;
import com.liyang.entity.node.LawCaseNode;
import com.liyang.repository.LawCaseNodeRepository;
import com.liyang.service.LawCaseNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/25 9:44
 * @Description:
 **/
@Service
public class LawCaseNodeServicelmpl implements LawCaseNodeService {
    @Autowired
    LawCaseNodeRepository lawCaseNodeRepository;
    private final int pageLimit = 6;

    @Override
    public List<ObjectNodeRelation> getInfoRelation(int caseId) {
        List<ObjectNodeRelation> result = lawCaseNodeRepository.getInfoRelation(String.valueOf(caseId));
        return result;
    }

    @Override
    public List<ObjectNodeRelation> searchByName(String name, int page) {
        int skip = (page - 1) * pageLimit;
        int limit = pageLimit;
        List<ObjectNodeRelation> result = lawCaseNodeRepository.searchByName(".*"+name+".*", skip, limit);
        return result;
    }

    @Override
    public List<ObjectNodeRelation> searchSameKind(String name, int page) {
        int skip = (page - 1) * pageLimit;
        int limit = pageLimit/2;
        List<ObjectNodeRelation> result = lawCaseNodeRepository.searchSameKind(".*"+name+".*", skip, limit);
        return result;
    }

    @Override
    public List<ObjectNodeRelation> searchSameCourt(String name, int page) {
        int skip = (page - 1) * pageLimit;
        int limit = pageLimit/3;
        List<ObjectNodeRelation> result = lawCaseNodeRepository.searchSameCourt(".*"+name+".*", skip, limit);
        return result;
    }


}
