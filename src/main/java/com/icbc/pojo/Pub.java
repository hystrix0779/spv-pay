package com.icbc.pojo;

import com.icbc.util.StringUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import lombok.Builder;
import lombok.Getter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * <p></p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Builder
@XStreamAlias("pub")
@Getter
public class Pub {
    /**
     *  交易代码，接口的一个代码
     */
    @XStreamAlias("TransCode")
    private final String transCode;
    /**
     * 商户编号
     */
    @XStreamAlias("MerId")
    private final String merId;
    /**
     * 交易日期
     */
    @XStreamAlias("TransDate")
    @XStreamConverter(value=TransDateConverter.class)
    private final Date transDate;
    /**
     * 交易时间
     */
    @XStreamAlias("TransTime")
    @XStreamConverter(value=TransTimeConverter.class)
    private final Date transTime;
    /**
     * 交易流水号
     */
    @XStreamAlias("TransNo")
    private final String transNo;

    public String toXml(){
        StringBuilder xml = new StringBuilder();
        if (StringUtil.isNotEmpty(this.transCode)){
            xml.append("<TransCode>").append(this.transCode).append("</TransCode>");
        }
        if (StringUtil.isNotEmpty(this.merId)){
            xml.append("<MerId>").append(this.merId).append("</MerId>");
        }
        if (Objects.nonNull(this.transDate)){
            xml.append("<TransDate>").append(new SimpleDateFormat("yyyyMMdd").format(this.transDate)).append("</TransDate>");
        }
        if (Objects.nonNull(this.transTime)){
            xml.append("<TransTime>").append(new SimpleDateFormat("HHmmss").format(this.transTime)).append("</TransTime>");
        }
        if (StringUtil.isNotEmpty(this.transNo)){
            xml.append("<TransNo>").append(this.transNo).append("</TransNo>");
        }
        return xml.toString();
    }

    public static class TransDateConverter extends AbstractSingleValueConverter{
        private final DateFormat defaultDateFormat = new SimpleDateFormat(
                "yyyyMMdd");
        @Override
        public boolean canConvert(Class type) {
            return type.equals(Date.class);
        }
        @Override
        public Object fromString(String str) {
            try {
                return defaultDateFormat.parseObject(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            throw new ConversionException("Cannot parse date " + str);
        }
    }
    public static class TransTimeConverter extends AbstractSingleValueConverter{
        private final DateFormat defaultDateFormat = new SimpleDateFormat(
                "HHmmss");
        @Override
        public boolean canConvert(Class type) {
            return type.equals(Date.class);
        }
        @Override
        public Object fromString(String str) {
            try {
                return defaultDateFormat.parseObject(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            throw new ConversionException("Cannot parse date " + str);
        }
    }
}
