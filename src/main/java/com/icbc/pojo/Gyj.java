package com.icbc.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

/**
 * <p></p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@XStreamAlias("GYJ")
@Getter
@Setter
public class Gyj {
    private Integer code;
    private String message;
    private Pub pub;
    private Out out;

    public static Gyj error(int code,String message){
        Gyj gyj=new Gyj();
        gyj.setCode(code);
        gyj.setMessage(message);
        return gyj;
    }
}
