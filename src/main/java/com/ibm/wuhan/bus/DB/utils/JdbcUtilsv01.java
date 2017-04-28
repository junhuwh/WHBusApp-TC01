package com.ibm.wuhan.bus.DB.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtilsv01 {
	private static Properties props = null; //new Properties();

	static {
		//给props进行初始化 即加载dbconfig.properties文件到props对象中
		//只在JdbcUtils类被加载时执行一次
		try {
			// 1加载配置文件
			InputStream in = JdbcUtilsv01.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			//System.out.println(in);
			props = new Properties();
			props.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		// 2 加载驱动类
		try {
			Class.forName(props.getProperty("driverClassName"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}

	//獲取連接
	public static Connection getConnection() throws SQLException  {

		// 3 调用drivermanager.getconnection
		return DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"),
				props.getProperty("password"));
	}

}
