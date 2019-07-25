package com.liyang.repository;

import com.liyang.entity.ObjectNodeRelation;
import com.liyang.entity.node.LawCaseNode;
import com.liyang.entity.relations.JudgeCase;
import com.liyang.entity.relations.KindCase;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/23 19:58
 * @Description:
 **/

@Repository
public interface LawCaseNodeRepository extends Neo4jRepository<LawCaseNode,Long> {
    @Query("match(l:LawCase) \n" +
            "where l.law_case =~ {name}\n" +   //.*爆炸案.*
            "return l\n" +
            "skip {skip} limit {limit} ")
    List<ObjectNodeRelation>  searchByName(@Param("name") String name,
                                           @Param("skip") int skip,
                                           @Param("limit") int limit);

    @Query("match(l:LawCase)-[:KindCase]-(:CaseKind)-[:KindCase]-(l2:LawCase)\n" +
            "where l.law_case =~ {name} \n" +
            "return l2\n" +
            "skip {skip} limit {limit} ")
    List<ObjectNodeRelation>  searchSameKind(@Param("name") String name,
                                           @Param("skip") int skip,
                                           @Param("limit") int limit);

    @Query("match(l:LawCase)-[:JudgeCase]-(:Judge)-[:CourtJudge]-(:TrialCourt)-[*..]-(l2:LawCase)\n" +
            "where l.law_case =~ {name}\n" +
            "return l2\n" +
            "skip {skip} limit {limit} ")
    List<ObjectNodeRelation>  searchSameCourt(@Param("name") String name,
                                           @Param("skip") int skip,
                                           @Param("limit") int limit);

    @Query("match p=(:TrialCourt)-[]-(:Judge)-[]-(l:LawCase)-[]-()  where l.case_id = '1' return p")
    List<ObjectNodeRelation> getInfoRelation (@Param("caseId") String caseId);

    @Query("match p=(:CaseKind)-[:KindCase]-(l:LawCase) " +
            "  where l.case_id = {caseId} " +
            "return p")
    List<KindCase> getKindCase(@Param("caseId") String caseId);

    @Query("match p=(:Judge)-[:JudgeCase]-(l:LawCase)  " +
            "where l.case_id = {caseId}  " +
            " return p")
    List<JudgeCase> getJudgeCase(@Param("caseId") String caseId);



}
