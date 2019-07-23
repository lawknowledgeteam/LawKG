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
 * @Date: 2019/7/21 20:20
 * @Description:
 **/
@Getter
@Setter
@NoArgsConstructor
@NodeEntity(label = "LawItemType")
public class LawItemTypeNode extends ObjectNodeRelation{
//    @Id
//    @GeneratedValue
//    private Long id;

    @Property(name = "id")
    private String typeId;

    @Property(name = "law_type_no")
    private String lawTypeNo;

    @Property(name = "name")
    private String name;

}
