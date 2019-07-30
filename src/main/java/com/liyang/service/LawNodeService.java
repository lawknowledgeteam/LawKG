package com.liyang.service;

import com.liyang.entity.ObjectNodeRelation;
import com.liyang.entity.node.LawItemNode;
import com.liyang.entity.node.LawNode;
import com.liyang.entity.relations.LawLawType;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/22 16:12
 * @Description:
 **/

public interface LawNodeService {
    List<LawNode> getLawNode(int page);
    List<LawNode> getLawNodeByName(String lawName,int page);
    List<LawNode> getLawNodeById( int id, int page);
    List<ObjectNodeRelation> getLawLawTypeId( String id,int page);
    List<LawNode> getThey();
    Iterable<LawNode> findAll();
    List<LawItemNode> getItemByType(String typeId, int page);
}
