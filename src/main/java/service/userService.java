package service;
import org.apache.ibatis.annotations.Param;
import pojo.user;

import java.util.List;

public interface userService {
    List<user> getUser();
    //获得当前登入的用户
    user getLoginUser(String userCode,String userPassword);
    //根据id修改当前登入用户密码
    int updatePassword( int id, String newPassword);
    /*查询用户总数*/
    int userCount(String userName ,int userRole);
    List<user> getUserList(String userName,int userRole,int currentPageNo, int pageSize);
    /*根据用户编码查询*/
    user getIsCodeUser( String userCode);
}
