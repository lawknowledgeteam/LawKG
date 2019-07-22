package com.liyang.entity.relations;

import com.liyang.entity.node.Judge;
import com.liyang.entity.node.LawCase;
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
 * @Date: 2019/7/22 9:03
 * @Description:
 **/
@Getter
@Setter
@NoArgsConstructor
@RelationshipEntity(type = "JudgeCase")
public class JudgeCase {
    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Judge judge;

    @EndNode
    private LawCase lawCase;

    @Property(name = "type")
    private String type;
}
