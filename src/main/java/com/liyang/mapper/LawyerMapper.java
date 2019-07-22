package com.liyang.mapper;

import com.liyang.entity.Lawyer;
import org.springframework.stereotype.Repository;

@Repository
public interface LawyerMapper {
    int insertNew(Lawyer lawyer);
}
