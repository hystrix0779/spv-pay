package com.icbc.pojo.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p>管家卡缴存明细查询</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class CardDetail{
    /**
     * 下页标识 0-没有下一页 1-有下一页
     */
    private String nextPageFlag;
    /**
     * 明细详情
     */
    private List<Detail> details;


    @Getter
    @Setter
    public static class Detail{
        /**
         * 交易序列号 每个管家卡唯一
         */
        private String serialNo;
        /**
         * 1-借 2-贷；借是支出，贷是收入
         */
        private Integer drcrFlag;
        /**
         * 交易渠道代码
         */
        private String trxCode;
        /**
         * 交易日期 yyyy-MM-dd
         */
        private String txDate;
        /**
         * 交易时间 hh:mm:ss
         */
        private String txTime;
        /**
         * 管家卡号
         */
        private String cardNo;
        /**
         * 发生额
         */
        private String amount;
        /**
         * 交易对手方账号
         */
        private String receiptAccNo;
        /**
         * 交易对手方户名
         */
        private String receiptAccName;
        /**
         * 日期
         */
        private String workDate;
        /**
         * 交易时间戳
         */
        private String timesTmp;
        /**
         * 用途
         */
        private String purpose;
        /**
         * 附言
         */
        private String notes;
        /**
         * 摘要
         */
        private String summary;
        /**
         * 二级商户编号
         * 可能为null
         */
        private String subMerId;
    }
}
