package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*用户*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class user {
    private Integer id;
    private String userCode;//用户编码
    private String userName;//姓名
    private String userPassword;//用户密码
    private Integer gender;//性别
    private Date birthday;//生日
    private String phone;//电话
    private String address;//地址
    private Integer userRole;//用户角色
    private Integer createBy;//创建者
    private Date createDate;//创建时间
    private Integer modifyBy;//更新者
    private Date modifyDate;//更新时间


    private Integer age;//年龄

    private String userRoleName;    //用户角色名称

    /*获取用户当前年龄*/
    public Integer getAge() {
        Date date = new Date();
        Integer age = date.getYear() - birthday.getYear();
        return age;
    }

}
