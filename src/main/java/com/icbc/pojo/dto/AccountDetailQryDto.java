package com.icbc.pojo.dto;

import com.icbc.pojo.In;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * <p>小微保证金账户实时余额及指定交易日动账明细查询</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class AccountDetailQryDto extends Common{
    /**
     *  二级商户编号
     */
    private  String subMerId;
    /**
     *  用户编号 小微买家编号
     */
    @NotNull(message="userId-用户编号")
    private  String userId;
    /**
     * 交易日期yyyy-MM-dd
     */
    @NotNull(message="workDate-交易日期")
    private  String workDate;
    /**
     *  交易类型0-全部 1-缴存 2-支付 3-退款
     */
    @NotNull(message="operFlag-交易类型")
    private  Integer operFlag;

    @Override
    public In createIn(){
        super.validObj(this);
        return  In.builder().
                subMerId(this.subMerId).
                userId(this.userId).
                workDate(this.workDate).
                operFlag(this.operFlag).
                build();
    }
}
