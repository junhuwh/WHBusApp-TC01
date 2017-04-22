package com.ibm.wuhan.bus.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class ServiceUtils {

	public ServiceUtils() {
		// TODO Auto-generated constructor stub
	}

	public static String md5(String message){
		
		try {
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte md5[] = md.digest(message.getBytes());
			 Base64 base64=new Base64(); 
			String asB64 = base64.encode(md5).toString();
			//String asB64 = Base64.getEncoder().encodeToString(md5);
//	        byte[] b=plainText.getBytes();  
//	        Base64 base64=new Base64();  
//	        b=base64.encode(b);  
//	        String s=new String(b);  
//	        return s;
			return asB64;
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	 public static String encodeStr(String plainText){  
	        byte[] b=plainText.getBytes();  
	        Base64 base64=new Base64();  
	        b=base64.encode(b);  
	        String s=new String(b);  
	        return s;  
	    }  
	      
	    public static String decodeStr(String encodeStr){  
	        byte[] b=encodeStr.getBytes();  
	        Base64 base64=new Base64();  
	        b=base64.decode(b);  
	        String s=new String(b);  
	        return s;  
	    }  
}
