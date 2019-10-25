package com.liyang.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: Pan
 * @Date: 2019/10/25 14:36
 * @Description:
 **/
@Getter
@Setter
public class UserSearchRecord {
    private int recordID;
    private int userID;
    private String keyWord;
    private Date lastViewTime;
    private Date endTime;
    private int caseCount;
    private int browseLength;
}
