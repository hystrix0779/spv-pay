package com.icbc;

import com.icbc.api.core.ApiClient;
import com.icbc.api.core.ApiRequest;
import com.icbc.config.ICBCConfig;
import com.icbc.pojo.Gyj;
import com.icbc.pojo.Out;
import com.icbc.pojo.dto.*;
import com.icbc.pojo.vo.*;
import com.icbc.util.ICBCRequest;
import com.icbc.util.ICBCUtils;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.stream.Collectors;

/**
 * 财智e管-订单上传支付退款
 * @author zjfh-liur
 */
@Service
public class ICBCOrderService{

	@Resource
	ICBCConfig config;
	@Resource
	ModelMapper modelMapper;
	/**
	 * 1.订单提交
	 */
	@SneakyThrows
	public ICBCResponse<OrderSubmit> orderSubmit(OrderSubmitDto dto) {
		ApiClient ac = new ApiClient(config.getPriKey());
		//请求对象
		ApiRequest req = ICBCUtils.createRequest(config,dto);
		Gyj gyj = ICBCRequest.request(ac, req);
		return ICBCResponse.success(gyj,OrderSubmit.class);
	}

	/**
	 * 2.订单查询
	 */
	@SneakyThrows
	public ICBCResponse<OrderInfo> orderInfoQry(OrderInfoDto dto) {
		ApiClient ac = new ApiClient(config.getPriKey());
		ApiRequest req = ICBCUtils.createRequest(config,dto);
		Gyj gyj = ICBCRequest.request(ac, req);
		if (gyj.getCode()!=200){
			return ICBCResponse.error(gyj);
		}
		Out out = gyj.getOut();
		OrderInfo orderInfo=modelMapper.map(out,OrderInfo.class);
		orderInfo.setDetails(out.getUserAdds().stream().
				map(o->modelMapper.map(o, OrderInfo.Detail.class)).
				collect(Collectors.toList()));
		return ICBCResponse.success(gyj,orderInfo);
	}
	
	/**
	 * 3.订单支付申请
	 */
	@SneakyThrows
	public ICBCResponse<PayApply> payApply(PayApplyDto dto) {
		ApiClient ac = new ApiClient(config.getPriKey());
		ApiRequest req = ICBCUtils.createRequest(config,dto);
		Gyj gyj = ICBCRequest.request(ac, req);
		return ICBCResponse.success(gyj,PayApply.class);
	}

	/**
	 * 4.订单支付确认
	 */
	@SneakyThrows
	public ICBCResponse<PaySubmit> paySubmit(PaySubmitDto dto) {
		ApiClient ac = new ApiClient(config.getPriKey());
		ApiRequest req = ICBCUtils.createRequest(config,dto);
		Gyj gyj = ICBCRequest.request(ac, req);
		return ICBCResponse.success(gyj,PaySubmit.class);
	}

	/**
	 * 5.订单确认收货（定金支付）明细查询
	 */
	@SneakyThrows
	public ICBCResponse<OrderReceiptQry> orderReceiptQry(OrderReceiptQryDto dto) {
		ApiRequest req = ICBCUtils.createRequest(config,dto);
		ApiClient ac = new ApiClient(config.getPriKey());
		Gyj gyj = ICBCRequest.request(ac, req);
		if (gyj.getCode()!=200){
			return ICBCResponse.error(gyj);
		}
		Out out = gyj.getOut();
		OrderReceiptQry orderInfo=modelMapper.map(out,OrderReceiptQry.class);
		orderInfo.setDetails(out.getUserAdds().stream().
				map(o->modelMapper.map(o, OrderReceiptQry.Detail.class)).
				collect(Collectors.toList()));
		return ICBCResponse.success(gyj,orderInfo);
	}

	/**
	 * 6.退款申请
	 */
	@SneakyThrows
	public ICBCResponse<RefundApply> refundApply(RefundApplyDto dto) {
		ApiClient ac = new ApiClient(config.getPriKey());
		ApiRequest req = ICBCUtils.createRequest(config,dto);
		Gyj gyj = ICBCRequest.request(ac, req);
		return ICBCResponse.success(gyj,RefundApply.class);
	}

	/**
	 * 7.退款确认
	 */
	@SneakyThrows
	public ICBCResponse<RefundSubmit> refundSubmit(RefundSubmitDto dto) {
		ApiClient ac = new ApiClient(config.getPriKey());
		ApiRequest req = ICBCUtils.createRequest(config,dto);
		Gyj gyj = ICBCRequest.request(ac, req);
		return ICBCResponse.success(gyj,RefundSubmit.class);
	}

	/**
	 * 8.订单退款明细查询
	 */
	@SneakyThrows
	public ICBCResponse<RefundQry> orderRefundQry(RefunQryDto dto) {
		ApiClient ac = new ApiClient(config.getPriKey());
		ApiRequest req = ICBCUtils.createRequest(config,dto);
		Gyj gyj = ICBCRequest.request(ac, req);
		if (gyj.getCode()!=200){
			return ICBCResponse.error(gyj);
		}
		RefundQry refundQry=modelMapper.map(gyj.getOut(),RefundQry.class);
		refundQry.setDetails(gyj.getOut().getUserAdds().
				stream().map(o->modelMapper.
				map(o,RefundQry.Detail.class)).
				collect(Collectors.toList()));
		return ICBCResponse.success(gyj,refundQry);
	}

	/**
	 * 9.原路退回结果查询
	 */
	@SneakyThrows
	public ICBCResponse<OriginalRefundQry> originalRefundQry(OriginalRefundQryDto dto) {
		ApiClient ac = new ApiClient(config.getPriKey());
		ApiRequest req = ICBCUtils.createRequest(config,dto);
		Gyj gyj = ICBCRequest.request(ac, req);
		if (gyj.getCode()!=200){
			return ICBCResponse.error(gyj);
		}
		OriginalRefundQry refundQry=modelMapper.map(gyj.getOut(),OriginalRefundQry.class);
		refundQry.setDetails(gyj.getOut().getUserAdds().
				stream().map(o->modelMapper.
				map(o,OriginalRefundQry.Detail.class)).
				collect(Collectors.toList()));
		return ICBCResponse.success(gyj,refundQry);
	}
	
	/**
	 * 10.订单关联手机号修改
	 */
	@SneakyThrows
	public ICBCResponse<OrderMobileChg> micOrderMobileChg(OrderMobileChgDto dto) {
		ApiClient ac = new ApiClient(config.getPriKey());
		ApiRequest req = ICBCUtils.createRequest(config,dto);
		Gyj gyj = ICBCRequest.request(ac, req);
		return ICBCResponse.success(gyj,OrderMobileChg.class);
	}
}
