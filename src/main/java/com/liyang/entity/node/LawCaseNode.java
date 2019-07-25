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
 * @Date: 2019/7/21 20:16
 * @Description:
 **/
@Getter
@Setter
@NoArgsConstructor
@NodeEntity(label = "LawCase")
public class LawCaseNode extends ObjectNodeRelation {
/*
    @Id
    @GeneratedValue
    private Long id;*/

    @Property(name = "case_id")
    private String caseId;

    @Property(name = "law_case")
    private String lawCase;

    @Property(name = "trial_date")
    private String trialDate;

    @Property(name = "case_font")
    private String caseFont;

    @Property(name = "case_view")
    private String caseView;
}
