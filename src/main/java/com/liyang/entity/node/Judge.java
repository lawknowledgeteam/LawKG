package com.liyang.entity.node;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;

/**
 * @Author: Pan
 * @Date: 2019/7/21 20:15
 * @Description:
 **/
@Getter
@Setter
@NoArgsConstructor
@NodeEntity(label = "Judge")
public class Judge {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "judge_id")
    private String judgeId;

    @Property(name = "name")
    private String name;

}
