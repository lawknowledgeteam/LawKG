package com.liyang.lawknowledge.lawknowledge.mapper;


import com.liyang.lawknowledge.lawknowledge.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/2 20:35
 * @Description:
 **/
@Repository
public interface UserMapper {
    User sel(int userID);
    User login(@Param("loginName") String loginName, @Param("passWord") String passWord);
    void loginTime(@Param("loginName") String loginName, @Param("lastLoginTime") Date lastLoginTime);
    User isRepeat(String loginName);
    int register(User user);
    int changePSW(@Param("userID") int userID, @Param("passWord") String passWord, @Param("newPassWord") String newPassWord);
    int changeInfo(User user);
    User getInfo(int userID);
    List<User> getList(@Param("start") int start, @Param("num") int num);

}
