package com.liyang.controller;

import com.liyang.service.QascriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/10/27 17:15
 * @Description:
 **/
@RestController
@RequestMapping("/Qascript")
public class QascriptController {
    @Autowired
    QascriptService qascriptService;

    @GetMapping("/getQaResult")
    public List<String> getQaResult(@RequestParam String question){
        return  qascriptService.getQaResult(question);
    }

}
