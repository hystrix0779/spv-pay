package com.icbc.pojo.dto;

import com.icbc.pojo.In;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * <p>客户信息查询</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class InfoAddQryDto extends Common{
    /**
     *  用户编号
     */
    @NotNull(message="userId-用户编号")
    private  String userId;
    /**
     * 用户角色 1-买家；2-卖家 0-平台
     */
    @NotNull(message="roleType-用户角色")
    private  Integer roleType;
    /**
     *  二级商户编号
     */
    private  String subMerId="";

    @Override
    public In createIn(){
        super.validObj(this);
        return  In.builder().
                subMerId(this.subMerId).
                userId(this.userId).
                roleType(this.roleType).
            build();
    }
}
