package com.icbc.pojo.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p>订单支付申请</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class OrderInfo {
    /**
     * 表示实际符合条件的交易笔数，并不是本次查询出来的总笔数。比如如果客户实际有25条记录，本次因为翻页只查询出10条，交易总笔数返回的是25条。
     */
    private Long total;
    /**
     * 当有下一页时，显示下一页的页码，在下次查询时需要上送；如果“下页标识”返回为空，则标识没有后续记录
     */
    private String nextPage;
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
         * 二级商户编号
         */
        private String subMerId;
        /**
         * 用户编号（买家）
         */
        private String buyerId;
        /**
         * 用户编号（卖家）
         */
        private String sellerId;
        /**
         * 订单编号
         */
        private String orderNo;
        /**
         * 交易日期 yyyyMMdd
         */
        private String txDate;
        /**
         * 交易时间 hhmmss
         */
        private String txTime;
        /**
         * 订单金额
         */
        private String amount;
        /**
         * 尾款金额
         */
        private String balance;
        /**
         * 定金金额
         */
        private String earnest;
        /**
         * 手续费金额
         */
        private String fee;
        /**
         * 商品信息
         */
        private String goodsInfo;
        /**
         * 摘要
         */
        private String summary;
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
    }
}
