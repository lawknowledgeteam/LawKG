package com.liyang.servicelmpl;


import com.liyang.entity.User;
import com.liyang.mapper.UserMapper;
import com.liyang.service.UserService;
import com.liyang.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/2 20:41
 * @Description:
 **/
@Service
public class UserServicelmpl implements UserService {
   @Autowired
   UserMapper userMapper;
    private final static int pageCount = 10;
    private DateUtil dateUtil = new DateUtil();
    @Override
    public User sel(int userID) {
        return userMapper.sel(userID);
    }

    @Override
    public User login(String loginName, String passWord) {

        return userMapper.login(loginName,passWord);
    }

    @Override
    public void loginTime(String loginName, Date lastLoginTime) {

         userMapper.loginTime(loginName, lastLoginTime);
    }

    @Override
    public User isRepeat(String loginName) {

        return userMapper.isRepeat(loginName);
    }

    @Override
    public int register(User user)  {

        return userMapper.register(user);
    }

    @Override
    public int changePSW( int userID, String lastPassWord,String newPassWord) {
        return userMapper.changePSW(userID, lastPassWord,newPassWord);
    }

    @Override
    public int changeInfo(User user) {

        return userMapper.changeInfo(user);
    }

    @Override
    public User getInfo(int userID) {
        return userMapper.getInfo(userID);
    }

    @Override
    public List<User> getList(int page) {
        int start = pageCount * (page-1);
        int num =pageCount;
        List<User> result = userMapper.getList(start,num);
        return result;
    }

    @Override
    public User showInfoBySession(HttpServletRequest request, HttpServletResponse response) {

        User user = (User) request.getSession().getAttribute("session_user");
        user.setPassWord(null);
        // System.out.println(user.getUserId());
        return user;
    }


}
