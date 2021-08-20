package com.icbc.pojo.dto;

import com.icbc.pojo.In;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * <p>客户信息上传</p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class InfoAddDto extends Common{
    /**
     *  用户编号
     */
    @NotNull(message="userId-用户编号")
    private  String userId;
    /**
     * 用户名称
     */
    @NotNull(message="userName-用户名称")
    private  String userName;
    /**
     * 用户角色 1-买家；2-卖家 0-平台
     */
    @NotNull(message="roleType-用户角色")
    private  Integer roleType;
    /**
     * 证件类型 个人：0-身份证  1-护照 2-军官证 3-士兵证 4-港澳台居民往来通行证 5-临时身份证 6-户口本 7-其他 8-无  9-警官证  12-外国人永久居留证  21-边民通行证
     * 	       对公：100-全国组织机构代码证书 对公 101-营业执照  102-行政机关  103-社会团体法人登记证书  104-军队单位开户核准通知书  105-武警部队单位开户核准通知书
     * 	       106-下属机构(具有主管单位批文号) 107-其他 108-商业登记证 109-公司注册证
     */
    @NotNull(message="idType-证件类型")
    private  Integer idType;
    /**
     * 证件号
     */
    @NotNull(message="idNo-证件号")
    private  String idNo;
    /**
     * 手机号
     */
    @NotNull(message="mobile-手机号")
    private  String mobile;
    /**
     * 结算账号
     */
    @NotNull(message="accNo-结算账号")
    private  String accNo;
    /**
     * 结算户名
     */
    @NotNull(message="accName-结算户名")
    private  String accName;
    /**
     * 结算账户开户行行号
     */
    @NotNull(message="bankNo-结算账户开户行行号")
    private  String bankNo;
    /**
     * 结算账户开户行行名
     */
    @NotNull(message="bankName-结算账户开户行行名")
    private  String bankName;
    /**
     * 本他行标志 0-本行 1-他行
     */
    @NotNull(message="accLof-本他行标志")
    private  Integer accLof;
    /**
     * 对公或个人标志 1-对公 2-个人
     */
    @NotNull(message="accPcf-对公或个人标志")
    private  Integer accPcf;
    /**
     * 币种（目前只支持001） 001-人民币；012-英镑；013-港元；014-美元；015-瑞士法郎；016-德国马克；018-新加坡元；027-日元；038-欧元
     */
    @NotNull(message="currType-币种")
    private  String currType;
    /**
     * 备注字段1
     */
    @NotNull(message="field1-备注字段1")
    private  String field1;
    /**
     * 备注字段2
     */
    @NotNull(message="field2-备注字段2")
    private  String field2;
    /**
     * 备注字段3
     */
    @NotNull(message="field3-备注字段3")
    private  String field3;
    /**
     *  二级商户编号
     */
    private  String subMerId;

    @Override
    public In createIn(){
//        super.validObj(this);
        return In.builder()
                .userId(this.userId)
                .userName(this.userName)
                .roleType(this.roleType)
                .idType(this.idType)
                .idNo(this.idNo)
                .mobile(this.mobile)
                .accNo(this.accNo)
                .accName(this.accName)
                .bankNo(this.bankNo)
                .bankName(this.bankName)
                .accLof(this.accLof)
                .accPcf(this.accPcf)
                .currType(this.currType)
                .field1(this.field1)
                .field2(this.field2)
                .field3(this.field3)
            .build();
    }
}
