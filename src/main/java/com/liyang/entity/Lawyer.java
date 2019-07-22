package com.liyang.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Lawyer {

    private int lawyerID;
    private String lawyerName;
    private String idCard;
    private String lawFirmID;
    private short sex;
//    private Date birthday;
    private String description;

}
