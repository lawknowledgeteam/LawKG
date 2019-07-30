package com.liyang.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Record {
    private int recordID;
    private int userID;
    private int caseID;
    private String caseKind;
    private Date lastViewTime;
}
