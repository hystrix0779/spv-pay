package com.icbc.pojo.dto;

import com.icbc.pojo.In;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * <p>订单提交</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class OrderSubmitDto extends Common{
    /**
     *  二级商户编号
     */
    private  String subMerId="";
    /**
     * 用户编号(买家)
     */
    @NotNull(message="buyerId-用户编号(买家)")
    private  String buyerId;
    /**
     * 用户编号(卖家)
     */
    @NotNull(message="sellerId-用户编号(卖家)")
    private  String sellerId;
    /**
     * 企业订单编号
     */
    @NotNull(message="orderNo-企业订单编号")
    private  String orderNo;
    /**
     * 尾款金额
     */
    @NotNull(message="balance-尾款金额")
    private  BigDecimal balance;
    /**
     * 定金金额(定金金额后续只能整笔支付或退款)
     */
    @NotNull(message="earnest-定金金额")
    private  BigDecimal earnest;
    /**
     * 手续费金额(无需手续费则送0，当前版本暂不支持扣手续费)
     */
    @NotNull(message="fee-手续费金额")
    private  BigDecimal fee;
    /**
     * 商品信息
     */
    private  String goodsInfo;
    /**
     * 摘要
     */
    private  String summary;

    @Override
    public In createIn(){
        super.validObj(this);
        return  In.builder().
                subMerId(this.subMerId).
                buyerId(this.buyerId).
                sellerId(this.sellerId).
                orderNo(this.orderNo).
                balance(this.balance).
                earnest(this.earnest).
                fee(this.fee).
                goodsInfo(this.goodsInfo).
                summary(this.summary).
            build();
    }
}
