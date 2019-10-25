package com.liyang.mapper;

import com.liyang.entity.Record;
import com.liyang.entity.UserSearchRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/10/25 14:38
 * @Description:
 **/

@Repository
public interface UserSearchRecordMapper {
    int insertNew(UserSearchRecord userSearchRecord);
    List<UserSearchRecord> getList(@Param("limits") int limits, @Param("limite") int limite,@Param("userID") int userID);
}
