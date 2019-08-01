package com.liyang.controller;


import com.liyang.entity.User;
import com.liyang.service.UserService;
import com.liyang.util.DateUtil;
import com.liyang.util.FileUpload;
import com.liyang.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        String passWord = MD5Util.md5(user.getPassWord());
        User chuser = userService.login(loginName,passWord);
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
            System.out.println(hm);
            return  hm;
        }
    }

    @PostMapping("/register")
    public  HashMap<String,Object> register(User user, String sign)  {
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
    public HashMap<String,Integer> outLogin (HttpServletRequest request){
        HashMap<String,Integer> hm = new HashMap<>();
        request.getSession().removeAttribute("session_user");
        hm.put("code",1);
        return hm;
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
    /*@GetMapping("/getUser")
    public User showInfoBySession(HttpServletRequest request, HttpServletResponse response){

        return userService.showInfoBySession(request,response);
    }*/

}

