package com.liyang.controller;


import com.liyang.entity.LawItem;
import com.liyang.service.LawItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/lawitem")
public class LawItemController {

    @Autowired
    LawItemService lawItemService;

    @GetMapping("/getList")
    public List<LawItem> getList(@RequestParam int page) {
        return lawItemService.getList(page);
    }

    @GetMapping("/getLawItem")
    public LawItem getLawItem(@RequestParam int lawItemID){
        return lawItemService.getLawItem(lawItemID);
    }

    @GetMapping("/getCount")
    public HashMap<String, Integer> getCount() {

        return  lawItemService.getCount();
    }


}
