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
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(message.getBytes());
			String asB64 = Base64.encodeBase64(md5).toString();
			//String asB64 = Base64.getEncoder().encodeToString(md5);
			
			return asB64;
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
}
