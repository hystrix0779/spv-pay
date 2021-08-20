package com.icbc.pojo.dto;

import com.icbc.pojo.In;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * <p>订单关联手机号修改</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class OrderMobileChgDto extends Common{
    /**
     *  二级商户编号
     */
    private  String subMerId;
    /**
     *  用户编号
     */
    @NotNull(message="userId-用户编号")
    private  String userId;
    /**
     * 用户角色 1-买家；2-卖家；0-平台
     */
    @NotNull(message="roleType-用户角色")
    private  Integer roleType;
    /**
     *  财智账户卡号 连锁店模式必输、中介模式平台发起支付必输
     */
    @NotNull(message="manageCardNo-财智账户卡号")
    private  String manageCardNo;
    /**
     * 手机号
     * 订单关联手机号修改  管家卡号 0表示置空
     */
    @NotNull(message="mobile-手机号")
    private String mobile;
    @Override
    public In createIn(){
        super.validObj(this);
        return  In.builder().
                subMerId(this.subMerId).
                roleType(this.roleType).
                userId(this.userId).
                manageCardNo(this.manageCardNo).
                mobile(this.mobile).
            build();
    }
}
