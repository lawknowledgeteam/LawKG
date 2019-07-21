package com.liyang.mapper;

import com.liyang.entity.LawItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Xiao
 * @Date:
 * @Description:
 **/
@Repository
public interface LawItemMapper {
    List<LawItem> getList(@Param("limits") int limits, @Param("limite") int limite);
    LawItem getLawItem(@Param("lawItemID") int lawItemID);
    int getCount();
}
