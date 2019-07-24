package com.liyang.controller;

import com.liyang.entity.ObjectNodeRelation;
import com.liyang.entity.node.LawNode;
import com.liyang.entity.relations.LawLawType;
import com.liyang.service.LawNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/22 9:37
 * @Description:
 **/

@RestController
@RequestMapping("/lawGraph")
public class LawNodeController {
    @Autowired
    LawNodeService lawNodeService;

    @GetMapping("/getLawNode")
    public List<LawNode> getLawNode(@RequestParam int page){
        return lawNodeService.getLawNode(page);
    }

    @GetMapping("/getLawNodeByName")
    List<LawNode> getLawNodeByName(@RequestParam String lawName,@RequestParam int page){
        return lawNodeService.getLawNodeByName(lawName, page);
    }

    @GetMapping("/getLawNodeById")
    List<LawNode> getLawNodeById(@RequestParam int id,@RequestParam int page){
        return lawNodeService.getLawNodeById(id, page);
    }

    @GetMapping("/getLawLawTypeId")
    public List<ObjectNodeRelation> getLawLawTypeId(@RequestParam String id,@RequestParam int page) {
        return lawNodeService.getLawLawTypeId(id, page);
    }

}
