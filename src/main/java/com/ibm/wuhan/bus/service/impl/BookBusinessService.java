package com.ibm.wuhan.bus.service.impl;

import java.util.Map;

import com.ibm.wuhan.bus.dao.BookDao;
import com.ibm.wuhan.bus.domain.Book;
import com.ibm.wuhan.bus.domain.Cart;
import com.ibm.wuhan.bus.domain.CartItem;

//业务类统一为web层提供所有服务
public class BookBusinessService {

	private BookDao dao = new BookDao();

	public Map getAllBook() {

		return dao.getAll();
	}

	public Book findBook(String id) {
		return dao.find(id);

	}

	//删除购物车中的购物项
	public void deleteCartItem(String id, Cart cart) {
		// TODO Auto-generated method stub
		cart.getMap().remove(id);
	}

	public void clearCart(Cart cart) {
		// TODO Auto-generated method stub
		cart.getMap().clear();
		
	}

	public void changeItemQuantity(String id, String quantity, Cart cart) {
		// TODO Auto-generated method stub
		CartItem item = cart.getMap().get(id);
		item.setQuantity(Integer.parseInt(quantity));
		
	}

}
