package com.icbc.pojo.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>订单关联手机号修改</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class OrderMobileChg {
    /**
     *  二级商户编号
     */
    private  String subMerId;
    /**
     *  用户编号
     */
    private  String userId;
    /**
     * 用户角色 1-买家；2-卖家；0-平台
     */
    private  Integer roleType;
    /**
     *  财智账户卡号 连锁店模式必输、中介模式平台发起支付必输
     */
    private  String manageCardNo;
    /**
     * 修改结果 0-成功 1-失败 2-疑帐 （疑帐情况可以再次调用）
     */
    private String result;
    /**
     * 结果描述
     */
    private String msg;
}
