package com.liyang.lawknowledge.lawknowledge.service;

import java.util.HashMap;
import java.util.List;

public interface LawService {
    List<LawService> getList(int page);
    HashMap<String,Integer> getCount();
    int insertNew(LawService law);
}
