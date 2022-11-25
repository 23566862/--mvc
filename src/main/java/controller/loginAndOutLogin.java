package controller;

import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.user;
import service.userServiceImp;
import util.Constant;

import javax.servlet.http.HttpSession;

@Controller
public class loginAndOutLogin {
    @Autowired
    userServiceImp userServiceImp;

    /*
    * param: userCode  前端表单值
    * param: userPassword 前端表单值
    * param: session
    * param: model
    *获取前端参数调用service层获取数据库数据判断
    * true： 查询值存放session，跳转主页面
    * false： 给前端提示登入失败消息
    * */
    @PostMapping("/login.do")
    public String toLogin(String userCode, String userPassword, HttpSession session, Model model){
            user user = userServiceImp.getLoginUser(userCode, userPassword);
            if (user !=null){
                session.setAttribute(Constant.LoginUser,user);
                return "WEB-INF/jsp/frame";
            }else {
                model.addAttribute("error","用户名或密码错误");
                return "login";
            }
        }

        /*
        * 退出登入
        * 移除session
        * */
    @RequestMapping("/logout.do")
    public String outLogin(HttpSession session){
        session.removeAttribute(Constant.LoginUser);
        return "login";
    }
}
