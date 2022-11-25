package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/*订单表*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class bill {
    private Integer id;
    private String billCode;//订单编码
    private String productName;//商品名称
    private String productDesc;//商品描述
    private String productUnit;//商品单位
    private BigDecimal productCount;//商品个数
    private BigDecimal totalPrice;//总金额
    private Integer isPayment;//是否支付
    private Integer createBy;//是否支付
    private Date creationDate;//创建时间
    private Integer modifyBy;//更新者
    private Date modifyDate;//更新时间
    private Integer providerId;//供应商id

    private String providerName;//供应商名称

}
