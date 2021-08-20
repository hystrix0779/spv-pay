package com.icbc.pojo.dto;

import com.icbc.pojo.In;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * <p>订单支付确认</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class PaySubmitDto extends Common{
    /**
     *  二级商户编号
     */
    private  String subMerId;
    /**
     * 订单支付流水号 唯一
     */
    @NotNull(message="serialNo-订单支付流水号")
    private  String serialNo;
    /**
     *  用户编号
     */
    @NotNull(message="userId-用户编号")
    private  String userId;
    /**
     * 用户角色 1-买家，只能送“1”
     */
    @NotNull(message="roleType-用户角色")
    private  Integer roleType;
    /**
     * 订单编号 中介模式下需与订单提交接口对应
     */
    @NotNull(message="orderNo-订单编号")
    private  String orderNo;
    /**
     *  操作类型 0-定金；1-尾款（连锁店模式默认1）
     */
    private  Integer orderType;
    /**
     * 短信验证码
     */
    private  String validateCode;
    @Override
    public In createIn(){
        super.validObj(this);
        return In.builder().
                subMerId(this.subMerId).
                serialNo(this.serialNo).
                userId(this.userId).
                roleType(this.roleType).
                orderNo(this.orderNo).
                orderType(this.orderType).
                validateCode(this.validateCode).
            build();
    }
}
