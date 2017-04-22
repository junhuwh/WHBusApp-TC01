package junit.test;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import com.ibm.wuhan.bus.utils.ServiceUtils;
import com.ibm.wuhan.bus.utils.XmlUtils;

public class testa2 {

	@Test
	public void testA() throws UnsupportedEncodingException {
	
		System.out.println(getMD5("123"));
		System.out.println(getMD5("123"));
		System.out.println(getMD5("123"));
		System.out.println(getMD5("123"));

		String inputData = "123a";
		String a123a= "123a";
		System.out.println("test1 md5 123a " + ServiceUtils.md5(a123a));
		System.out.println("test2 md5 123a " + ServiceUtils.md5(a123a));
		

		
		String aa = new String(Base64.encodeBase64(inputData.getBytes("utf-8")), "utf-8");
		String bb = new String(Base64.decodeBase64("MTIzYQ".getBytes("utf-8")), "utf-8");
		
		System.out.println(aa + " " + bb);
	}

	@Test
	public void testUWE() {
		String str = "123";

		String b = encodeStr(str);
		System.out.println(encodeStr(str));

		System.out.println(decodeStr(b));
		String filepath = XmlUtils.class.getClassLoader().getResource("").getPath();
		// System.out.println(filepath);
	}

	public static String encodeStr(String plainText) {
		byte[] b = plainText.getBytes();
		Base64 base64 = new Base64();
		b = base64.encode(b);
		String s = new String(b);
		return s;
	}

	public static String decodeStr(String encodeStr) {
		byte[] b = encodeStr.getBytes();
		Base64 base64 = new Base64();
		b = base64.decode(b);
		String s = new String(b);
		return s;
	}
	
	public static String getMD5(String str) {
	    try {
	        // 生成一个MD5加密计算摘要
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        // 计算md5函数
	        md.update(str.getBytes());
	        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
	        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
	        return new BigInteger(1, md.digest()).toString(16);
	    } catch (Exception e) {
	        throw new SecurityException("MD5加密出现错误");
	    }
	}
}
