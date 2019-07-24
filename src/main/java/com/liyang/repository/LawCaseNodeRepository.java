package com.liyang.repository;

import com.liyang.entity.node.LawCaseNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Pan
 * @Date: 2019/7/23 19:58
 * @Description:
 **/
@Repository
public interface LawCaseNodeRepository extends Neo4jRepository<LawCaseNode,Long> {

}
