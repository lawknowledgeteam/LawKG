package com.liyang.lawknowledge.lawknowledge.mapper;

import com.liyang.lawknowledge.lawknowledge.entity.Law;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface LawMapper {
    List<Law> getList(@Param("limits") int limits, @Param("limite") int limite);
    Law getLaw(@Param("lawName") String lawName);
    int getCount();
    int insertNew(Law law);
}
