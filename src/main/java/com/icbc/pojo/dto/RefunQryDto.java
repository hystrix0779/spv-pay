package com.icbc.pojo.dto;

import com.icbc.pojo.In;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * <p>订单退款明细查询</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class RefunQryDto extends Common{
    /**
     *  二级商户编号
     */
    private  String subMerId;
    /**
     * 订单编号
     */
    @NotNull(message="orderNo-订单编号")
    private  String orderNo;
    /**
     * 起始日期yyyyMMddhhmmss
     */
    @NotNull(message="beginTime-起始日期")
    private  Date beginTime;
    /**
     * 结束日期yyyyMMddhhmmss
     */
    @NotNull(message="endTime-结束日期")
    private  Date endTime;
    /**
     * 用户编号(买家)
     */
    private  String buyerId;
    /**
     * 用户编号(卖家)
     */
    private  String sellerId;
    /**
     * 客户编号（平台）
     */
    private String instId;
    /**
     * 退款流水号
     */
    private  String serialNo;
    /**
     * 当单页不能返回全部记录时，由合作企业指令通过“下页标识”指定页码进行分包返回；“下页标识”由银行在上次查询时返回给合作企业，
     * 提供合作企业下次查询时使用；如果“下页标识”返回为空，则标识没有后续记录；查询首页上送空；其他页需与银行返回包提供的一致
     */
    private  Integer page;

    @Override
    public In createIn(){
        super.validObj(this);
        return  In.builder().
                subMerId(this.subMerId).
                orderNo(this.orderNo).
                beginTime(this.beginTime).
                endTime(this.endTime).
                buyerId(this.buyerId).
                sellerId(this.sellerId).
                instId(this.instId).
                serialNo(this.serialNo).
                page(this.page).
            build();
    }
}
