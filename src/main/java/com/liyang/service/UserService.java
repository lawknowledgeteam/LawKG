package com.liyang.service;


import com.liyang.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @Author: Xiao
 * @Date:
 * @Description:
 **/
public interface UserService {
    User sel(int UserID);
    User login(String loginName, String passWord);
    void loginTime(String loginName, Date lastLoginTime);
    User isRepeat(String loginName);
    int register(User user);
    int changePSW(int userID, String newPassWord, String passWord);
    int changeInfo(User user);
    User getInfo(int userID);
    List<User> getList(int page);
    public User showInfoBySession(HttpServletRequest request, HttpServletResponse response);
}
