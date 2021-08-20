package com.icbc.util;

import com.icbc.api.core.ApiRequest;
import com.icbc.config.ICBCConfig;
import com.icbc.pojo.In;
import com.icbc.pojo.Pub;
import com.icbc.pojo.dto.Common;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Slf4j
public class ICBCUtils {

    /**
     * 获取当前线程的最后一个方法名，a调用此方法，获取a，a调用b调用此方法，获取a
     * @return 方法名
     */
    public static String methodName(){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return stackTrace[3].getMethodName();
    }

    /**
     * 请求数据转xml并加密
     * @param pubBuilder 指令头的构造器
     * @param ins 多个指令明细的构造器
     * @param config icbc的config
     * @return string
     */
    public static String encryptionReqData(Pub.PubBuilder pubBuilder, List<In> ins, ICBCConfig config){
        Date currentTime = new Date();
        StringBuilder xml = new StringBuilder("<GYJ>");
        xml.append("<pub>");
        String pubXml = pubBuilder
                .merId(config.getMerId())
                .transDate(currentTime)
                .transTime(currentTime)
                .build().toXml();
        xml.append(pubXml).append("</pub>").append("<in>").append("<SubMerId></SubMerId>");
        for (In i:ins){
            xml.append("<rd>").append(i.toXml()).append("</rd>");
        }
        xml.append("</in></GYJ>");
        log.info(xml.toString());
        return Tool.base64Encode(xml.toString(), config.getCharset()).replaceAll("\r\n", "").replaceAll("\n", "");
    }
    /**
     * 请求数据转xml并加密
     * @param pubBuilder 指令头的构造器
     * @param in 单个指令明细的构造器
     * @param config icbc的config
     * @return string
     */
    public static String encryptionReqData(Pub.PubBuilder pubBuilder, In in, ICBCConfig config){
        Date currentTime = new Date();
        StringBuilder xml = new StringBuilder("<GYJ>");
        xml.append("<pub>");
        String pubXml = pubBuilder
                .merId(config.getMerId())
                .transDate(currentTime)
                .transTime(currentTime)
                .build().toXml();
        xml.append(pubXml).append("</pub>").append("<in>").append(in.toXml());
        xml.append("</in></GYJ>");
        log.info("request-xml:{}",xml.toString());
        return Tool.base64Encode(xml.toString(), config.getCharset()).replaceAll("\r\n", "").replaceAll("\n", "");
    }

    /**
     * 创建icbc请求实例
     * @param config icbc配置
     * @param t t
     * @return ApiRequest
     */
    public static <T extends Common> ApiRequest createRequest(ICBCConfig config,T t){
        String method= ICBCUtils.methodName();
        String transCode = method.toUpperCase();
        Pub.PubBuilder pubBuilder = Pub.builder()
                .transCode(transCode)
                .transNo(t.getTransNo());
        String encryptionReqData = encryptionReqData(pubBuilder, t.createIn(), config);

        return createRequest(config,method,encryptionReqData);
    }
    /**
     * 创建icbc请求实例
     * @param config icbc配置
     * @param transNo 交易编码
     * @param ins 多个指令明细的构造器
     * @return ApiRequest
     */
    public static ApiRequest createRequest(ICBCConfig config,String transNo, List<In> ins){
        String method= ICBCUtils.methodName();
        String transCode = method.toUpperCase();
        Pub.PubBuilder pubBuilder = Pub.builder()
                .transCode(transCode)
                .transNo(transNo);
        String encryptionReqData = encryptionReqData(pubBuilder, ins, config);
        return createRequest(config,method,encryptionReqData);
    }
    /**
     * 创建icbc请求实例
     * @param config icbc配置
     * @param method 方法名
     * @param encryptionReqData 密文
     * @return ApiRequest
     */
    public static ApiRequest createRequest(ICBCConfig config,String method,String encryptionReqData){
        String apiName = config.getApiNamePrefix()+method.toLowerCase();
        String transCode = method.toUpperCase();
        ApiRequest req = new ApiRequest(config.getApiUrl(),apiName,config.getAppId());
        req.setRequestField("version", config.getVersion());
        req.setRequestField("charset", config.getCharset());
        req.setRequestField("merid", config.getMerId());
        req.setRequestField("trancode",transCode);
        req.setRequestField("reqdata", encryptionReqData);
        return req;
    }
    public static Map<String, String> xmlToMap(String xml) {
        try {
            Map<String, String> data = new HashMap<>();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
            org.w3c.dom.Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }
            stream.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
