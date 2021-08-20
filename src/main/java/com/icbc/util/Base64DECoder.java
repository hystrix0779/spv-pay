package com.icbc.util;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;

/**
 * @date 2018-12-5
 * @author zjfh-wangc
 */
public class Base64DECoder {
	/**
	 * base64加密
	 * @param encoded
	 * @return
	 */
	public static String base64Encode(byte[] encoded) {
		Base64.Encoder encoder = Base64.getEncoder();
		try
		{
			return encoder.encodeToString(encoded).replaceAll("\r\n", "").replaceAll("\n", "");
		} catch (Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * base64解密
	 * @param reqdata
	 * @param charset
	 * @return
	 */
	public static String base64Decoder(String reqdata,String charset){
		Base64.Decoder decoder = Base64.getDecoder();
		try {
			return new String(decoder.decode(reqdata),charset);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} 
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
        String urlStr = "timestamp=2019-02-20+09%3A53%3A34&format=json&app_id=1202EG0000502&from=icbc-api&api=%2Fcorporbank%2Fprsign%2Fsign%2FV1&sign_type=RSA&charset=utf-8&sign=Y22e%2F%2FJPCjcWRkWN%2BPjMVtl2BnD8GzEC4ed9ln9TRjm003Lhpl2WTN7A2sc1fJpeU3VWru91DfPfbVOYMahqqeF6NBgj%2Faxx%2Bw%2FoU49z5I2NjRbBRg%2B2wueckl0Ax20WJM2B5A27rCc7JBz5rPU2fhYrVVX13J7ysr8fg5ZGMK8%3D&biz_content=%7B%22accno%22%3A%221202224819100015056%22%2C%22file_code%22%3A%220200EG0000001%22%2C%22netphone%22%3A%220571-85046223%22%2C%22return_msg%22%3A%22%22%2C%22netaddress%22%3A%22%E6%B5%99%E6%B1%9F%E7%9C%81%E6%9D%AD%E5%B7%9E%E5%B8%82%E6%BB%A8%E6%B1%9F%E5%8C%BA%E9%95%BF%E6%B2%B3%E8%A1%97%E9%81%93%E9%95%BF%E6%B1%9F%E8%B7%AF446%E5%8F%B7%22%2C%22phonenumber%22%3A%2215958115039%22%2C%22file_serialno%22%3A%226633074382999%22%2C%22tradeplat_code%22%3A%22773382910333%22%2C%22msg_id%22%3A%221202EG000050220190220095334102%22%2C%22return_code%22%3A%220%22%2C%22carraymaterial%22%3A%22%E8%90%A5%E4%B8%9A%E6%89%A7%E7%85%A7%E3%80%81%E5%BC%80%E6%88%B7%E8%AE%B8%E5%8F%AF%E8%AF%81%E3%80%81%E6%9C%BA%E6%9E%84%E4%BF%A1%E7%94%A8%E4%BB%A3%E7%A0%81%E8%AF%81%E3%80%81%E6%B3%95%E4%BA%BA%E8%BA%AB%E4%BB%BD%E8%AF%81%E3%80%81%E7%BB%8F%E5%8A%9E%E4%BA%BA%E8%BA%AB%E4%BB%BD%E8%AF%81%EF%BC%88%E8%8B%A5%E4%BB%A3%E5%8A%9E%EF%BC%89%E3%80%81%E4%BC%81%E4%B8%9A%E5%85%AC%E7%AB%A0%E3%80%81%E8%B4%A2%E5%8A%A1%E7%AB%A0%E3%80%81%E6%B3%95%E4%BA%BA%E6%88%96%E5%85%B6%E4%BB%96%E6%9C%89%E6%9D%83%E4%BA%BA%E7%A7%81%E7%AB%A0%EF%BC%8C%E4%BB%A5%E4%B8%8A%E8%B5%84%E6%96%99%E9%9C%80%E6%8F%90%E4%BE%9B%E6%AD%A3%E6%9C%AC%E5%8E%9F%E4%BB%B6%22%2C%22ent_orgcode%22%3A%2291370103MA3MDFR06J%22%2C%22result%22%3A%220%22%7D";
        String urlStrEncode = URLEncoder.encode(urlStr, "utf-8" );
        String urlStrDecode = URLDecoder.decode(urlStrEncode, "utf-8");
        System.out.println("urlStrEncode = " + urlStrEncode);
        System.out.println("urlStrDecode = " + urlStrDecode);

        // 将普通字符串转换成 application/x-www-form-urlencoded字符串
        String str = URLEncoder.encode("默默前行", "UTF-8");
        System.out.println("str = " + str);

        // 将application/x-www-form-urlencoded字符串转换成普通字符串
        String keyWord = URLDecoder.decode("默前", "UTF-8");
        System.out.println("keyWord = " + keyWord);
    }
}
