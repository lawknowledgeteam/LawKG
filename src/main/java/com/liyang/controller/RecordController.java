package com.liyang.controller;

import com.liyang.entity.Record;
import com.liyang.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    RecordService recordService;

    @GetMapping("/getList")
    public List<Record> getList(@RequestParam int page,@RequestParam int userID){
        return recordService.getList(page,userID);
    }

    @GetMapping("/getTotalList")
    public List<Record> getTotalList(@RequestParam int page,@RequestParam int userID){
        return recordService.getTotalList(page,userID);
    }

    @PostMapping("/update")
    public HashMap<String,Integer> insertNew(Record record) {
        HashMap<String,Integer> hm = new HashMap<>();
        int result = recordService.insertNew(record);
        if (result != 0){
            hm.put("code",1);
        }else {
            hm.put("code",0);
        }
        return hm;
    }
}
