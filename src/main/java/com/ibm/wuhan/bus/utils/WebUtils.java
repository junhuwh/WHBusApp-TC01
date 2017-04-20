package com.ibm.wuhan.bus.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

public class WebUtils {

	// RegisterForm.class
	public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass) {

		try {
			// 1 创建要封装数据的bean
			T bean = beanClass.newInstance();

			// 2 把request的数据放入bean中
			Enumeration e = request.getParameterNames();
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement(); // username password
														// email
				String value = request.getParameter(name); // aaa 123 eee@so.com

				BeanUtils.setProperty(bean, name, value);

			}

			return bean;

		} catch (Exception e) {

			throw new RuntimeException(e);
		}

	}

	public static void copyBean(Object src, Object dest) {

		// 注册日期转换器
		ConvertUtils.register(new Converter() {
			public Object convert(Class type, Object value) {

				if (value == null) {
					return null;
				}
				String str = (String) value;
				if (str.trim().equals("")) {
					return null;
				}
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");


				try {
					return df.parse(str);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
				
			}
		}

		, Date.class);

		try {
			BeanUtils.copyProperties(dest, src);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//产生唯一的id
	public static String generateID(){
		return UUID.randomUUID().toString();
		
	}

}
