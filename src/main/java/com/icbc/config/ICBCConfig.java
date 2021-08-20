package com.icbc.config;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>icbc支付所需要的静态配置</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class ICBCConfig {
    /**
     * 接口版本
     */
    private String version;
    /**
     * 商城ID
     * #财智e管中介模式唯一管家卡 agencyOnly
     * #财智e管中介模式一订单一管家卡 agency1O1C
     * #财智e管收款核心(无需短信确认) chainNotCheck
     * #财智e管收款核心(需要短信确认) chainCheck
     */
    private  String merId;
    /**
     * 商城应用ID
     */
    private String appId;
    /**
     * 字符集
     */
    private String charset;
    /**
     * #私钥
     * #2048位RSA私钥
     */
    private String priKey;
    /**
     * #action提交地址
     * #互联网=https://gyjapi1.dccnet.com.cn/api 专线=http://109.6.13.58:31056/api
     */
    private String apiUrl;

    /**
     *  生产环境：com.icbc.gyj.spv.
     *  测试环境：com.icbc.gyj.spvtest.
     */
    private String apiNamePrefix;
}
