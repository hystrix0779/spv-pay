package com.icbc.pojo.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>管家卡注销</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class CardCancel{
    /**
     *  二级商户编号
     */
    private  String subMerId;
    /**
     *  用户编号
     */
    private  String userId;
    /**
     *  财智账户卡号 连锁店模式必输、中介模式平台发起支付必输
     */
    private  String manageCardNo;
    /**
     * 管家卡注销 0-未注销，1-注销失败，2-注销成功
     */
    private String status;
    /**
     * 注销结果描述
     */
    private String memo;
}
