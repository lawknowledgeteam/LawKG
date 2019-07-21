package com.liyang.lawknowledge.lawknowledge.servicelmpl;


import com.liyang.entity.Law;
import com.liyang.mapper.LawMapper;
import com.liyang.service.LawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class LawServicelmpl implements LawService {
    @Autowired
    LawMapper lawMapper;

    private final static  int pageCount = 10;

    @Override
    public List<Law> getList(int page) {
        int limits = pageCount * (page-1);
        int limite = pageCount;
        return lawMapper.getList(limits,limite);
    }

    @Override
    public Law getLaw(String lawName) {

        return lawMapper.getLaw(lawName);
    }

    @Override
    public HashMap<String, Integer> getCount() {
        HashMap<String, Integer> hm = new HashMap<>();
        int count = lawMapper.getCount();
        if (count != 0){
            hm.put("code",1);
            hm.put("count",count);
        }else {
            hm.put("code",0);
            hm.put("count",0);
        }
        return hm;
    }

    @Override
    public int insertNew(Law law) {
        law.setPublishDate(new Date());
        return lawMapper.insertNew(law);
    }

}
