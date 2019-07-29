package com.liyang.service;

import com.liyang.entity.ObjectNodeRelation;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/25 9:43
 * @Description:
 **/
public interface LawCaseNodeService {

    List<ObjectNodeRelation> searchByName(String name, int page);

    List<ObjectNodeRelation>  searchSameKind(String name, int page);

    List<ObjectNodeRelation>  searchSameCourt(String name,int page);

    List<ObjectNodeRelation> getInfoRelation( int caseId);

    HashMap<String,Object> getInfo(String caseId);
}
