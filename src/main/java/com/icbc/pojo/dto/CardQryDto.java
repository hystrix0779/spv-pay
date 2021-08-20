package com.icbc.pojo.dto;

import com.icbc.pojo.In;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * <p>管家卡信息及保证金余额查询</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Setter
@Getter
public class CardQryDto extends Common{
    /**
     *  二级商户编号
     */
    private String subMerId;
    /**
     * 用户编号(买家)
     */
    @NotNull(message="用户编号(买家)不能为空")
    private String buyerId;
    /**
     * 用户编号(卖家)
     */
    @NotNull(message="用户编号(卖家)不能为空")
    private String sellerId;
    /**
     *  管家卡号
     */
    private  String manageCardNo;
    /**
     * 页码 当单页不能返回全部记录时，由合作企业指令通过“下页标识”指定页码进行分包返回；“下页标识”由银行在上次查询时返回给合作企业，提供合作企业下次查询时使用；如果“下页标识”返回为空，则标识没有后续记录；查询首页上送空；其他页需与银行返回包提供的一致
     */
    private  Integer page;

    @Override
    public In createIn() {
        super.validObj(this);
        return In.builder().
                subMerId(this.getSubMerId()).
                buyerId(this.getBuyerId()).
                sellerId(this.getSellerId()).
                manageCardNo(this.getManageCardNo()).
                page(this.getPage()).
            build();
    }
}
