package com.liyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Pan
 * @Date: 2019/7/21 20:24
 * @Description:
 **/
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("index")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("entity")
    public String showEntity(){
        return "entity";
    }

}
