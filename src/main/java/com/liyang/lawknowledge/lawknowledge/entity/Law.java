package com.liyang.lawknowledge.lawknowledge.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Law {
    private int lawId;
    private String lawName;
    private String publishNumber;
    private Date publishDate;
    private Date effectiveDate;
    private String issueUnit;
    private String effectiveLevel;
    private String keyWords;
    private String type;

}
