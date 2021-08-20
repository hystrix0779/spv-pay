package com.icbc;

import com.icbc.api.core.ApiClient;
import com.icbc.api.core.ApiRequest;
import com.icbc.config.ICBCConfig;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.icbc.pojo.Gyj;
import com.icbc.pojo.Out;
import com.icbc.pojo.dto.AccountDetailQryDto;
import com.icbc.pojo.dto.CardCancelDto;
import com.icbc.pojo.dto.CardQryDto;
import com.icbc.pojo.dto.DetailQryDto;
import com.icbc.pojo.vo.*;
import com.icbc.util.ICBCRequest;
import com.icbc.util.ICBCUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 财智e管-账户类接口查询
 * @author zjfh-liur
 */
@Service
public class ICBCAccountService{

    @Resource
    ICBCConfig config;
    @Resource
    ModelMapper modelMapper;

	/**
	 * 1.小微保证金账户实时余额及指定交易日动账明细查询
	 */
	@SneakyThrows
    public ICBCResponse<AccountDetailQry> micRoAccountDetailQry(AccountDetailQryDto dto) {
        ApiClient ac = new ApiClient(config.getPriKey());
        ApiRequest req = ICBCUtils.createRequest(config,dto);
        Gyj gyj = ICBCRequest.request(ac, req);
        Out out = gyj.getOut();
        AccountDetailQry qry=modelMapper.map(out,AccountDetailQry.class);
        List<AccountDetailQry.QryDetails> detailsList=out.getUserAdds().
                stream().map(o->{
            AccountDetailQry.QryDetails d=new AccountDetailQry.QryDetails();
            d.setCardNo(o.getCardNo());
            d.setDetails(o.getOrderDetail().stream().map(c->
                    modelMapper.map(c,AccountDetailQry.Detail.class))
                    .collect(Collectors.toList()));
            return d;
        }).collect(Collectors.toList());
        qry.setDetails(detailsList);

        return ICBCResponse.success(gyj,qry);
    }

	/**
	 * 2.管家卡信息及保证金余额查询
	 */
	@SneakyThrows
    public ICBCResponse<CardQry> manageCardQry(CardQryDto dto){
        ApiClient ac = new ApiClient(config.getPriKey());
        ApiRequest req = ICBCUtils.createRequest(config,dto);
        Gyj gyj = ICBCRequest.request(ac, req);
        if (gyj.getCode()!=200){
            return ICBCResponse.error(gyj);
        }
        CardQry qry=modelMapper.map(gyj.getOut(),CardQry.class);
        qry.setDetails(gyj.getOut().getUserAdds().stream().
                map(o->modelMapper.map(o, CardQry.Detail.class)).
                collect(Collectors.toList()));
        return ICBCResponse.success(gyj,qry);
	}

	/**
	 * 3.管家卡缴存明细查询
	 */
	@SneakyThrows
    public ICBCResponse<CardDetail> manageCardDetailQry(DetailQryDto dto) {
        ApiClient ac = new ApiClient(config.getPriKey());
        ApiRequest req = ICBCUtils.createRequest(config,dto);
        Gyj gyj = ICBCRequest.request(ac, req);
        if (gyj.getCode()!=200){
            return ICBCResponse.error(gyj);
        }
        CardDetail detail=new CardDetail();
        detail.setNextPageFlag(gyj.getOut().getNextPageFlag());
        detail.setDetails(gyj.getOut().getUserAdds().stream().
                map(o->modelMapper.map(o, CardDetail.Detail.class)).
                collect(Collectors.toList())
        );
        return ICBCResponse.success(gyj,detail);
	}

	/**
	 * 4.管家卡注销
	 */
	@SneakyThrows
    public ICBCResponse<CardCancel> manageCardCancel(CardCancelDto dto) {
        ApiClient ac = new ApiClient(config.getPriKey());
        ApiRequest req = ICBCUtils.createRequest(config,dto);
        Gyj gyj = ICBCRequest.request(ac, req);
        return ICBCResponse.success(gyj,CardCancel.class);
    }

}
