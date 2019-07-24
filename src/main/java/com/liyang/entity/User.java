package com.liyang.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {

    private int userID;
    private String nickName;
    private String loginName;
    private String passWord;
    private String headUrl;
    private String mobilePhone;
    private int sex;
    private Date birthDate;
    private Date lastLoginTime;
    private Date registerTime;
    private String token;

}
