package com.liyang.service;

import com.liyang.entity.LawFirm;

import java.util.HashMap;
import java.util.List;
/**
 * @Author: Xiao
 * @Date:
 * @Description:
 **/
public interface LawFirmService {
    List<LawFirm> getList(int page);
    LawFirm getLawFirm(int lawFirmID);
    HashMap<String,Integer> getCount();
    int insertNew(LawFirm lawFirm);
}
