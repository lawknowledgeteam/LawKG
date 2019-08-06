package com.liyang.controller;

import com.liyang.entity.ObjectNodeRelation;
import com.liyang.entity.node.CaseKindNode;
import com.liyang.entity.node.Defendant;
import com.liyang.entity.node.LawCaseNode;
import com.liyang.entity.node.Prosecutor;
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

    @GetMapping("/getDefendant")
    public List<Defendant> getDefendant(String caseId) {
        return lawCaseNodeService.getDefendant(caseId);
    }

    @GetMapping("/getProsecutor")
    public List<Prosecutor> getProsecutor(String caseId) {
        return lawCaseNodeService.getProsecutor(caseId);
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
        if (list.isEmpty()){
            list.addAll(lawCaseNodeService.getCaseByKind(name,page));
        }
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

    @GetMapping("getNewCase")
    public List<LawCaseNode> getNewCase(@RequestParam int page) {
        return lawCaseNodeService.getNewCase(page);
    }
    @GetMapping("getCaseByid")
    public LawCaseNode getCaseByid(@RequestParam String caseId ) {
        return lawCaseNodeService.getCaseByid(caseId);
    }

    @GetMapping("getCaseByKind")
    public List<LawCaseNode> getCaseByKind(@RequestParam String caseKind,@RequestParam int page) {
        return lawCaseNodeService.getCaseByKind(caseKind, page);
    }

    @GetMapping("getRecommandCase")
    public List<LawCaseNode> getRecommandCase(@RequestParam int userId,@RequestParam int page) {
        return lawCaseNodeService.getRecommandCase(userId,page);
    }
}
