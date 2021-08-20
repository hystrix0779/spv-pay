package com.icbc.pojo.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p>订单退款明细查询</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class RefundQry {
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
     * 起始日期 yyyyMMddhhmmss
     */
    private String beginTime;
    /**
     * 结束日期 yyyyMMddhhmmss
     */
    private String endTime;
    /**
     * 订单编号 下单时送的订单号
     */
    private  String orderNo;
    /**
     * 明细详情
     */
    private List<Detail> details;


    @Getter
    @Setter
    public static class Detail {
        /**
         * 退款流水号
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
         * 客户编号（平台）
         */
        private String instId;
        /**
         * 交易日期 yyyyMMdd
         */
        private String txDate;
        /**
         * 交易时间 hhmmss
         */
        private String txTime;
        /**
         * 买家退款状态
         */
        private String buyerRet;
        /**
         * 买家退款结果信息
         */
        private String buyerRetMsg;
        /**
         * 卖家退款状态
         */
        private String sellerRet;
        /**
         * 卖家退款结果信息
         */
        private String sellerRetMsg;
        /**
         * 平台退款状态
         */
        private String instRet;
        /**
         * 平台退款结果信息
         */
        private String instRetMsg;
        /**
         * 退款结果 00-待退款
         * 01-退款中
         * 02-退款成功
         * 03-退款失败
         */
        private String status;
        /**
         * 退款金额
         */
        private String amount;
        /**
         * 尾款金额
         */
        private String balance;
        /**
         * 摘要
         */
        private String summary;
        /**
         * 退款理由
         */
        private String refundReason;
    }
}
