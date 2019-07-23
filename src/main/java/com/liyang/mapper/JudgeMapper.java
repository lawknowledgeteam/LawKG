package com.liyang.mapper;

import com.liyang.entity.Judge;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JudgeMapper {
    Judge getInfo(@Param("name") String name);
    int insertNew(Judge judge);
}
