package dao;

import org.apache.ibatis.annotations.Param;
import pojo.user;

import java.util.List;

public interface userMapper {

    /*用户登入*/
   user getLoginUser(@Param("userCode") String userCode, @Param("userPassword")String userPassword);
   /*修改密码*/
    int updatePassword(@Param("id") int id,@Param("newPassword") String newPassword);
  /*查询用户总数*/
    int userCount(@Param("userName")String userName ,@Param("userRole") int userRole);

   List<user> getUser();

   /*获取user列表*/
    List<user> getUserList(@Param("userName")String userName,@Param("userRole")int userRole, @Param("currentPageNo") int currentPageNo,
                           @Param("pageSize") int pageSize);
    /*根据用户编码查询*/
    user getIsCodeUser(@Param("userCode") String userCode);
}
