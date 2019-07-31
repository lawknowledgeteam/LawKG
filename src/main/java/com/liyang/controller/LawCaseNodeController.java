package com.liyang.controller;

import com.liyang.entity.ObjectNodeRelation;
import com.liyang.entity.node.CaseKindNode;
import com.liyang.entity.node.LawCaseNode;
import com.liyang.service.LawCaseNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
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

    @RequestMapping("/getInfoRelation")
    List<ObjectNodeRelation> getInfoRelation(@RequestParam int caseId){
        return lawCaseNodeService.getInfoRelation(caseId);
    }

    @RequestMapping("/getInfo")
    HashMap<String,Object> getInfo(@RequestParam String caseId){
        return lawCaseNodeService.getInfo(caseId);
    }

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

    @GetMapping("/getSame")
    public List<LawCaseNode> getSame(@RequestParam String caseId,@RequestParam int page) {

        return lawCaseNodeService.getSame(caseId, page);
    }

    @GetMapping("/getKind")
    public CaseKindNode getKind(@RequestParam String caseId) {
        return lawCaseNodeService.getKind(caseId);
    }

}
