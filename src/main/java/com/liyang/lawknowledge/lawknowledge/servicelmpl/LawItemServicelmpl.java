package com.liyang.lawknowledge.lawknowledge.servicelmpl;


import com.liyang.lawknowledge.lawknowledge.entity.LawItem;
import com.liyang.lawknowledge.lawknowledge.mapper.LawItemMapper;
import com.liyang.lawknowledge.lawknowledge.service.LawItemService;
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
        List<LawItem> result = lawItemMapper.getList(limits,limite);
        return result;
    }

    @Override
    public HashMap<String, Integer> getCount() {
        HashMap<String, Integer> hm = new HashMap<>();
        int count = lawItemMapper.getCount();
        if (count != 0){
            hm.put("code",0);
            hm.put("count",count);
        }else{
            hm.put("code",0);
        }
        return hm;
    }


    @Override
    public LawItem getLawItem(int lawItemID) {

        return lawItemMapper.getLawItem(lawItemID);
    }


}
