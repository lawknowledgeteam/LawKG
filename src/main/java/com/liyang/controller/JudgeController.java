package com.liyang.controller;


import com.liyang.entity.Judge;
import com.liyang.service.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/judge")
public class JudgeController {
    @Autowired
    JudgeService judgeService;

    @GetMapping("/getInfo")
    public Judge getInfo(@RequestParam String name){
        return judgeService.getInfo(name);
    }

    @PostMapping("/insert")
    public HashMap<String,Integer> insertNew(Judge judge) {
        HashMap<String,Integer> hm = new HashMap<>();
        int result = judgeService.insertNew(judge);
        if (result != 0){
            hm.put("code",1);
        }else {
            hm.put("code",0);
        }
        return hm;
    }

}
