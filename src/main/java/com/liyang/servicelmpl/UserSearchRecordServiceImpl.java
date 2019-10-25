package com.liyang.servicelmpl;

import com.liyang.entity.UserSearchRecord;
import com.liyang.mapper.UserSearchRecordMapper;
import com.liyang.service.UserSearchRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/10/25 14:48
 * @Description:
 **/
@Service
public class UserSearchRecordServiceImpl implements UserSearchRecordService {

    @Autowired
    UserSearchRecordMapper userSearchRecordMapper;
    private final static  int pageCount = 5;
    @Override
    public List<UserSearchRecord> getList(int page, int userID) {
        int limits = pageCount * (page-1);
        int limite = pageCount;
        return userSearchRecordMapper.getList(limits,limite,userID);
    }

    @Override
    public int insertNew(UserSearchRecord userSearchRecord) {
        userSearchRecord.setLastViewTime(new Date());
        int rec = userSearchRecordMapper.insertNew(userSearchRecord);
        return rec;
    }
}
