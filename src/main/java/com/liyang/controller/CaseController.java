package com.liyang.controller;

import com.liyang.entity.Case;
import com.liyang.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/case")
public class CaseController {
    @Autowired
    CaseService caseService;


    @PostMapping("/update")
    public HashMap<String,Integer> insertNew(Case cases) {
        HashMap<String,Integer> hm = new HashMap<>();
        int result = caseService.insertNew(cases);
        if (result != 0){
            hm.put("code",1);
        }else {
            hm.put("code",0);
        }
        return hm;
    }
}
