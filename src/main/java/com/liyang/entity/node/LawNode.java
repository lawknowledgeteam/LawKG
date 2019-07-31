package com.liyang.entity.node;

import com.liyang.entity.ObjectNodeRelation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/21 20:11
 * @Description:
 **/
@Getter
@Setter
@NoArgsConstructor
@NodeEntity(label = "Law")
public class LawNode extends ObjectNodeRelation {
//    @Id
//    @GeneratedValue
//    private Long id;

    @Property(name = "law_id")
    private String lawId;

    @Property(name = "law_name")
    private String lawName;

    @Relationship(type = "LawLawType",direction = Relationship.OUTGOING)
    private List<LawItemTypeNode> lawItemTypeNodes;
    public void addLawItemTypeNode(LawItemTypeNode lawItemTypeNode){
        if(this.lawItemTypeNodes == null){
            this.lawItemTypeNodes = new ArrayList<>();
        }
        this.lawItemTypeNodes.add(lawItemTypeNode);
    }
}
