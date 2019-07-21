package com.liyang.service;

import com.liyang.entity.LawItem;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Xiao
 * @Date:
 * @Description:
 **/
public interface LawItemService {
    List<LawItem> getList(int page);
    LawItem getLawItem(int lawID);
    HashMap<String,Integer> getCount();

}
