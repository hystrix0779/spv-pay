package com.icbc.pojo.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p>订单确认收货（定金支付）明细查询</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class OrderReceiptQry {
    /**
     * 表示实际符合条件的交易笔数，并不是本次查询出来的总笔数。比如如果客户实际有25条记录，本次因为翻页只查询出10条，交易总笔数返回的是25条。
     */
    private Long total;
    /**
     * 当有下一页时，显示下一页的页码，在下次查询时需要上送；如果“下页标识”返回为空，则标识没有后续记录
     */
    private String nextPage;
    /**
     * 二级商户编号
     */
    private String subMerId;
    /**
     * 企业订单编号
     */
    private String orderNo;
    /**
     * 起始日期 yyyyMMddhhmmss
     */
    private String beginTime;
    /**
     * 结束日期 yyyyMMddhhmmss
     */
    private String endTime;
    /**
     * 明细详情
     */
    private List<Detail> details;


    @Getter
    @Setter
    public static class Detail{
        /**
         * 确认收货流水号
         */
        private String serialNo;
        /**
         * 用户编号（买家）
         */
        private String buyerId;
        /**
         * 用户编号（卖家）
         */
        private String sellerId;

        /**
         * 交易日期 yyyyMMdd
         */
        private String txDate;
        /**
         * 交易时间 hhmmss
         */
        private String txTime;
        /**
         * 0-定金；1-尾款
         */
        private String orderType;

        /**
         * 确认收货状态 0-待确认 1-确认中 2-已确认
         */
        private String result;
        /**
         * 确认收货信息
         */
        private String retMsg;
        /**
         * 确认收货结果 00-待支付 01-支付中 02-支付成功 03-支付失败
         */
        private String status;
        /**
         * 支付金额
         */
        private String amount;
        /**
         * 剩余尾款金额
         */
        private String balance;
        /**
         * 摘要
         */
        private String summary;
    }
}
