package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*角色，管理者*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class role {
    private Integer id;
    private String roleCode;//管理者编码
    private String roleName;//角色编码
    private Integer createdBy;//创建者
    private Date creatDate;//创建时间
    private Integer modifyBy;//更新者
    private Date modifyDate;//更新时间

}
