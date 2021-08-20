package com.icbc.pojo.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * <p>退款申请</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class RefundApply{
    /**
     *  二级商户编号
     */
    private  String subMerId;
    /**
     * 退款流水号
     */
    private  String serialNo;
    /**
     *  用户编号
     */
    private  String userId;
    /**
     * 用户角色 1-买家 0-平台
     */
    private  Integer roleType;
    /**
     * 订单编号 中介模式下需与订单提交接口对应
     */
    private  String orderNo;

    /**
     * 支付金额 支付尾款时必输，支付定金时无效（以订单下单时送的定金金额为准）
     */
    private  BigDecimal amount;
    /**
     * 摘要
     */
    private  String summary;
    /**
     * 退款理由
     */
    private String refundReason;
    /**
     *  管家卡号 连锁店模式必输、中介模式平台发起支付必输
     */
    private  String manageCardNo;
    /**
     * 退款状态 中介模式返回 0-待确认2-已确认
     */
    private String result;
    /**
     * 订单支付信息
     */
    private String retMsg;
    /**
     * 退款结果 00-待退款 01-退款中 02-退款成功 03-退款失败
     */
    private String status;

}
