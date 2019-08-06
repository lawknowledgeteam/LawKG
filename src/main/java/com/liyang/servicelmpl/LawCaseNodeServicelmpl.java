package com.liyang.servicelmpl;

import com.liyang.entity.ObjectNodeRelation;
import com.liyang.entity.node.*;
import com.liyang.entity.relations.CourtJudge;
import com.liyang.entity.relations.JudgeCase;
import com.liyang.entity.relations.KindCase;
import com.liyang.mapper.RecordMapper;
import com.liyang.repository.LawCaseNodeRepository;
import com.liyang.service.LawCaseNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
    @Autowired
    RecordMapper recordMapper;

    private final int pageLimit = 6;

    @Override
    public List<ObjectNodeRelation> getInfoRelation(int caseId) {
        List<ObjectNodeRelation> result = lawCaseNodeRepository.getInfoRelation(String.valueOf(caseId));
        return result;
    }

    @Override
    public HashMap<String,Object> getInfo(String caseId) {
        List<KindCase> kindCase = lawCaseNodeRepository.getKindCase(caseId);
        List<JudgeNode> judgeCase = lawCaseNodeRepository.getJudgeCase(caseId);
        List<CourtJudge> courtJudge = lawCaseNodeRepository.getCourtJudge(caseId);
        HashMap<String,Object> hm = new HashMap<>();
        hm.put("kindCase",kindCase);
        hm.put("judgeCase",judgeCase);
        hm.put("courtJudge",courtJudge);
        return hm;
    }

    @Override
    public List<LawCaseNode> getSame(String caseId, int page) {
        int skip = (page-1)*10;
        int limit = 10;
        List<LawCaseNode> result = lawCaseNodeRepository.getSame(caseId, skip, limit);
        Collections.shuffle(result);
        return result;
    }

    @Override
    public CaseKindNode getKind(String caseId) {
        return lawCaseNodeRepository.getKind(caseId);
    }

    @Override
    public List<LawCaseNode> getNewCase(int page) {
        int skip = (page-1)*10;
        int limit = 10;
        List<LawCaseNode> result = lawCaseNodeRepository.getNewCase(skip,limit);
        return result;
    }

    @Override
    public LawCaseNode getCaseByid(String caseId) {
        return lawCaseNodeRepository.getCaseByid(caseId);
    }

    @Override
    public List<LawCaseNode> getCaseByKind(String caseKind, int page) {
        int skip = (page-1)*10;
        int limit = 10;
        List<LawCaseNode> result = lawCaseNodeRepository.getCaseByKind(".*"+caseKind+".*",skip,limit);
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

    @Override
    public List<LawCaseNode> getRecommandCase(int userId,int page) {
        int skip = (page - 1) * 3;
        int limit = 3;
        List<String> rank = recordMapper.getTopList(userId);
        List<LawCaseNode> result = new ArrayList<>();
        for(String r : rank) {
            result.addAll(lawCaseNodeRepository.getCaseByKind(r,skip,limit));
        }
        return result;
    }

    @Override
    public List<Defendant> getDefendant(String caseId) {
        return lawCaseNodeRepository.getDefendant(caseId);
    }

    @Override
    public List<Prosecutor> getProsecutor(String caseId) {
        return lawCaseNodeRepository.getProsecutor(caseId);
    }

}
