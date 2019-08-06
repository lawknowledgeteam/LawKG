package com.liyang.entity.node;

import com.liyang.entity.ObjectNodeRelation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * @Author: Pan
 * @Date: 2019/8/6 15:28
 * @Description:
 **/
@Getter
@Setter
@NoArgsConstructor
@NodeEntity(label = "Defendant")
public class Prosecutor extends ObjectNodeRelation {
    @Property(name = "prosecutor_id")
    private String judgeId;

    @Property(name = "prosecutor_name")
    private String name;

}
