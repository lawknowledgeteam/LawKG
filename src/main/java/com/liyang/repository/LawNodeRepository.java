package com.liyang.repository;

import com.liyang.entity.ObjectNodeRelation;
import com.liyang.entity.node.LawNode;
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
public interface LawNodeRepository extends Neo4jRepository<LawLawType,Long>{

    @Query("MATCH (l:Law) RETURN l  skip {skip} limit {limit}")
    List<LawNode> getLawNode(@Param("skip") int skip, @Param("limit") int limit);

    @Query("MATCH (l:Law) \n" +
            "where l.law_name =~ {lawName} \n" +   //'.*.*'
            "RETURN l \n" +
            "skip {skip} limit {limit}")
    List<LawNode> getLawNodeByName(@Param("lawName") String lawName,
                                   @Param("skip") int skip,
                                   @Param("limit") int limit);

    @Query("MATCH (l:Law)\n" +
            "where l.law_id = {id} \n" +
            "RETURN l \n" +
            "skip {skip} limit {limit} ")
    List<LawNode> getLawNodeById(@Param("id") String id,
                                 @Param("skip") int skip,
                                 @Param("limit") int limit);



}
