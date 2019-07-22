package com.liyang.entity.relations;

import com.liyang.entity.ObjectNodeRelation;
import com.liyang.entity.node.JudgeNode;
import com.liyang.entity.node.TrialCourtNode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;

/**
 * @Author: Pan
 * @Date: 2019/7/22 9:00
 * @Description:
 **/
@Getter
@Setter
@NoArgsConstructor
@RelationshipEntity(type = "CourtJudge")
public class CourtJudge extends ObjectNodeRelation {

    @StartNode
    private TrialCourtNode trialCourtNode;

    @EndNode
    private JudgeNode judgeNode;

    @Property(name = "type")
    private String type;




}
