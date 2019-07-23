package com.liyang.mapper;


import com.liyang.entity.LawItemType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface LawItemTypeMapper {
    List<LawItemType> getList(@Param("limits") int limits, @Param("limite") int limite);
    LawItemType getLawItemTypeName(@Param("lawItemType") int lawItemType);
    int getCount();
    int insertNew(LawItemType lawItemType);
}
