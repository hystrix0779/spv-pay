package com.icbc.pojo.dto;

import com.icbc.pojo.In;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * <p>退款确认</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class RefundSubmitDto extends Common{
    /**
     *  二级商户编号
     */
    private  String subMerId;
    /**
     * 退款流水号 每次退款交易唯一
     */
    @NotNull(message="serialNo-退款流水号")
    private  String serialNo;
    /**
     *  用户编号
     */
    @NotNull(message="userId-用户编号")
    private  String userId;
    /**
     * 用户角色 1-买家；2-卖家；0-平台；连锁店模式只支持买家发起
     */
    @NotNull(message="roleType-用户角色")
    private  Integer roleType;
    /**
     * 订单编号 下单时送的订单号
     */
    @NotNull(message="orderNo-订单编号")
    private  String orderNo;
    /**
     * 短信验证码
     */
    @NotNull(message="validateCode-短信验证码")
    private String validateCode;
    /**
     * 0-拒绝 1-通过  连锁店短信确认模式时，卖家发起时必输
     */
    @XStreamAlias("Status")
    private String status;

    @Override
    public In createIn(){
        super.validObj(this);
        return  In.builder().
                subMerId(this.subMerId).
                serialNo(this.serialNo).
                userId(this.userId).
                roleType(this.roleType).
                orderNo(this.orderNo).
                validateCode(this.validateCode).
                status(this.status).
            build();
    }
}
