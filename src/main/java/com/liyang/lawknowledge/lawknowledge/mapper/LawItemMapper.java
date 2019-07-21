package com.liyang.lawknowledge.lawknowledge.mapper;

import com.liyang.lawknowledge.lawknowledge.entity.LawItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LawItemMapper {
    static List<LawItem> getList(@Param("limits") int limits, @Param("limite") int limite);
    static LawItem getLawItem(@Param("lawItemID") int lawItemID);
    static int getCount();
}
