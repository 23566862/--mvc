package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*供应商类*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Provider {
    private Integer id;
    private String proCode;//供应商编码
    private String proName;//供应商name
    private String proDesc;//供应商描述
    private String proContact;//供应商联系人
    private String proPhone;//供应商电话
    private String proAddress;//供应商地址
    private String proFax;//供应商传真
    private Integer createdBY;//创建者
    private Date createdDate;//创建时间
    private Date modifyDate;//更新时间
    private Integer modifyBY;//更新者


}
