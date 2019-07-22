package com.liyang.mapper;


import com.liyang.entity.Law;
import com.liyang.entity.LawItemType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LawMapper {
    List<Law> getList(@Param("limits") int limits, @Param("limite") int limite);
    Law getLaw(@Param("lawID") int lawID);
    int getCount();
    int insertNew(Law law);
    List<Law> getLawItemTypeName(@Param("lawID") int lawID);
}
