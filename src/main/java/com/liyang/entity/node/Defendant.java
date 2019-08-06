package com.liyang.entity.node;

import com.liyang.entity.ObjectNodeRelation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * @Author: Pan
 * @Date: 2019/8/6 15:27
 * @Description:
 **/
@Getter
@Setter
@NoArgsConstructor
@NodeEntity(label = "Defendant")
public class Defendant extends ObjectNodeRelation {
    @Property(name = "defendant_id")
    private String judgeId;

    @Property(name = "defendant_name")
    private String name;

}
