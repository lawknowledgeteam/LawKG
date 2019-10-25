package com.liyang.service;

import com.liyang.entity.Record;
import com.liyang.entity.UserSearchRecord;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/10/25 14:46
 * @Description:
 **/
public interface UserSearchRecordService {
    List<UserSearchRecord> getList(int page, int userID);
    int insertNew(UserSearchRecord userSearchRecord);
}
