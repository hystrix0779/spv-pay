package com.icbc.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p></p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@XStreamAlias("out")
@Getter
@Setter
public class Out {

    /**
     * 二级商户编号
     */
    @XStreamAlias("SubMerId")
    private String subMerId;
    /**
     * 用户编号
     */
    @XStreamAlias("UserId")
    private String userId;
    /**
     * 用户名称
     */
    @XStreamAlias("UserName")
    private String userName;
    /**
     * 用户角色 0-平台；1-买家；2-卖家
     * 订单支付申请 1-买家；0-平台
     */
    @XStreamAlias("RoleType")
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
    @XStreamAlias("IdType")
    private String idType;
    /**
     * 证件号
     */
    @XStreamAlias("IdNo")
    private String idNo;
    /**
     * 手机号
     */
    @XStreamAlias("Mobile")
    private String mobile;
    /**
     * 绑定结算账号
     */
    @XStreamAlias("AccNo")
    private String accNo;
    /**
     * 绑定结算账号户名
     */
    @XStreamAlias("AccName")
    private String accName;
    /**
     * 绑定结算账号本他行标识 0-本行，1-他行
     */
    @XStreamAlias("AccLof")
    private Integer accLof;
    /**
     * 绑定结算账号个人对公标识 1-对公，2-个人
     */
    @XStreamAlias("AccPcf")
    private Integer accPcf;
    /**
     * 币种 001-人民币；012-英镑；013-港元；014-美元；015-瑞士法郎；016-德国马克；018-新加坡元；027-日元；038-欧元
     */
    @XStreamAlias("CurrType")
    private String currType;
    /**
     * 绑定结算账号开户行行号
     */
    @XStreamAlias("BankNo")
    private String bankNo;
    /**
     * 绑定结算账号开户行行名
     */
    @XStreamAlias("BankName")
    private String bankName;
    /**
     * 新增用户 0-上传失败 1-上传成功
     * 激活状态 0-未激活，1-激活失败，2-激活成功
     * 订单状态 00-已下单 02-已完成
     * 订单支付申请 00-待支付 01-支付中 02-支付成功 03-支付失败
     * 退款结果 00-待退款 01-退款中 02-退款成功 03-退款失败
     * 原路退还状态 状态 (0-可疑；1-失败；2-成功 )
     * 管家卡注销 0-未注销，1-注销失败，2-注销成功
     */
    @XStreamAlias("Status")
    private String status;
    /**
     * 用户编号（买家）
     */
    @XStreamAlias("BuyerId")
    private String buyerId;
    /**
     * 用户编号（卖家）
     */
    @XStreamAlias("SellerId")
    private String sellerId;
    /**
     * 订单编号
     */
    @XStreamAlias("OrderNo")
    private String orderNo;
    /**
     * 尾款金额
     * 订单确认收货（定金支付）明细查询 剩余尾款金额
     * 小微保证金账户实时余额及指定交易日动账明细查询 单位：元，保留2位小数。指当前查询时间点，该客户保证金账户的实时余额，也就是该客户所有小微管家卡对应的实时余额之和。
     * 管家卡信息及保证金余额查询 保证金余额
     */
    @XStreamAlias("Balance")
    private String balance;
    /**
     * 定金金额
     */
    @XStreamAlias("Earnest")
    private String earnest;
    /**
     * 手续费金额
     */
    @XStreamAlias("Fee")
    private String fee;
    /**
     * 商品信息
     */
    @XStreamAlias("GoodsInfo")
    private String goodsInfo;
    /**
     * 摘要
     */
    @XStreamAlias("Summary")
    private String summary;
    /**
     * 缴存管家卡号
     */
    @XStreamAlias("ManageCardNo")
    private String manageCardNo;
    /**
     * 缴存管家卡户名
     */
    @XStreamAlias("ManageCardName")
    private String manageCardName;
    /**
     * 小微订单号
     */
    @XStreamAlias("MicroOrderNo")
    private String microOrderNo;
    /**
     * 订单查询 总笔数 表示实际符合条件的交易笔数，并不是本次查询出来的总笔数。比如如果客户实际有25条记录，本次因为翻页只查询出10条，交易总笔数返回的是25条。
     */
    @XStreamAlias("Total")
    private Long total;
    /**
     * 下页标识 当有下一页时，显示下一页的页码，在下次查询时需要上送；如果“下页标识”返回为空，则标识没有后续记录
     */
    @XStreamAlias("NextPage")
    private String nextPage;
    /**
     * 起始日期
     */
    @XStreamAlias("BeginTime")
    private String beginTime;
    /**
     * 结束日期
     */
    @XStreamAlias("EndTime")
    private String endTime;

    /**
     * 订单金额
     * 退款金额
     */
    @XStreamAlias("Amount")
    private String amount;

    /**
     * 订单支付流水号
     * 退款流水号
     * 管家卡缴存明细查询 每个管家卡唯一
     */
    @XStreamAlias("SerialNo")
    private String serialNo;

