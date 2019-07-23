package com.liyang.service;

import com.liyang.entity.Admin;

import java.util.Date;
import java.util.List;

public interface AdminService {
    Admin sel(int adminID);
    Admin login(String loginName, String passwordMD5);
    void loginTime(String loginName, Date lastLoginTime);
    Admin isRepeat(String loginName);
    int register(Admin admin);
    int changePSW(int adminID, String newPassword, String password);
    int changeInfo(Admin admin);
    Admin getInfo(int adminID);
    List<Admin> getList(int page);
}
