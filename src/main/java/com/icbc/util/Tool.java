package com.icbc.util;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class Tool {
	/**
	 * 发送报文的md5签名格式
	 * 
	 * @param version
	 *            版本号
	 * @param merid
	 *            商户ID
	 * @param trancode
	 *            交易代码
	 * @param tmp
	 *            xml格式的交易报文
	 * @param charset
	 *            编码
	 * @param password
	 *            约定的密码
	 * @param transtime
	 *            交易时间
	 * @return 加密后的字符串
	 */
	public static String sendMd5(String version, String merid, String trancode,
			String tmp, String charset, String password, String transtime) {
		return md5(
				md5(
						"version=" + version + "&merId=" + merid + "&tranCode="
								+ trancode + "&reqData=" + tmp, charset)
						.toUpperCase()
						+ "SEPGARAYJTOR"
						+ md5(password + transtime, charset).toUpperCase(),
				charset).toUpperCase();

	}
	
	/**
	 * 返回报文的md5签名格式
	 * 
	 * @param retxml
	 *            xml格式的返回报文
	 * @param merid
	 *            商户ID
	 * @param orderid
	 *            订单id
	 * @param charset
	 *            编码方式
	 * @param password
	 *            约定的密码
	 * @param transtime
	 *            返回的交易时间
	 * @return
	 */
	public static String returnMd5(String retxml, String merid, String orderid,
			String charset, String password, String transtime) {

		return md5(
				md5(
						"reqData=" + retxml + "&merId=" + merid + "&orderId="
								+ orderid, charset).toUpperCase()
						+ "SEPGARAYJTOR"
						+ md5(password + transtime, charset).toUpperCase(),
				charset).toUpperCase();
	}
	
	/**
	 * md5加密算法
	 * 
	 * @param str
	 *            待加密字符串
	 * @param charset
	 *            编码方式
	 * @return
	 */
	public static String md5(String str, String charset) {

		if (str == null) {
			return null;
		}

		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes(charset));
		} catch (NoSuchAlgorithmException e) {

			return str;
		} catch (UnsupportedEncodingException e) {
			return str;
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}

		return md5StrBuff.toString();
	}
	
	/**
	 * split string
	 * 
	 * @param sign 符号
	 * @param sourceString
	 * @return 源字符串
	 */
	public static Vector splitString(String sign, String sourceString) {
		Vector splitArrays = new Vector();
		int i = 0;
		int j = 0;
		if (sourceString.length() == 0) {
			return splitArrays;
		}
		while (i <= sourceString.length()) {
			j = sourceString.indexOf(sign, i);
			if (j < 0) {
				j = sourceString.length();
			}
			splitArrays.addElement(sourceString.substring(i, j));
			i = j + 1;
		}
		return splitArrays;
	}
	
	/**
	 * 报文返回时间yyyyMMddHHmmss 商户需验证该时间和自己服务器时间间隔前后不超过15分钟
	 * 
	 * @param time
	 *            报文返回时间
	 * @return
	 */
	public static boolean checkTranstime(String time) {
		// TODO Auto-generated method stub
		if (time == null || time.length() != 14) {
			return false;
		}

		long t = Long.parseLong(time.substring(0, 8)) * 10000
				+ Long.parseLong(time.substring(8, 10)) * 60
				+ Long.parseLong(time.substring(10, 12));
		String now = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		long t1 = Long.parseLong(now.substring(0, 8)) * 10000
				+ Long.parseLong(now.substring(8, 10)) * 60
				+ Long.parseLong(now.substring(10, 12));

		// System.out.println("----|-----------|"+t);
		// System.out.println("----|-----------|"+t1);

		if ((t - t1) > 15 || (t - t1) < -15)
			return false;

		return true;
	}
	
	public static String base64Encode(String data,String charset){
		Encoder encoder = Base64.getEncoder();
	    try {
			return encoder.encodeToString(data.getBytes(charset));
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String base64Decode(String data,String charset){
		Base64.Decoder decoder = Base64.getDecoder();
		try {
			return new String(decoder.decode(data),charset);
		} catch (Exception e) {
			return null;
		}
	}

	public static byte[] base64Decode(String data){
		Base64.Decoder decoder = Base64.getDecoder();
		try {
			return decoder.decode(data);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * @param encoded
	 * @return
	 */
	public static String base64Encode(byte[] encoded) {
		// TODO Auto-generated method stub
		Encoder encoder = Base64.getEncoder();
	    try {
			return encoder.encodeToString(encoded);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public String getWEBINFPath(){
		try {
			 String path = URLDecoder.decode(new URL(this.getClass().getClassLoader().getResource("").toString()).getPath(),"UTF-8");
			 return path.substring(0,path.indexOf("classes"));
		} catch (Exception e) {
			e.printStackTrace();	
			return null;
		}
	}
	
	public static boolean checkNighttime(String time) {
		if(time==null||time.length()!=19){
			return false;
		}
			
		try{
			Date d = new Date();
			String now = new SimpleDateFormat("yyyyMMddHHmmss").format(d);
			long h = Long.parseLong(now.substring(8,10));
			long m = Long.parseLong(now.substring(10,12));
				
			String t_y = time.substring(0,4);
			String t_m = time.substring(5,7);
			String t_d = time.substring(8,10);
			String t_h = time.substring(11,13);
			String t_mi = time.substring(14,16);
				
			if(h == 23 && m >= 45 || h == 0 && m <= 15){
				Calendar c = Calendar.getInstance();
				c.set(Calendar.YEAR, Integer.parseInt(t_y));
				c.set(Calendar.MONTH, Integer.parseInt(t_m)-1);
				c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(t_d));
				c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(t_h));
				c.set(Calendar.MINUTE, Integer.parseInt(t_mi));
				c.set(Calendar.SECOND, 0);
				c.set(Calendar.MILLISECOND, 0);
				long l = c.getTimeInMillis() - d.getTime();
				if(l>900000||l<-900000) return false;
			}else{
				//60*24
				long t1=Long.parseLong(now.substring(0,8))*1440+h*60+m;
				long t=Long.parseLong(t_y+t_m+t_d)*1440+Long.parseLong(t_h)*60+Long.parseLong(t_mi);
				if((t-t1)>15||(t-t1)<-15) return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
