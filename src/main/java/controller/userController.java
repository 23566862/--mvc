package controller;

import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.role;
import pojo.user;
import service.roleServiceImp;
import service.userServiceImp;
import util.Constant;
import util.PageSupport;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class userController {
    @Autowired
    userServiceImp userServiceImp;
    @Autowired
    roleServiceImp roleServiceImp;
    @Autowired
    PageSupport pageSupport;
    /*
    跳转修改密码界面
    */
    @RequestMapping("/updatePsword.do")
    public String intoUpdate(){
        return "WEB-INF/jsp/pwdmodify";
    }

    /*
    * 前端界面ajax异步刷新判断当前密码是否输入正确
    * param oldpassword 前端文本框输入值
    * param session   获得当前登入用户session
    * 返回json格式字符串前端js的ajax判断
    * */
    @GetMapping ("/jsp/user.do")
    @ResponseBody
    public String ajaxRepsonse(String oldpassword , HttpSession session){
        System.out.println("ajaxRepsonse执行了");
        user user = (user)session.getAttribute(Constant.LoginUser);
        HashMap<String, String> map = new HashMap<String, String>();
        if (user ==null){
            map.put("result","sessionerror");
        }else if (StringUtils.isNullOrEmpty(oldpassword)){
            map.put("result","error");
        }else{
            if (!oldpassword.equals(user.getUserPassword())){
                map.put("result","false");
            }else{
                map.put("result","true");
            }
        }
            return JSONArray.toJSONString(map);
    }


    /*
    * 修改密码功能：
    * true：调用dao层删除数据库数据,并且删除session，重定向到首页
    * false：给前端提示消息
    * */
    @PostMapping("/update.do")
    public String update(String newpassword , HttpSession session, Model model){
        user user = (user)session.getAttribute(Constant.LoginUser);
        if (user != null){
            int i = userServiceImp.updatePassword(user.getId(), newpassword);
            if (i<0){
                model.addAttribute("message","密码修改失败");
            }else                   {
                model.addAttribute("message","密码修改成功请退出登入后重试！");
                session.removeAttribute(Constant.LoginUser);
                return "redirect:login";
            }
        }
        return "/WEB-INF/jsp/pwdmodify";
    }

    /*
    * 用户管理：
    * pram queryname 前端要查询的用户名,模糊查询
    * pram queryUserRole 前端下拉框要查询的角色
    * pram pageIndex   当前页的下标
    * 需求考虑：
    * 1 用户第一次请求，需要设置默认值查询数据
    * 2 需要分页查询，需要 数据总数  每页要显示的个数 总的页数
    *
    * */

    @RequestMapping("/userList")
    public String userList(String queryname,String queryUserRole,String pageIndex,Model model){
        //用户第一次请求默认值
        int userRole=0; //用户角色为0
         int pagNo=1; //页码从1开始
        //查询条件为 用户名和（int类型）角色
        if (queryname ==null){
            queryname="";
        }
        if (queryUserRole !=null){
            userRole=Integer.valueOf(queryUserRole);
        }
        if (pageIndex !=null){
            pagNo=Integer.valueOf(pageIndex);
        }

        //根据条件查询数据数量
        int totalCount = userServiceImp.userCount(queryname, userRole);


        pageSupport.setCurrentPageNo(pagNo);
        pageSupport.setPageSize(5); //每页显示5条数据
        pageSupport.setTotalCount(totalCount); //工具类设置总数
        int totalPageCount = pageSupport.getTotalPageCount(); //算出需要的页数  总页数/每页数据

        //控制当前页越界处理
        if (pagNo<1){
            pagNo=1;
        }else if (pagNo>totalPageCount){
            pagNo=totalPageCount;
        }

        //获取下拉框角色列表
        List<role> roleList = roleServiceImp.getRoleList();
        System.out.println("user:"+queryname+","+userRole);
        List<user> userList = userServiceImp.getUserList(queryname, userRole, (pagNo - 1) * 5, 5);
        //返回给前端值
        model.addAttribute("roleList",roleList);
        model.addAttribute("userList",userList);
        model.addAttribute("totalPageCount",totalPageCount);
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("currentPageNo",pagNo);
        model.addAttribute("queryUserName",queryname);

        return "/WEB-INF/jsp/userlist";
    }


    /*
    * 跳转用户修改界面
    * */
    @RequestMapping("/add.do")
    public String addView(){
        return "/WEB-INF/jsp/useradd";
    }



    /*判断add页面usercode是否存在*/
    @GetMapping("/ucexist")
    @ResponseBody
    public String isFromat(String userCode){
        System.out.println("isFromat执行了");
        HashMap<String, String> map = new HashMap<String, String>();
        if (StringUtils.isNullOrEmpty(userCode)){
            map.put("userCode","exist");
        }else{
            user user = userServiceImp.getIsCodeUser(userCode);
            if (user !=null){
                map.put("userCode","exist");
            }else{
                map.put("userCode", "notexist");
            }
        }
        return JSONArray.toJSONString(map);
    }

    /*判断add页面usercode是否存在*/
    @GetMapping("/getrolelist")
    @ResponseBody
    public String getRoleList(){
        System.out.println("getRoleList执行了");
        List<role> roleList = roleServiceImp.getRoleList();
        return JSONArray.toJSONString(roleList);
    }

}
