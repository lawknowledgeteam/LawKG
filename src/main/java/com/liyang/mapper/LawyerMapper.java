package com.liyang.mapper;

import com.liyang.entity.Lawyer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LawyerMapper {
    int insertNew(Lawyer lawyer);
    List<Lawyer> getList(@Param("limits") int limits, @Param("limite") int limite);
    int del(int lawyerID);
//    int changeInfo(Lawyer lawyer);
}
