package com.icbc.pojo.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p>管家卡信息及保证金余额查询</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class CardQry {
    /**
     * 表示实际符合条件的交易笔数，并不是本次查询出来的总笔数。比如如果客户实际有25条记录，本次因为翻页只查询出10条，交易总笔数返回的是25条。
     */
    private Long total;
    /**
     * 当有下一页时，显示下一页的页码，在下次查询时需要上送；如果“下页标识”返回为空，则标识没有后续记录
     */
    private String nextPage;
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
         * 缴存管家卡号
         */
        private String manageCardNo;
        /**
         * 缴存管家卡户名
         */
        private String manageCardName;
        /**
         * 缴存管家卡开户网点名称
         */
        private String manageCardBranch;
        /**
         * 备注
         */
        private String note;
        /**
         * 管家卡状态 管家卡状态 0-正常 1-已注销 2-注销中
         */
        private String manageCardStatus;
        /**
         * 保证金余额
         */
        private String balance;
        /**
         * 小微订单号
         */
        private String microOrderNo;
    }
}
