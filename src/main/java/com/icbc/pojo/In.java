package com.icbc.pojo;

import com.icbc.util.StringUtil;
import lombok.Builder;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * <p></p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Builder
public class In {
    /**
     *  用户编号
     */
    private final String userId;
    /**
     * 用户名称
     */
    private final String userName;
    /**
     * 用户角色 1-买家；2-卖家 0-平台
     */
    private final Integer roleType;
    /**
     * 证件类型 个人：0-身份证  1-护照 2-军官证 3-士兵证 4-港澳台居民往来通行证 5-临时身份证 6-户口本 7-其他 8-无  9-警官证  12-外国人永久居留证  21-边民通行证
     * 	       对公：100-全国组织机构代码证书 对公 101-营业执照  102-行政机关  103-社会团体法人登记证书  104-军队单位开户核准通知书  105-武警部队单位开户核准通知书
     * 	       106-下属机构(具有主管单位批文号) 107-其他 108-商业登记证 109-公司注册证
     */
    private final Integer idType;
    /**
     * 证件号
     */
    private final String idNo;
    /**
     * 手机号
     * 订单关联手机号修改  管家卡号
     */
    private final String mobile;
    /**
     * 结算账号
     */
    private final String accNo;
    /**
     * 结算户名
     */
    private final String accName;
    /**
     * 结算账户开户行行号
     */
    private final String bankNo;
    /**
     * 结算账户开户行行名
     */
    private final String bankName;
    /**
     * 本他行标志 0-本行 1-他行
     */
    private final Integer accLof;
    /**
     * 对公或个人标志 1-对公 2-个人
     */
    private final Integer accPcf;
    /**
     * 币种（目前只支持001） 001-人民币；012-英镑；013-港元；014-美元；015-瑞士法郎；016-德国马克；018-新加坡元；027-日元；038-欧元
     */
    private final String currType;
    /**
     * 备注字段1
     */
    private final String field1;
    /**
     * 备注字段2
     */
    private final String field2;
    /**
     * 备注字段3
     */
    private final String field3;
    /**
     *  二级商户编号
     */
    private final String subMerId;
    /**
     *  管家卡号
     */
    private final String manageCardNo;
    /**
     *  查询类型4-查询当天记录  5-查询历史记录（不含当天）
     */
    private final Integer queryType;
    /**
     * 查询起始日期yyyy-MM-dd(查询历史记录时必输)
     */
    private final String startDate;
    /**
     * 查询截止日期yyyy-MM-dd(查询历史记录时必输)
     */
    private final String endDate;
    /**
     *  查询标志1-查询第1页；3-查询下一页
     */
    private final Integer queryFlag;
    /**
     * 交易日期yyyy-MM-dd 查询下一页时必输，值为上一次查询接口返回的最后一条记录中的workDate
     */
    private final String workDate;
    /**
     * 时间戳 查询下一页时必输，值为上一次查询接口返回的最后一条记录中的timesTmp
     */
    private final String timesTmp;
    /**
     *  交易类型0-全部 1-缴存 2-支付 3-退款
     */
    private final Integer operFlag;
    /**
     * 用户编号(买家)
     */
    private final String buyerId;
    /**
     * 用户编号(卖家)
     */
    private final String sellerId;
    /**
     * 页码
     */
    private final Integer page;
    /**
     * 企业订单编号
     */
    private final String orderNo;
    /**
     * 尾款金额
     */
    private final BigDecimal balance;
    /**
     * 定金金额(定金金额后续只能整笔支付或退款)
     */
    private final BigDecimal earnest;
    /**
     * 手续费金额(无需手续费则送0，当前版本暂不支持扣手续费)
     */
    private final BigDecimal fee;
    /**
     * 商品信息
     */
    private final String goodsInfo;
    /**
     * 摘要
     */
    private final String summary;
    /**
     * 起始日期yyyyMMddhhmmss
     */
    private final Date beginTime;
    /**
     * 结束日期yyyyMMddhhmmss
     */
    private final Date endTime;
    /**
     * 订单查询 订单状态 00-已下单02-已完成
     * 退款申请状态 0-拒绝 1-通过 连锁店短信确认模式时，卖家发起时必输
     * 退款确认  0-拒绝 1-通过，中介模式卖家确认时必输
     */
    private final String status;
    /**
     *  操作类型 0-定金；1-尾款（连锁店模式默认1）
     */
    private final Integer orderType;
    /**
     * 支付金额 支付尾款时必输，支付定金时无效（以订单下单时送的定金金额为准）
     */
    private final BigDecimal amount;
    /**
     * 订单支付流水号
     */
    private final String serialNo;
    /**
     * 短信验证码
     */
    private final String validateCode;
    /**
     * 退款理由
     */
    private final String refundReason;
    /**
     * 原路退款标识 1-是 其他-否 标识是否原路退款
     */
    private final Integer refundType;
    /**
     * 客户编号（平台）
     */
    private final String instId;


