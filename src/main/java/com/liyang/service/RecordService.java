package com.liyang.service;

import com.liyang.entity.Record;

import java.util.List;

public interface RecordService {
    List<Record> getList(int page,int userID);
    List<Record> getTotalList(int page,int userID);
    int insertNew(Record record);
}
