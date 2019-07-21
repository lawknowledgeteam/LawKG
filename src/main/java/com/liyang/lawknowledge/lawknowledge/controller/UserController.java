package com.liyang.lawknowledge.lawknowledge.controller;


import com.liyang.lawknowledge.lawknowledge.entity.User;
import com.liyang.lawknowledge.lawknowledge.service.UserService;
import com.liyang.lawknowledge.lawknowledge.util.DateUtil;
import com.liyang.lawknowledge.lawknowledge.util.FileUpload;
import com.liyang.lawknowledge.lawknowledge.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    private static final String key = "wasd";
    private DateUtil dateUtil = new DateUtil();
    @GetMapping("/toLogin")
    public String toLogin() {
        String message = "请求非法，请登录后在尝试";
        return message;
    }

    @PostMapping("/login")
    public HashMap<String,Object> loginCheck(User user, HttpServletRequest request, String sign) {
        HashMap<String,Object> hm = new HashMap<>();
        if (!key.equals(sign)){
            hm.put("code",-1);
            return  hm;
        }
        String loginName = user.getLoginName();
        String password = MD5Util.md5(user.getPassWord());
        User chuser = userService.login(loginName,password);
        if(chuser == null ){
            hm.put("code",0);
            return  hm;
        }else {
            Date time = new Date();
            userService.loginTime(loginName,time);
            chuser.setLastLoginTime(time);
            System.out.println(time);
            HttpSession session = request.getSession();
            session.setAttribute("session_user",chuser);
            session.setMaxInactiveInterval(-1);
            hm.put("code",1);
            hm.put("user",chuser);
            return  hm;
        }
    }

    @PostMapping("/resgister")
    public  HashMap<String,Object> resgister(User user, String sign)  {
        HashMap<String,Object> hm = new HashMap<>();
        if (!key.equals(sign)){
            hm.put("code",-1);
            return  hm;
        }
        if(user.getLoginName() == null
                ||user.getPassWord() == null
                ||userService.isRepeat(user.getLoginName()) != null ){
            hm.put("code",0);
            return  hm;
        }else{
            user.setPassWord(MD5Util.md5(user.getPassWord()));
            user.setRegisterTime(new Date());

            int u = userService.register(user);
            hm.put("code",1);
            hm.put("user",user);
            return  hm;
        }
    }

    @PostMapping("/outLogin")
    public int outLogin (HttpServletRequest request, String sign){
        if (!key.equals(sign)){
            return  -1;
        }
        request.getSession().removeAttribute("session_user");
        return 1;
    }

    @PostMapping("/ChangePSW")
    public HashMap<String,Integer> changePSW(int userID,String lastPassWord,String newPassWord){
        int result = userService.changePSW(userID,MD5Util.md5(lastPassWord),MD5Util.md5(newPassWord));
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("code",result);
        return hm;
    }

    @PostMapping("/ChangeInfo")
    public HashMap<String,Integer> changeInfo(User user){
        int sex = user.getSex();
        if (sex<0||sex>2){
            user.setSex(0);
        }
        int result = userService.changeInfo(user);
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("code",result);
        return hm;
    }

    @GetMapping("/Info")
    public HashMap<String,Object> getInfo(int userID) {
        User result = userService.getInfo(userID);
        HashMap<String,Object> hm = new HashMap<>();
        if (result == null){
            hm.put("code",0);
        }else {
            hm.put("code",1);
            hm.put("user",result);
        }
        return hm;
    }

    @PostMapping("uploadHeadImg")
    public HashMap<String,Object> upload(MultipartFile fileUpload){
        FileUpload fud = new FileUpload();
        return fud.addFile(fileUpload,"/auvres/user/");
    }

    @GetMapping("/getPageList")
    public List<User> getPageList(@RequestParam int page){
        List<User> result = userService.getList(page);
        return result;
    }
//
//    @GetMapping("/getCount")
//    public int getCount(){
//        return userService.getCount();
//    }

}

