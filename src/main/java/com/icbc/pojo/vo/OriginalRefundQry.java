package com.icbc.pojo.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p>原路退回结果查询</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class OriginalRefundQry {
    /**
     * 表示实际符合条件的交易笔数，并不是本次查询出来的总笔数。比如如果客户实际有25条记录，本次因为翻页只查询出10条，交易总笔数返回的是25条。
     */
    private Long total;
    /**
     * 明细详情
     */
    private List<Detail> details;


    @Getter
    @Setter
    public static class Detail {
        /**
         * 二级商户编号
         */
        private String subMerId;
        /**
         * 交易时间 退款时间(时间戳 yyyy-MM-dd hh:mm:ss)
         */
        private String operTimestmp;
        /**
         * 用户编号（买家）
         */
        private String buyerId;
        /**
         * 用户编号（卖家）
         */
        private String sellerId;
        /**
         * 收款方账号
         */
        private String buyerAccNo;
        /**
         * 管家卡号
         */
        private String manageCardNo;
        /**
         * 退款金额
         */
        private String amount;
        /**
         * 收款方户名
         */
        private String buyerAccName;
        /**
         * 原路退还状态 状态 (0-可疑；1-失败；2-成功 )
         */
        private Integer status;
    }
}
