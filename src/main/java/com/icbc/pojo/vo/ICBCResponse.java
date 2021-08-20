package com.icbc.pojo.vo;
import com.icbc.pojo.Gyj;
import com.icbc.pojo.Pub;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.Date;
import java.util.Objects;

/**
 * <p></p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Getter
@Setter
public class ICBCResponse<T> {

    private Integer code;
    private String message;
    /**
     *  成功标识
     */
    private Boolean success;
    /**
     *  交易代码，接口的一个代码
     */
    private String transCode;
    /**
     * 商户编号
     */
    private String merId;
    /**
     * 交易日期
     */
    private Date transDate;
    /**
     * 交易时间
     */
    private Date transTime;
    /**
     * 交易流水号
     */
    private String transNo;
    /**
     * data
     */
    private T data;

    public static <T>  ICBCResponse<T> success(Gyj gyj,Class<T> clazz){
        if (Objects.isNull(gyj)){
            return error();
        }
        if (gyj.getCode()!=200){
            return error(gyj);
        }
        ICBCResponse<T> response=createResponse(gyj.getPub());
        response.setData(modelMapper().map(gyj.getOut(),clazz));
        response.setCode(gyj.getCode());
        response.setMessage(gyj.getMessage());
        return response;
    }
    public static <T>  ICBCResponse<T> success(Gyj gyj,T t){
        if (Objects.isNull(gyj)){
            return error();
        }
        if (gyj.getCode()!=200){
            return error(gyj);
        }
        ICBCResponse<T> response=createResponse(gyj.getPub());
        response.setData(t);
        response.setCode(gyj.getCode());
        response.setMessage(gyj.getMessage());
        return response;
    }

    public static <T> ICBCResponse<T> createResponse(Pub pub){
        ICBCResponse<T> response=new ICBCResponse<>();
        response.setSuccess(Boolean.TRUE);
        response.setTransCode(pub.getTransCode());
        response.setMerId(pub.getMerId());
        response.setTransDate(pub.getTransDate());
        response.setTransTime(pub.getTransTime());
        response.setTransNo(pub.getTransNo());
        return response;
    }

    public static <T> ICBCResponse<T> error(){
        ICBCResponse<T> response=new ICBCResponse<>();
        response.setSuccess(Boolean.FALSE);
        response.setCode(500);
        response.setMessage("请求失败");
        return response;
    }
    public static <T> ICBCResponse<T> error(Gyj gyj){
        ICBCResponse<T> response=new ICBCResponse<>();
        response.setSuccess(Boolean.FALSE);
        response.setCode(gyj.getCode());
        response.setMessage(gyj.getMessage());
        return response;
    }

    public static ModelMapper modelMapper(){
        ModelMapper modelMapper =  new ModelMapper();
        modelMapper.getConfiguration().setFullTypeMatchingRequired(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