    public String toXml(){
        StringBuilder xml = new StringBuilder();
        if (StringUtil.isNotEmpty(this.userId)){
            xml.append("<UserId>").append(this.userId).append("</UserId>");
        }
        if (StringUtil.isNotEmpty(this.userName)){
            xml.append("<UserName>").append(this.userName).append("</UserName>");
        }
        if (Objects.nonNull(this.roleType)){
            xml.append("<RoleType>").append(roleType).append("</RoleType>");
        }
        if (Objects.nonNull(this.idType)){
            xml.append("<IdType>").append(idType).append("</IdType>");
        }
        if (StringUtil.isNotEmpty(this.idNo)){
            xml.append("<IdNo>").append(this.idNo).append("</IdNo>");
        }
        if (StringUtil.isNotEmpty(this.mobile)){
            xml.append("<Mobile>").append(this.mobile).append("</Mobile>");
        }
        if (StringUtil.isNotEmpty(this.accNo)){
            xml.append("<AccNo>").append(this.accNo).append("</AccNo>");
        }
        if (StringUtil.isNotEmpty(this.accName)){
            xml.append("<AccName>").append(this.accName).append("</AccName>");
        }
        if (StringUtil.isNotEmpty(this.bankNo)){
            xml.append("<BankNo>").append(this.bankNo).append("</BankNo>");
        }
        if (StringUtil.isNotEmpty(this.bankName)){
            xml.append("<BankName>").append(this.bankName).append("</BankName>");
        }
        if (Objects.nonNull(this.accLof)){
            xml.append("<AccLof>").append(accLof).append("</AccLof>");
        }
        if (Objects.nonNull(this.accPcf)){
            xml.append("<AccPcf>").append(accPcf).append("</AccPcf>");
        }
        if (StringUtil.isNotEmpty(this.currType)){
            xml.append("<CurrType>").append(this.currType).append("</CurrType>");
        }
        if (StringUtil.isNotEmpty(this.field1)){
            xml.append("<Field1>").append(this.field1).append("</Field1>");
        }
        if (StringUtil.isNotEmpty(this.field2)){
            xml.append("<Field2>").append(this.field2).append("</Field2>");
        }
        if (StringUtil.isNotEmpty(this.field3)){
            xml.append("<Field3>").append(this.field3).append("</Field3>");
        }
        if (Objects.nonNull(this.subMerId)){
            xml.append("<SubMerId>").append(this.subMerId).append("</SubMerId>");
        }
        if (StringUtil.isNotEmpty(this.manageCardNo)){
            xml.append("<ManageCardNo>").append(this.manageCardNo).append("</ManageCardNo>");
        }
        if (Objects.nonNull(this.queryType)){
            xml.append("<QueryType>").append(queryType).append("</QueryType>");
        }
        if (StringUtil.isNotEmpty(this.startDate)){
            xml.append("<StartDate>").append(this.startDate).append("</StartDate>");
        }
        if (StringUtil.isNotEmpty(this.endDate)){
            xml.append("<EndDate>").append(this.endDate).append("</EndDate>");
        }
        if (Objects.nonNull(this.queryFlag)){
            xml.append("<QueryFlag>").append(this.queryFlag).append("</QueryFlag>");
        }
        if (StringUtil.isNotEmpty(this.workDate)){
            xml.append("<Workdate>").append(this.workDate).append("</Workdate>");
        }
        if (StringUtil.isNotEmpty(this.timesTmp)){
            xml.append("<Timestmp>").append(this.timesTmp).append("</Timestmp>");
        }
        if (Objects.nonNull(this.operFlag)){
            xml.append("<OperFlag>").append(this.operFlag).append("</OperFlag>");
        }
        if (StringUtil.isNotEmpty(this.buyerId)){
            xml.append("<BuyerId>").append(this.buyerId).append("</BuyerId>");
        }
        if (StringUtil.isNotEmpty(this.sellerId)){
            xml.append("<SellerId>").append(this.sellerId).append("</SellerId>");
        }
        if (Objects.nonNull(this.page)){
            xml.append("<Page>").append(this.page).append("</Page>");
        }
        if (Objects.nonNull(this.orderNo)){
            xml.append("<OrderNo>").append(this.orderNo).append("</OrderNo>");
        }
        if (Objects.nonNull(this.balance)){
            xml.append("<Balance>").append(this.balance.toPlainString()).append("</Balance>");
        }
        if (Objects.nonNull(this.earnest)){
            xml.append("<Earnest>").append(this.earnest.toPlainString()).append("</Earnest>");
        }
        if (Objects.nonNull(this.fee)){
            xml.append("<Fee>").append(this.fee.toPlainString()).append("</Fee>");
        }
        if (StringUtil.isNotEmpty(this.goodsInfo)){
            xml.append("<GoodsInfo>").append(this.goodsInfo).append("</GoodsInfo>");
        }
        if (StringUtil.isNotEmpty(this.summary)){
            xml.append("<Summary>").append(this.summary).append("</Summary>");
        }
        if (Objects.nonNull(this.beginTime)){
            xml.append("<BeginTime>").append(new SimpleDateFormat("yyyyMMddhhmmss").format(this.beginTime)).append("</BeginTime>");
        }
        if (Objects.nonNull(this.endTime)){
            xml.append("<EndTime>").append(new SimpleDateFormat("yyyyMMddhhmmss").format(this.endTime)).append("</EndTime>");
        }
        if (StringUtil.isNotEmpty(this.status)){
            xml.append("<Status>").append(this.status).append("</Status>");
        }
        if (Objects.nonNull(this.orderType)){
            xml.append("<OrderType>").append(this.orderType).append("</OrderType>");
        }
        if (Objects.nonNull(this.amount)){
            xml.append("<Amount>").append(this.amount.toPlainString()).append("</Amount>");
        }
        if (StringUtil.isNotEmpty(this.serialNo)){
            xml.append("<SerialNo>").append(this.serialNo).append("</SerialNo>");
        }
        if (StringUtil.isNotEmpty(this.validateCode)){
            xml.append("<ValidateCode>").append(this.validateCode).append("</ValidateCode>");
        }
        if (StringUtil.isNotEmpty(this.refundReason)){
            xml.append("<RefundReason>").append(this.refundReason).append("</RefundReason>");
        }
        if (Objects.nonNull(this.refundType)){
            xml.append("<RefundType>").append(this.refundType).append("</RefundType>");
        }
        return xml.toString();
    }
}
