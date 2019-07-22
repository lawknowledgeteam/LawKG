package com.liyang.repository;

import com.liyang.entity.ObjectNodeRelation;
import com.liyang.entity.relations.LawLawType;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/22 9:32
 * @Description:
 **/
@Repository
public interface LawRepository extends Neo4jRepository<LawLawType,Long>{

    @Query("MATCH p=(:Law)-[:LawLawType]->(:LawItemType)-[]->(:LawItem) return p")
    Iterable<ObjectNodeRelation> getdas();

}
