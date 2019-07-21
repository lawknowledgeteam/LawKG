package com.liyang.lawknowledge.lawknowledge.service;

import com.liyang.lawknowledge.lawknowledge.entity.Law;
import com.liyang.lawknowledge.lawknowledge.entity.LawItem;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Xiao
 * @Date:
 * @Description:
 **/
public interface LawItemService {
    List<LawItem> getList(int page);
    LawItem getLawItem(int lawItemID);
    HashMap<String,Integer> getCount();

}
