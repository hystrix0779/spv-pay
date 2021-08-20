package com.icbc.pojo.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p>小微保证金账户实时余额及指定交易日动账明细查询</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class AccountDetailQry {
    /**
     * 二级商户编号
     */
    private String subMerId;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 保证金账户余额 单位：元，保留2位小数。指当前查询时间点，该客户保证金账户的实时余额，也就是该客户所有小微管家卡对应的实时余额之和。
     */
    private String balance;
    /**
     * 明细详情
     */
    private List<QryDetails> details;

    @Getter
    @Setter
    public static class QryDetails{
        /**
         * 管家卡号
         */
        private String cardNo;
        /**
         * 卡余额
         */
        private String cardBalance;
        /**
         * 明细详情
         */
        private List<Detail> details;
    }

    @Getter
    @Setter
    public static class Detail{
        /**
         * 交易后余额 单位：元，保留2位小数。指做该笔交易后，管家卡（保证金子账户）对应的余额
         */
        private String subBalance;
        /**
         * 交易流水号
         */
        private String serialNo;
        /**
         * 交易时间 yyyy-MM-dd HH:mm:ss
         */
        private String workTime;
        /**
         * 交易金额
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
         * 交易类型 1-缴存 2-支付 3-退款
         */
        private String operType;
        /**
         * 摘要
         */
        private String summary;

    }
}
