package com.liyang.mapper;

import com.liyang.entity.Case;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseMapper {
    int insertNew(Case cases);
}