    /**
     * 操作类型
     * 订单支付申请 0-定金；1-尾款
     */
    @XStreamAlias("OrderType")
    private String orderType;

    /**
     * 订单支付确认状态
     * 订单支付申请 中介模式返回 0-待确认2-已确认
     * 订单关联手机号修改 0-成功 1-失败 2-疑帐 （疑帐情况可以再次调用）
     */
    @XStreamAlias("Result")
    private String result;
    /**
     * 订单支付信息
     */
    @XStreamAlias("RetMsg")
    private String retMsg;

    /**
     * 上传结果描述 注销结果描述
     */
    @XStreamAlias("Memo")
    private String memo;
    /**
     * 交易日期
     */
    @XStreamAlias("TxDate")
    private String txDate;
    /**
     * 交易时间
     */
    @XStreamAlias("TxTime")
    private String txTime;
    /**
     * 退款理由
     */
    @XStreamAlias("RefundReason")
    private String refundReason;
    /**
     * 客户编号（平台）
     */
    @XStreamAlias("InstId")
    private String instId;
    /**
     * 买家退款状态
     */
    @XStreamAlias("Buyer_Ret")
    private String buyerRet;
    /**
     * 买家退款结果信息
     */
    @XStreamAlias("Buyer_RetMsg")
    private String buyerRetMsg;
    /**
     * 卖家退款状态
     */
    @XStreamAlias("Seller_Ret")
    private String sellerRet;
    /**
     * 卖家退款结果信息
     */
    @XStreamAlias("Seller_RetMsg")
    private String sellerRetMsg;
    /**
     * 平台退款状态
     */
    @XStreamAlias("Inst_Ret")
    private String instRet;
    /**
     * 平台退款结果信息
     */
    @XStreamAlias("Inst_RetMsg")
    private String instRetMsg;
    /**
     * 总记录数
     */
    @XStreamAlias("TotalCount")
    private String totalCount;
    /**
     * 交易时间 退款时间(时间戳 yyyy-MM-dd hh:mm:ss)
     */
    @XStreamAlias("OperTimestmp")
    private String operTimestmp;
    /**
     * 收款方账号
     */
    @XStreamAlias("BuyerAccNo")
    private String buyerAccNo;
    /**
     * 收款方户名
     */
    @XStreamAlias("BuyerAccName")
    private String buyerAccName;
    /**
     * 结果描述
     */
    @XStreamAlias("Msg")
    private String msg;
    /**
     * 管家卡号
     */
    @XStreamAlias("CardNo")
    private String cardNo;
    /**
     * 交易后余额 单位：元，保留2位小数。指做该笔交易后，管家卡（保证金子账户）对应的余额
     */
    @XStreamAlias("SubBalance")
    private String subBalance;
    /**
     * 交易时间 yyyy-MM-dd HH:mm:ss
     */
    @XStreamAlias("Worktime")
    private String workTime;
    /**
     * 交易对手方账号
     */
    @XStreamAlias("ReceiptAccNo")
    private String receiptAccNo;
    /**
     * 交易对手方户名
     */
    @XStreamAlias("ReceiptAccName")
    private String receiptAccName;
    /**
     * 交易类型 1-缴存 2-支付 3-退款
     */
    @XStreamAlias("OperType")
    private String operType;
    /**
     * 卡余额
     */
    @XStreamAlias("CardBalance")
    private String cardBalance;

    /**
     * 缴存管家卡开户网点名称
     */
    @XStreamAlias("Manage_Card_Branch")
    private String manageCardBranch;
    /**
     * 备注
     */
    @XStreamAlias("Note")
    private String note;
    /**
     * 管家卡状态 管家卡状态 0-正常 1-已注销 2-注销中
     */
    @XStreamAlias("Manage_Card_Status")
    private String manageCardStatus;
    /**
     * 下页标识 0-没有下一页 1-有下一页
     */
    @XStreamAlias("NextPageFlag")
    private String nextPageFlag;
    /**
     * 1-借 2-贷；借是支出，贷是收入
     */
    @XStreamAlias("DrcrFlag")
    private Integer drcrFlag;
    /**
     * 交易渠道代码
     */
    @XStreamAlias("Trxcode")
    private String trxCode;
    /**
     * 日期
     */
    @XStreamAlias("Workdate")
    private String workDate;
    /**
     * 交易时间戳
     */
    @XStreamAlias("Timestmp")
    private String timesTmp;
    /**
     * 用途
     */
    @XStreamAlias("Purpose")
    private String purpose;
    /**
     * 附言
     */
    @XStreamAlias("Notes")
    private String notes;

    @XStreamImplicit(itemFieldName="rd")
    private List<Out> userAdds;

    @XStreamImplicit(itemFieldName="OrderDetail")
    private List<Out> orderDetail;
}
