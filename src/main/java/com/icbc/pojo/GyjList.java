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
@XStreamAlias("GYJ")
@Getter
@Setter
public class GyjList {
    private Pub pub;
    @XStreamImplicit(itemFieldName="rd")
    private List<Out> out;
}
