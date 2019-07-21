package com.liyang.lawknowledge.lawknowledge.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LawItem {
    private long lawItemId;
    private int lawItemType;
    private int itemNo;
    private String itemNoText;
    private String itemName;
    private String itemContent;
}
