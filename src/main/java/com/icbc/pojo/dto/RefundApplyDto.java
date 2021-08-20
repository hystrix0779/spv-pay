package com.icbc.pojo.dto;

import com.icbc.pojo.In;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * <p>退款申请</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class RefundApplyDto extends Common{
    /**
     *  二级商户编号
     */
    private  String subMerId;
    /**
     * 退款流水号 每次退款交易唯一
     */
    @NotNull(message="serialNo-退款流水号")
    private  String serialNo;
    /**
     *  用户编号
     */
    @NotNull(message="userId-用户编号")
    private  String userId;
    /**
     * 用户角色 1-买家；2-卖家；0-平台；连锁店模式只支持买家发起
     */
    @NotNull(message="roleType-用户角色")
    private  Integer roleType;
    /**
     * 订单编号 下单时送的订单号
     */
    @NotNull(message="orderNo-订单编号")
    private  String orderNo;

    /**
     * 退款金额 买家或平台必输，卖家以买家传入时为准
     */
    private  BigDecimal amount;
    /**
     * 摘要
     */
    private  String summary;
    /**
     * 退款理由
     */
    @NotNull(message="refundReason-退款理由")
    private String refundReason;
    /**
     *  管家卡号 连锁店模式必输、中介模式平台发起支付必输
     */
    private  String manageCardNo;
    /**
     * 0-拒绝 1-通过  连锁店短信确认模式时，卖家发起时必输
     */
    @XStreamAlias("Status")
    private String status;

    @Override
    public In createIn(){
        super.validObj(this);
        return  In.builder().
                subMerId(this.subMerId).
                serialNo(this.serialNo).
                userId(this.userId).
                roleType(this.roleType).
                orderNo(this.orderNo).
                amount(this.amount).
                summary(this.summary).
                refundReason(this.refundReason).
                manageCardNo(this.manageCardNo).
                status(this.status).
                refundType(this.roleType).
            build();
    }
}
