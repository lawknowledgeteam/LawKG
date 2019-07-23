package com.liyang.controller;

import com.liyang.entity.Lawyer;
import com.liyang.service.LawyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/lawyer")
public class LawyerController {
    @Autowired
    LawyerService lawyerService;

    @GetMapping("/getList")
    public List<Lawyer> getList(@RequestParam int page){
        return lawyerService.getList(page);
    }

    @PostMapping("/insert")//抱错7.22
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

    @PostMapping("/delete")
    public int del(@RequestParam int lawyerID){
        return lawyerService.del(lawyerID);
    }


}
