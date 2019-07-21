package com.liyang.servicelmpl;


import com.liyang.entity.LawItem;
import com.liyang.mapper.LawItemMapper;
import com.liyang.service.LawItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class LawItemServicelmpl implements LawItemService {
    @Autowired
    LawItemMapper lawItemMapper;

    private final static int pageCount = 10;

    @Override
    public List<LawItem> getList(int page){
        int limits = pageCount * (page-1);
        int limite = pageCount;
        List<LawItem> result = LawItemMapper.getList(limits,limite);
        return result;
    }


    @Override
    public LawItem getLawItem(int lawItemID) {

        return LawItemMapper.getLawItem(lawItemID);
    }

    @Override
    public HashMap<String, Integer> getCount() {
        int count = LawItemMapper.getCount();
        HashMap<String, Integer> hm = new HashMap<>();
        if (count != 0){
            hm.put("code",1);
            hm.put("count",count);
        }else {
            hm.put("code",0);
            hm.put("count",0);
        }
        return hm;
    }
}
