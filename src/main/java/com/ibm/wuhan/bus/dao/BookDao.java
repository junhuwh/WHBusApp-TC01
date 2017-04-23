package com.ibm.wuhan.bus.dao;

import java.util.Map;

import com.ibm.wuhan.bus.DB.DB;
import com.ibm.wuhan.bus.domain.Book;

public class BookDao {

	public Map getAll(){
		
		return DB.getAll();
		
	}
	
	public Book find(String id){
		
		return (Book) DB.getAll().get(id);
		
	}
}
