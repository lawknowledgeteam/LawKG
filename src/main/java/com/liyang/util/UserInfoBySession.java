package com.liyang.util;



import com.liyang.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Pan
 * @Date: 2019/7/4 12:21
 * @Description:
 **/
public class UserInfoBySession {

    public User showInfoBySession(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("session_user");
        user.setPassWord(null);
        // System.out.println(user.getUserId());
        return user;
    }

}
