package com.ibm.wuhan.bus.DB;

import java.util.LinkedHashMap;
import java.util.Map;

import com.ibm.wuhan.bus.domain.Book;

//模拟数据库
public class DB {

	private static Map map = new LinkedHashMap();
	
	static {
		map.put("1", new Book("1","javaweb","老张",29,"一本书"));
		map.put("2", new Book("2","jdbc","小张",20,"一本书"));
		map.put("3", new Book("3","javacore","老王",39,"一本书"));
		map.put("4", new Book("4","bluemix","老李",24,"一本书"));
		map.put("5", new Book("5","spring","老张2",25,"一本书"));
		map.put("6", new Book("6","struts","小张2",22,"一本书"));
		map.put("7", new Book("7","javaee","小王",26,"一本书"));
		map.put("8", new Book("8","javase","老杜",20,"一本书"));
		map.put("9", new Book("9","html","小杜",25,"一本书"));
		map.put("10", new Book("10","css","老王3",22,"一本书"));
		map.put("11", new Book("11","javascript","老李2",25,"一本书"));
	}
	
	public static Map getAll(){
		return map;
	}
}
