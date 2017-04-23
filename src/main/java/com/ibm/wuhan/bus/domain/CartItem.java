package com.ibm.wuhan.bus.domain;

//购物项 用于代表某个商品 以及商品出现的次数
public class CartItem {
	private Book book;
	private int quantity;
	private double price;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.price = this.book.getPrice() * this.quantity;

	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public CartItem(Book book, int quantity, double price) {
		super();
		this.book = book;
		this.quantity = quantity;
		this.price = price;
	}

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

}
