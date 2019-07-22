package com.liyang.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LawItem {
    private long lawItemID;
    private int lawItemType;
    private int itemNo;
    private String itemNoText;
    private String itemName;
    private String itemContent;
}
