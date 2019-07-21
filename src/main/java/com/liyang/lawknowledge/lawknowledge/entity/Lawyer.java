package com.liyang.lawknowledge.lawknowledge.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Lawyer {

    private int lawyerId;
    private String lawyerName;
    private String idCard;
    private String lawFirmId;
    private short sex;
    private Date birthDay;
    private String description;

}
