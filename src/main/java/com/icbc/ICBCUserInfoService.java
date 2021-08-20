package com.icbc;

import com.icbc.api.core.ApiClient;
import com.icbc.api.core.ApiRequest;
import com.icbc.config.ICBCConfig;
import com.icbc.pojo.Gyj;
import com.icbc.pojo.In;
import com.icbc.pojo.dto.InfoAddDto;
import com.icbc.pojo.dto.InfoAddQryDto;
import com.icbc.pojo.vo.ICBCResponse;
import com.icbc.pojo.vo.InfoAdd;
import com.icbc.pojo.vo.InfoAddQry;
import com.icbc.util.ICBCRequest;
import com.icbc.util.ICBCUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


/**
 * 财智e管-客户信息上传查询
 * @author zjfh-liur
 */

@Service
@Slf4j
public class ICBCUserInfoService{

	@Resource
	ICBCConfig config;
	@Resource
	ModelMapper modelMapper;

	/**
	 * 1.客户信息上传
	 */
	@SneakyThrows
	public ICBCResponse<InfoAdd> userInfoAdd(List<InfoAddDto> dtoList) {
		String transNo = UUID.randomUUID().toString().substring(35);
		List<In> ins= dtoList.stream().map(InfoAddDto::createIn).collect(Collectors.toList());
		ApiClient ac = new ApiClient(config.getPriKey());
		ApiRequest req = ICBCUtils.createRequest(config,transNo,ins);
		Gyj gyj = ICBCRequest.request(ac, req);
		if (gyj.getCode()!=200){
			return ICBCResponse.error(gyj);
		}
		InfoAdd infoAdd=new InfoAdd();
		infoAdd.setSubMerId(gyj.getOut().getSubMerId());
		infoAdd.setDetails(gyj.getOut().getUserAdds().stream().
				map(o->modelMapper.map(o, InfoAdd.Detail.class)).
				collect(Collectors.toList()));
		return ICBCResponse.success(gyj,infoAdd);
	}

	/**
	 * 2.客户信息查询
	 */
	@SneakyThrows
	public ICBCResponse<InfoAddQry> userInfoQry(@Valid InfoAddQryDto dto) {
		ApiClient ac = new ApiClient(config.getPriKey());
		//请求对象
		ApiRequest req = ICBCUtils.createRequest(config,dto);
		Gyj gyj = ICBCRequest.request(ac, req);
		return ICBCResponse.success(gyj,InfoAddQry.class);
	}



}
