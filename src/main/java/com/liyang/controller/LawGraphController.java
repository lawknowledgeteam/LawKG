package com.liyang.controller;

import com.liyang.entity.ObjectNodeRelation;
import com.liyang.entity.relations.LawLawType;
import com.liyang.repository.LawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/22 9:37
 * @Description:
 **/
@RestController
@RequestMapping("/")
public class LawGraphController {
    @Autowired
    LawRepository lawRepository;

    @GetMapping("/get")
    Iterable<ObjectNodeRelation> get(){
        return lawRepository.getdas();
    }
}
