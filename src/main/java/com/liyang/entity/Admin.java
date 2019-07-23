package com.liyang.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class Admin {
    private int adminID;
    private String loginName;
    private String nickName;
    private String passwordMD5;
    private Date creatTime;
    private Date lastLoginTime;

}
