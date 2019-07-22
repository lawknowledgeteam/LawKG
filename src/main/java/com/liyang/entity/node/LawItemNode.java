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
 * @Date: 2019/7/21 20:17
 * @Description:
 **/
@Getter
@Setter
@NoArgsConstructor
@NodeEntity(label = "LawItem")
public class LawItemNode extends ObjectNodeRelation {
//    @Id
//    @GeneratedValue
//    private Long id;

    @Property(name = "law_item_id")
    private String lawItemId;

    @Property(name = "item_no")
    private String itemNo;

    @Property(name = "item_no_text")
    private String itemNoText;

    @Property(name = "item_name")
    private String itemName;

    @Property(name = "item_content")
    private String itemContent;

}
