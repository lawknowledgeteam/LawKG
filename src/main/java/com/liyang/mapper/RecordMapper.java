package com.liyang.mapper;

import com.liyang.entity.Record;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordMapper {
    List<Record> getList(@Param("limits") int limits, @Param("limite") int limite,@Param("userID") int userID);
    List<Record> getTotalList(@Param("limits") int limits, @Param("limite") int limite,@Param("userID") int userID);
    int insertNew(Record record);
    String getCaseKind(@Param("caseID") int caseID);
}
