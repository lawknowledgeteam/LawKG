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

    private final static  int pageCount = 5;

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
        List<Record> result = recordMapper.getTotalList(limits,limite,userID);
        return result;
    }

    @Override
    public int insertNew(Record record) {
        int caseID = record.getCaseID();
        String caseKind = recordMapper.getCaseKind(caseID);
        record.setCaseKind(caseKind);
        record.setLastViewTime(new Date());
        return recordMapper.insertNew(record);
    }

    @Override
    public String getCaseKind(int caseID) {
        return recordMapper.getCaseKind(caseID);
    }
}
