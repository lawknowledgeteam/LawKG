package com.liyang.servicelmpl;


import com.liyang.entity.Lawyer;
import com.liyang.mapper.LawyerMapper;
import com.liyang.service.LawyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LawyerServicelmpl implements LawyerService {
    @Autowired
    LawyerMapper lawyerMapper;

    @Override
    public int insertNew(Lawyer lawyer) {
        return lawyerMapper.insertNew(lawyer);
    }
}
