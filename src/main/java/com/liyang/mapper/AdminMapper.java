package com.liyang.mapper;
import com.liyang.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface AdminMapper {
    Admin sel(int AdminID);
    Admin login(@Param("loginName") String loginName, @Param("passwordMD5") String passwordMD5);
    void loginTime(@Param("loginName") String loginName, @Param("lastLoginTime") Date lastLoginTime);
    Admin isRepeat(String loginName);
    int register(Admin Admin);
    int changePSW(@Param("AdminID") int AdminID, @Param("passwordMD5") String passwordMD5, @Param("newPasswordMD5") String newPasswordMD5);
    int changeInfo(Admin Admin);
    Admin getInfo(int adminID);
    List<Admin> getList(@Param("start") int start, @Param("num") int num);
}
