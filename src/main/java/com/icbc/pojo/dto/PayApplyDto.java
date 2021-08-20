package com.icbc.pojo.dto;

import com.icbc.pojo.In;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * <p>订单支付申请</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class PayApplyDto extends Common{
    /**
     *  二级商户编号
     */
    private  String subMerId;
    /**
     * 订单支付流水号 唯一
     */
    @NotNull(message="serialNo-订单支付流水号")
    private  String serialNo;
    /**
     *  用户编号
     */
    @NotNull(message="userId-用户编号")
    private  String userId;
    /**
     * 用户角色 1-买家 0-平台
     */
    @NotNull(message="roleType-用户角色")
    private  Integer roleType;
    /**
     * 订单编号 中介模式下需与订单提交接口对应
     */
    @NotNull(message="orderNo-订单编号")
    private  String orderNo;
    /**
     *  操作类型 0-定金；1-尾款（连锁店模式默认1）
     */
    private  Integer orderType;
    /**
     * 支付金额 支付尾款时必输，支付定金时无效（以订单下单时送的定金金额为准）
     */
    private  BigDecimal amount;
    /**
     * 摘要
     */
    private  String summary;
    /**
     *  管家卡号 连锁店模式必输、中介模式平台发起支付必输
     */
    private  String manageCardNo;

    @Override
    public In createIn(){
        super.validObj(this);
        return  In.builder().
                subMerId(this.subMerId).
                serialNo(this.serialNo).
                userId(this.userId).
                roleType(this.roleType).
                orderNo(this.orderNo).
                orderType(this.orderType).
                amount(this.amount).
                summary(this.summary).
                manageCardNo(this.manageCardNo).
            build();
    }
}
