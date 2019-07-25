package com.liyang.controller;

import com.liyang.entity.ObjectNodeRelation;
import com.liyang.service.LawCaseNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/25 9:51
 * @Description:
 **/
@RestController
@RequestMapping("/LawCaseNode")
public class LawCaseNodeController {
    @Autowired
    LawCaseNodeService lawCaseNodeService;

    @RequestMapping("/searchByName")
    List<ObjectNodeRelation> searchByName(@RequestParam String name, @RequestParam int page){
        return lawCaseNodeService.searchByName(name, page);
    }

    @RequestMapping("/searchSameKind")
    List<ObjectNodeRelation>  searchSameKind(@RequestParam String name, @RequestParam int page){
        return lawCaseNodeService.searchSameKind(name, page);
    }

    @RequestMapping("/searchSameCourt")
    List<ObjectNodeRelation>  searchSameCourt(@RequestParam String name, @RequestParam int page){
        return lawCaseNodeService.searchSameCourt(name, page);
    }

    @RequestMapping("/searchCommon")
    List<ObjectNodeRelation>  searchCommon(@RequestParam String name, @RequestParam int page) {
        List<ObjectNodeRelation> list = new ArrayList<>();
        list.addAll(lawCaseNodeService.searchByName(name, page));
        list.addAll(lawCaseNodeService.searchSameKind(name, page));
        list.addAll(lawCaseNodeService.searchSameCourt(name, page));
        return list;
    }
}
