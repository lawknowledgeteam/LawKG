package com.liyang.controller;

import com.liyang.entity.Lawyer;
import com.liyang.service.LawyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/lawyer")
public class LawyerController {
    @Autowired
    LawyerService lawyerService;

    @PostMapping("/insert")
    public HashMap<String,Integer> insertNew(Lawyer lawyer) {
        HashMap<String,Integer> hm = new HashMap<>();
        int result = lawyerService.insertNew(lawyer);
        if (result != 0){
            hm.put("code",1);
        }else {
            hm.put("code",0);
        }
        return hm;
    }
}
