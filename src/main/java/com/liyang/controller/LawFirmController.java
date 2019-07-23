package com.liyang.controller;

import com.liyang.entity.LawFirm;
import com.liyang.service.LawFirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/lawFirm")
public class LawFirmController {
    @Autowired
    LawFirmService lawFirmService;

    @GetMapping("/getCount")
    public HashMap<String,Integer> getCount(){
        return lawFirmService.getCount();
    }

    @GetMapping("/getList")
    public List<LawFirm> getList(@RequestParam int page){
        return lawFirmService.getList(page);
    }

    @GetMapping("/getLaw")
    public LawFirm getLawFirm(@RequestParam int lawFirmID){
        return lawFirmService.getLawFirm(lawFirmID);
    }

    @PostMapping("/insert")
    public HashMap<String,Integer> insertNew(LawFirm lawFirm) {
        HashMap<String,Integer> hm = new HashMap<>();
        int result = lawFirmService.insertNew(lawFirm);
        if (result != 0){
            hm.put("code",1);
        }else {
            hm.put("code",0);
        }
        return hm;
    }

}
