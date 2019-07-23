package com.liyang.mapper;

import com.liyang.entity.LawFirm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LawFirmMapper {
    List<LawFirm> getList(@Param("limits") int limits, @Param("limite") int limite);
    LawFirm getLawFirm(@Param("lawFirmID") int lawFirmID);
    int getCount();
    int insertNew(LawFirm lawFirm);
}
