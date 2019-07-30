package com.liyang.servicelmpl;

import com.liyang.entity.Record;
import com.liyang.mapper.RecordMapper;
import com.liyang.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RecordServicelmpl implements RecordService {
    @Autowired
    RecordMapper recordMapper;

    private final static  int pageCount = 20;

    @Override
    public List<Record> getList(int page,int userID) {
        int limits = pageCount * (page-1);
        int limite = pageCount;
        return recordMapper.getList(limits,limite,userID);
    }

    @Override
    public List<Record> getTotalList(int page,int userID) {
        int limits = pageCount * (page-1);
        int limite = pageCount;
        return recordMapper.getList(limits,limite,userID);
    }

    @Override
    public int insertNew(Record record) {
        record.setLastViewTime(new Date());
        return recordMapper.insertNew(record);
    }
}
