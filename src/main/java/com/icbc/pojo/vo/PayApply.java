package com.icbc.pojo.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>订单支付申请</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class PayApply {
    /**
     *  二级商户编号
     */
    private  String subMerId;
    /**
     * 订单支付流水号
     */
    private String serialNo;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 订单支付申请 1-买家；0-平台
     */
    private Integer roleType;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 订单支付申请 0-定金；1-尾款
     */
    private String orderType;
    /**
     * 支付金额
     */
    private String amount;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 缴存管家卡号
     */
    private String manageCardNo;
    /**
     * 订单支付申请 中介模式返回 0-待确认2-已确认
     */
    private String result;
    /**
     * 订单支付信息
     */
    private String retMsg;
    /**
     * 订单支付申请 00-待支付 01-支付中 02-支付成功 03-支付失败
     */
    private String status;
}
