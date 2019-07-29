package com.liyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Pan
 * @Date: 2019/7/21 20:24
 * @Description:
 **/
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("login")
    public String showLogin(){
        return "/web_pc/login";
    }

    @RequestMapping("register")
    public String showRegister(){
        return "/web_pc/register";
    }

    @RequestMapping("index")
    public String showIndex(){
        return "/web_pc/index";
    }

    @RequestMapping("result")
    public String showResult(@RequestParam String caseId){
        return "/web_pc/result";
    }

}
