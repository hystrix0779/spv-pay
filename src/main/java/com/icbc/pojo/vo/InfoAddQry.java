package com.icbc.pojo.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>客户信息查询</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class InfoAddQry {
    /**
     * 二级商户编号
     */
    private String subMerId;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户角色 0-平台；1-买家；2-卖家
     * 订单支付申请 1-买家；0-平台
     */
    private Integer roleType;
    /**
     * 证件类型 个人：
     * 0-身份证
     * 1-护照
     * 2-军官证
     * 3-士兵证
     * 4-港澳台居民往来通行证
     * 5-临时身份证
     * 6-户口本
     * 7-其他
     * 8-无
     * 9-警官证
     * 12-外国人永久居留证
     * 21-边民通行证
     * 对公：
     * 100-全国组织机构代码证书 对公
     * 101-营业执照
     * 102-行政机关
     * 103-社会团体法人登记证书
     * 104-军队单位开户核准通知书
     * 105-武警部队单位开户核准通知书
     * 106-下属机构(具有主管单位批文号)
     * 107-其他
     * 108-商业登记证
     * 109-公司注册证
     */
    private String idType;
    /**
     * 证件号
     */
    private String idNo;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 绑定结算账号
     */
    private String accNo;
    /**
     * 绑定结算账号户名
     */
    private String accName;
    /**
     * 绑定结算账号本他行标识 0-本行，1-他行
     */
    private Integer accLof;
    /**
     * 绑定结算账号个人对公标识 1-对公，2-个人
     */
    private Integer accPcf;
    /**
     * 币种 001-人民币；012-英镑；013-港元；014-美元；015-瑞士法郎；016-德国马克；018-新加坡元；027-日元；038-欧元
     */
    private String currType;
    /**
     * 绑定结算账号开户行行号
     */
    private String bankNo;
    /**
     * 绑定结算账号开户行行名
     */
    private String bankName;
    /**
     * 激活状态 0-未激活，1-激活失败，2-激活成功
     */
    private Integer status;
}
