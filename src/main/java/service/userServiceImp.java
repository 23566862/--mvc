package service;

import dao.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.user;

import java.util.List;

public class userServiceImp implements userService {

    private userMapper userMapper;
    public void setUserMapper(dao.userMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<user> getUser() {
        return userMapper.getUser();
    }

    public user getLoginUser(String userCode, String userPassword) {
        return userMapper.getLoginUser(userCode,userPassword);
    }

    public int updatePassword(int id, String newPassword) {
        return userMapper.updatePassword(id,newPassword);
    }

    public int userCount(String userName, int userRole) {
        return userMapper.userCount(userName,userRole);
    }

    public List<user> getUserList(String userName, int userRole, int currentPageNo, int pageSize) {
        return userMapper.getUserList(userName, userRole, currentPageNo, pageSize);
    }

    public user getIsCodeUser(String userCode) {
        return userMapper.getIsCodeUser(userCode);
    }
}
