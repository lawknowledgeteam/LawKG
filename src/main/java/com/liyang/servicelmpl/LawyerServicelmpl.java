package com.liyang.servicelmpl;

import com.liyang.entity.Lawyer;
import com.liyang.mapper.LawyerMapper;
import com.liyang.service.LawyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LawyerServicelmpl implements LawyerService {
    @Autowired
    LawyerMapper lawyerMapper;

    private final static  int pageCount = 10;

    @Override
    public List<Lawyer> getList(int page) {
        int limits = pageCount * (page-1);
        int limite = pageCount;
        return lawyerMapper.getList(limits,limite);
    }

    @Override
    public int insertNew(Lawyer lawyer) {
        return lawyerMapper.insertNew(lawyer);
    }

    @Override
    public int del(int lawyerID){
        return  lawyerMapper.del(lawyerID);
    }

//    @Override
//    public int changeInfo(Lawyer lawyer){
//        return lawyerMapper.changeInfo(lawyer);
//    }
}
