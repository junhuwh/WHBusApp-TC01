package com.ibm.wuhan.bus.service.impl;

import java.util.Map;

import com.ibm.wuhan.bus.dao.BookDao;
import com.ibm.wuhan.bus.domain.Book;

public class BookBusinessService {

	private BookDao dao = new BookDao();
	
	public Map getAllBook(){
		
		return dao.getAll();
	}
	
	
	public Book findBook(String id){
		return dao.find(id);
		
	}
	
	
	
}
