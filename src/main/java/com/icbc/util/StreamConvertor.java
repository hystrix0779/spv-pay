package com.icbc.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.springframework.oxm.xstream.XStreamMarshaller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p></p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
public class StreamConvertor<T> {

    //单例模式
    private static StreamConvertor<?> instance = null;
    private static final Map<String, XStreamMarshaller> X_STREAM_CACHE = new ConcurrentHashMap<>();
    private static final String XML_TAG = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    private static final String GBK = "UTF-8";
    static {
        instance = new StreamConvertor<>();
    }

    public String toXml(T pojo){
        String clzName = pojo.getClass().getName();
        XStreamMarshaller xstreamMarshaller = X_STREAM_CACHE.get(clzName);
        if (xstreamMarshaller == null) {
            xstreamMarshaller = new XStreamMarshaller();
            xstreamMarshaller.setEncoding(GBK);
            xstreamMarshaller.setStreamDriver(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
            X_STREAM_CACHE.put(clzName, xstreamMarshaller);
        }
        XStream xStream = xstreamMarshaller.getXStream();
        //防止出現 xStream:Security framework of XStream not initialized, XStream is probably vulnerable.
        XStream.setupDefaultSecurity(xStream);
        //允许转换对象
        xStream.allowTypes(new Class[]{});
        xStream.processAnnotations(pojo.getClass());
        return XML_TAG + xStream.toXML(pojo).replaceAll("<tiripPackage>", "").replaceAll("&quot;", "\"");
    }

    @SuppressWarnings("unchecked")
    public T fromXml(Class<T> clz, String xml) {
        String clzName = clz.getName();
        XStreamMarshaller xstreamMarshaller = X_STREAM_CACHE.get(clzName);
        if (xstreamMarshaller == null) {
            xstreamMarshaller = new XStreamMarshaller();
            xstreamMarshaller.setEncoding(GBK);
            xstreamMarshaller.setStreamDriver(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
            X_STREAM_CACHE.put(clzName, xstreamMarshaller);
        }
        XStream xStream = xstreamMarshaller.getXStream();
        xStream.setClassLoader(clz.getClassLoader());
        xStream.allowTypesByRegExp(new String[] { ".*" });
        xStream.processAnnotations(clz);
        return (T) xStream.fromXML(xml);
    }

    @SuppressWarnings("unchecked")
    public static StreamConvertor<Object> getInstance() {
        return (StreamConvertor<Object>) instance;
    }
}
