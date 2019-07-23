package com.liyang.servicelmpl;

import com.liyang.entity.LawFirm;
import com.liyang.mapper.LawFirmMapper;
import com.liyang.service.LawFirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class LawFirmServicelmpl implements LawFirmService {

    @Autowired
    LawFirmMapper lawFirmMapper;

    private final static  int pageCount = 10;

    @Override
    public List<LawFirm> getList(int page) {
        int limits = pageCount * (page-1);
        int limite = pageCount;
        return lawFirmMapper.getList(limits,limite);
    }

    @Override
    public LawFirm getLawFirm(int lawFirmID) {

        return lawFirmMapper.getLawFirm(lawFirmID);
    }

    @Override
    public HashMap<String, Integer> getCount() {
        HashMap<String, Integer> hm = new HashMap<>();
        int count = lawFirmMapper.getCount();
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
    public int insertNew(LawFirm lawFirm) {
        return lawFirmMapper.insertNew(lawFirm);
    }
}
