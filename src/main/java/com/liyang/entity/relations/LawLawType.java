package com.liyang.entity.relations;

import com.liyang.entity.node.Law;
import com.liyang.entity.node.LawCase;
import com.liyang.entity.node.LawItemType;
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
 * @Date: 2019/7/22 9:06
 * @Description:
 **/
@Getter
@Setter
@NoArgsConstructor
@RelationshipEntity(type = "LawLawType")
public class LawLawType {
    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Law law;

    @EndNode
    private LawItemType lawItemType;

    @Property(name = "type")
    private String type;
}
