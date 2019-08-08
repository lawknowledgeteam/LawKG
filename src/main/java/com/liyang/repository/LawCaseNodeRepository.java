package com.liyang.repository;

import com.liyang.entity.ObjectNodeRelation;
import com.liyang.entity.node.*;
import com.liyang.entity.relations.CourtJudge;
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

    @Query("match p=(:TrialCourt)-[]-(:Judge)-[]-(l:LawCase)-[]-(:CaseKind)  where l.case_id = {caseId} return p")
    List<ObjectNodeRelation> getInfoRelation (@Param("caseId") String caseId);

    @Query("MATCH p=(l:LawCase)-[r:DefRelation]->(d:Defendant)\n" +
            "where l.case_id = {caseId}  RETURN d ")
    List<DefendantNode> getDefendant(@Param("caseId") String caseId);

    @Query("MATCH (l:LawCase)-[r:ProRelation]->(p:Prosecutor) \n" +
            "where l.case_id = {caseId}  RETURN p ")
    List<ProsecutorNode> getProsecutor(@Param("caseId") String caseId);

    @Query("match p=(:CaseKind)-[:KindCase]-(l:LawCase) " +
            "  where l.case_id = {caseId} " +
            "return p")
    List<KindCase> getKindCase(@Param("caseId") String caseId);

    @Query("match p=(j:Judge)-[:JudgeCase]-(l:LawCase)  " +
            "where l.case_id = {caseId}  " +
            " return j")
    List<JudgeNode> getJudgeCase(@Param("caseId") String caseId);

    @Query("match (l:LawCase)-[]-(j:Judge)-[c:CourtJudge]-(t:TrialCourt)  \n" +
            " where l.case_id = {caseId} \n" +
            "return (j)-[c]-(t)")
    List<CourtJudge> getCourtJudge(@Param("caseId") String caseId);

    @Query("MATCH (l:LawCase)-[:KindCase]-(:CaseKind)-[:KindCase]-(ll:LawCase)\n" +
            "where  l.case_id = {caseId}\n" +
            "return ll\n" +
            "skip {skip} limit {limit}")
    List<LawCaseNode> getSame(@Param("caseId") String caseId,
                          @Param("skip") int skip,
                          @Param("limit") int limit);

    @Query("MATCH (l:LawCase)-[:KindCase]-(ck:CaseKind)\n" +
            "where  l.case_id = {caseId}\n" +
            "return ck")
    CaseKindNode getKind(@Param("caseId") String caseId);

    @Query("MATCH (n:LawCase)\n" +
            "RETURN n order by n.trial_date desc\n" +
            "skip {skip} LIMIT {limit}")
    List<LawCaseNode> getNewCase(@Param("skip") int skip,@Param("limit") int limit);

    @Query("MATCH (n:LawCase)\n" +
            "where n.case_id ={caseId}\n" +
            "RETURN n")
    LawCaseNode getCaseByid(@Param("caseId") String caseId);

    @Query("MATCH (l:LawCase)-[:KindCase]-(c:CaseKind)\n" +
            "where c.case_kind =~  {caseKind}\n" +   //'.*不当.*'
            "RETURN l\n" +
            "skip {skip} limit {limit}")
    List<LawCaseNode> getCaseByKind(@Param("caseKind") String  caseKind,
                                    @Param("skip") int skip,
                                    @Param("limit") int limit);

}
