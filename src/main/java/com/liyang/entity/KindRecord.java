package com.liyang.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class KindRecord {
    private int kindRecord;
    private int userID;
    private String caseKind;
    private int weight;
    private Date lastViewTime;
}
