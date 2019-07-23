package com.liyang.service;

import com.liyang.entity.Lawyer;

import java.util.List;

public interface LawyerService {
    List<Lawyer> getList(int page);
    int insertNew(Lawyer lawyer);
    int del(int lawyerID);

//    int changeInfo(Lawyer lawyer);
}
