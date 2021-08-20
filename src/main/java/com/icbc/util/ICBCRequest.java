package com.icbc.util;

import com.icbc.api.core.ApiClient;
import com.icbc.api.core.ApiException;
import com.icbc.api.core.ApiRequest;
import com.icbc.api.core.ApiResponse;
import com.icbc.enums.ResponseEnum;
import com.icbc.pojo.Gyj;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * <p></p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Slf4j
public class ICBCRequest {

    @SuppressWarnings("unchecked")
    public static Gyj request(ApiClient ac,ApiRequest req) throws ApiException {
        try {
            ApiResponse ar = ac.execute(req);
            if(ar.isCheckValid() && ar.getLong(ResponseEnum.ICBC_API_RETCODE.toString())==0){
                Map<Object, Object> res = ar.getMap("response");
                //验证接口是否调用成功
                if(res.get(ResponseEnum.status.toString()).equals("000")){
                    Map<Object, Object> data = (Map<Object, Object>) res.get(ResponseEnum.data.toString());
                    //业务处理成功，拿取返回的业务数据
                    if(data.get(ResponseEnum.retcode.toString()).equals("00000")){
                        StreamConvertor<Gyj> convertor= new StreamConvertor<>();
                        String ansXml = data.get("ansxml").toString();
                        //统一转化格式
                        ansXml=ansXml
                                .replaceAll("Manage_Card_No","ManageCardNo")
                                .replaceAll("Manage_Card_Name","manageCardName");

                        Gyj gyj = convertor.fromXml(Gyj.class, ansXml);
                        gyj.setCode(200);
                        gyj.setMessage("success");
                        return  gyj;
                    }else{
                        log.error("_retcode："+data.get("retcode").toString()+",  _retmsg："+data.get("retmsg").toString());
                        return Gyj.error(500,data.get("retcode").toString()+":"+data.get("retmsg").toString());
                    }
                }else{
                    log.error("_status："+res.get("status"));
                    return Gyj.error(500,res.get("status").toString());
                }
            }else{
                log.error("失败_响应码："+ar.getLong(ResponseEnum.ICBC_API_RETCODE.toString()));
                return Gyj.error((int) ar.getLong(ResponseEnum.ICBC_API_RETCODE.toString()),"请求失败");
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
    
}
