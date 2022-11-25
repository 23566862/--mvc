package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*地址*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class address {
    private Integer id;
    private String coutact;//联系
    private String addressDesc;//地址描述
    private String postCode;//邮政编码
    private String tel;//清单
    private Integer createdBy;//创建者
    private Date creationDate;//创建时间
    private Integer modifyBY;//更新者
    private Date modifyDate;//更新时间
    private Integer userId;//用户id

}
