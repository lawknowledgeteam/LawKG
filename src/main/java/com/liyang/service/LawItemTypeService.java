package com.liyang.service;


import com.liyang.entity.LawItemType;

import java.util.HashMap;
import java.util.List;

public interface LawItemTypeService {
    List<LawItemType> getList(int page);
    LawItemType getLawItemTypeName (int lawItemType);
    HashMap<String,Integer> getCount();
    int insertNew(LawItemType lawItemType);

}

