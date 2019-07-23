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
 * @Date: 2019/7/21 20:16
 * @Description:
 **/
@Getter
@Setter
@NoArgsConstructor
@NodeEntity(label = "LawCase")
public class LawCase {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "law_id")
    private String lawId;

    @Property(name = "law_name")
    private String lawName;

}
