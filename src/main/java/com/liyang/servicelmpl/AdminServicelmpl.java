package com.liyang.servicelmpl;

import com.liyang.entity.Admin;
import com.liyang.mapper.AdminMapper;
import com.liyang.service.AdminService;
import com.liyang.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminServicelmpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    private final static int pageCount = 10;
    private DateUtil dateUtil = new DateUtil();

    @Override
    public Admin sel(int adminID) {
        return adminMapper.sel(adminID);
    }

    @Override
    public Admin login(String loginName, String passwordMD5) {

        return adminMapper.login(loginName,passwordMD5);
    }

    @Override
    public void loginTime(String loginName, Date lastLoginTime) {

        adminMapper.loginTime(loginName, lastLoginTime);
    }

    @Override
    public Admin isRepeat(String loginName) {

        return adminMapper.isRepeat(loginName);
    }

    @Override
    public int register(Admin admin)  {

        return adminMapper.register(admin);
    }

    @Override
    public int changePSW( int adminID, String passwordMD5,String newPasswordMD5) {
        return adminMapper.changePSW(adminID, passwordMD5,newPasswordMD5);
    }

    @Override
    public int changeInfo(Admin admin) {

        return adminMapper.changeInfo(admin);
    }

    @Override
    public Admin getInfo(int adminID) {
        return adminMapper.getInfo(adminID);
    }

    @Override
    public List<Admin> getList(int page) {
        int start = pageCount * (page-1);
        int num =pageCount;
        List<Admin> result = adminMapper.getList(start,num);
        return result;
    }
}
