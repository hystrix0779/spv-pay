package com.icbc.pojo.dto;

import com.icbc.pojo.In;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * <p>原路退回结果查询</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class OriginalRefundQryDto extends Common{
    /**
     *  二级商户编号
     */
    private  String subMerId;

    /**
     * 用户编号(买家)
     */
    @NotNull(message="buyerId-买家为空")
    private  String buyerId;
    /**
     * 用户编号(卖家)
     */
    @NotNull(message="sellerId-卖家为空")
    private  String sellerId;
    /**
     *  管家卡号
     */
    @NotNull(message="manageCardNo-管家卡号为空")
    private String manageCardNo;

    @Override
    public In createIn(){
        super.validObj(this);
        return  In.builder().
                subMerId(this.subMerId).
                buyerId(this.buyerId).
                sellerId(this.sellerId).
                manageCardNo(this.manageCardNo).
            build();
    }
}
