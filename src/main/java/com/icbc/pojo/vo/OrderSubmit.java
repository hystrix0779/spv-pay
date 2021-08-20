package com.icbc.pojo.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * <p>订单提交</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class OrderSubmit{
    /**
     *  二级商户编号
     */
    private  String subMerId;
    /**
     * 用户编号(买家)
     */
    private  String buyerId;
    /**
     * 用户编号(卖家)
     */
    private  String sellerId;
    /**
     * 企业订单编号
     */
    private  String orderNo;
    /**
     * 尾款金额
     */
    private  BigDecimal balance;
    /**
     * 定金金额(定金金额后续只能整笔支付或退款)
     */
    private  BigDecimal earnest;
    /**
     * 手续费金额(无需手续费则送0，当前版本暂不支持扣手续费)
     */
    private  BigDecimal fee;
    /**
     * 商品信息
     */
    private  String goodsInfo;
    /**
     * 摘要
     */
    private  String summary;
    /**
     * 订单状态 00-已下单 02-已完成
     */
    private String status;
    /**
     * 缴存管家卡号
     */
    private String manageCardNo;
    /**
     * 缴存管家卡户名
     */
    private String manageCardName;
    /**
     * 小微订单号
     */
    private String microOrderNo;
}
