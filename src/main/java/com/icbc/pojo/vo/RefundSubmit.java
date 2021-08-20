package com.icbc.pojo.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * <p>退款确认</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class RefundSubmit {
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
     * 订单编号
     */
    private  String orderNo;

    /**
     * 退款金额
     */
    private  BigDecimal amount;
    /**
     * 摘要
     */
    private  String summary;
    /**
     * 退款结果  0-待确认2-已确认
     */
    private String result;
    /**
     * 退款结果信息
     */
    private String retMsg;
    /**
     * 退款结果 00-待退款 01-退款中 02-退款成功 03-退款失败
     */
    private String status;

}
