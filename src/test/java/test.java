import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.role;
import pojo.user;
import service.roleServiceImp;
import service.userServiceImp;

import java.net.Socket;
import java.util.*;

public class test  {

    static class  test1{

    }



    public static void main(String[] args) {
        String str="";
        System.out.println(str.length());
    }


    @Test
    public void sda(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        userServiceImp userServiceImp = context.getBean("BookServiceImp", userServiceImp.class);
        user userList = userServiceImp.getIsCodeUser("admin");
        System.out.println(userList);
    }

    @Test
    public void sda1(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        roleServiceImp roleServiceImp = context.getBean("roleServiceImp", roleServiceImp.class);
        List<role> roleList = roleServiceImp.getRoleList();
        for (role role : roleList) {
            System.out.println(role);
        }
    }
}
