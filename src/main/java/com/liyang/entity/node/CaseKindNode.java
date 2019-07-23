package com.liyang.entity.node;

import com.liyang.entity.ObjectNodeRelation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;

/**
 * @Author: Pan
 * @Date: 2019/7/21 20:13
 * @Description:
 **/
@Getter
@Setter
@NoArgsConstructor
@NodeEntity(label = "CaseKind")
public class CaseKindNode extends ObjectNodeRelation{
//    @Id
//    @GeneratedValue
//    private Long id;

    @Property(name = "case_kind")
    private String caseKind;
}
