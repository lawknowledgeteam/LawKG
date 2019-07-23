package com.liyang.entity.relations;

import com.liyang.entity.ObjectNodeRelation;
import com.liyang.entity.node.LawItemNode;
import com.liyang.entity.node.LawItemTypeNode;
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
 * @Date: 2019/7/22 9:08
 * @Description:
 **/
@Getter
@Setter
@NoArgsConstructor
@RelationshipEntity(type = "LawTypeItem")
public class LawTypeItem extends ObjectNodeRelation{
//    @Id
//    @GeneratedValue
//    private Long id;

    @StartNode
    private LawItemTypeNode lawItemTypeNode;

    @EndNode
    private LawItemNode lawItemNode;

    @Property(name = "type")
    private String type;
}
