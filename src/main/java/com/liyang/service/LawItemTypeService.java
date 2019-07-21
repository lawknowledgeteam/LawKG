package com.liyang.lawknowledge.lawknowledge.service;


import com.liyang.lawknowledge.lawknowledge.entity.LawItemType;

import java.util.HashMap;
import java.util.List;

public interface LawItemTypeService {
    List<LawItemType> getList(int page);
    LawItemType getLawItemType (int lawItemType);
    HashMap<String,Integer> getCount();
    int insertNew(LawItemType lawItemType);

}

