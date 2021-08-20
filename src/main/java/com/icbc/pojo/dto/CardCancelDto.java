package com.icbc.pojo.dto;

import com.icbc.pojo.In;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * <p>管家卡注销</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class CardCancelDto extends Common{
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
     *  财智账户卡号 连锁店模式必输、中介模式平台发起支付必输
     */
    @NotNull(message="manageCardNo-财智账户卡号")
    private  String manageCardNo;

    @Override
    public In createIn(){
        super.validObj(this);
        return  In.builder().
                subMerId(this.subMerId).
                userId(this.userId).
                manageCardNo(this.manageCardNo).
            build();
    }
}
