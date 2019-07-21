package com.liyang.lawknowledge.lawknowledge.service;


import com.liyang.lawknowledge.lawknowledge.entity.User;

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
}
