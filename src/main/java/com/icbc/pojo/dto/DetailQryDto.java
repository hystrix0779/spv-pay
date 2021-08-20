package com.icbc.pojo.dto;

import com.icbc.pojo.In;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * <p>管家卡缴存明细查询</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class DetailQryDto extends Common{
    /**
     *  二级商户编号
     */
    private  String subMerId;
    /**
     *  管家卡号
     */
    @NotNull(message="manageCardNo-管家卡号不能为空")
    private  String manageCardNo;
    /**
     *  查询类型4-查询当天记录  5-查询历史记录（不含当天）
     */
    @NotNull(message="queryType-查询类型不能为空")
    private  Integer queryType;
    /**
     * 查询起始日期yyyy-MM-dd(查询历史记录时必输)
     */
    private  String startDate;
    /**
     * 查询截止日期yyyy-MM-dd(查询历史记录时必输)
     */
    private  String endDate;
    /**
     *  查询标志1-查询第1页；3-查询下一页
     */
    @NotNull(message="queryFlag-查询标志不能为空")
    private  Integer queryFlag;
    /**
     * 查询下一页时必输，值为上一次查询接口返回的最后一条记录中的workdate
     */
    private  String workDate;
    /**
     * 时间戳 查询下一页时必输，值为上一次查询接口返回的最后一条记录中的timesTmp
     */
    private  String timesTmp;

    @Override
    public In createIn(){
        super.validObj(this);
        return In.builder().
                subMerId(this.getSubMerId()).
                manageCardNo(this.getManageCardNo()).
                queryType(this.getQueryType()).
                startDate(this.getStartDate()).
                endDate(this.getEndDate()).
                queryFlag(this.getQueryFlag()).
                workDate(this.getWorkDate()).
                timesTmp(this.getTimesTmp()).
            build();
    }
}
