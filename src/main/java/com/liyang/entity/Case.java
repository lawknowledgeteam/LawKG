package com.liyang.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Administrator
 */
@Getter
@Setter
public class Case {

    private int caseID;
    private String caseName;
    private String number;
    private String keyWords;
    private String caseKind;
    private String abstracts;
    private Date prosecutionDate;
    private Date adjudicationDate;
    private String source;
    private String trialCourt;
    private String judgeIds;
    private String defendantIds;
    private String prosecutorIds;
    private String introduction;
    private String analysis;
    private String result;
    private String lawItemIds;
    private String content;


}
