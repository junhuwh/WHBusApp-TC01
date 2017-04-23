package com.ibm.wuhan.bus.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.wuhan.bus.domain.Book;
import com.ibm.wuhan.bus.domain.Cart;
import com.ibm.wuhan.bus.service.impl.BookBusinessService;

/**
 * Servlet implementation class BuyServlet
 */

//完成书籍购买
@WebServlet("/book/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		BookBusinessService service = new BookBusinessService();
		Book book = service.findBook(id);
		
		//得到用户购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart==null){
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
			
		}
		
		//把书加到购物车中 session 完成购买
		cart.add(book);

		//不能直接跳转到WEB-INF目录
		//response.sendRedirect("/WEB-INF/jsp/listcart.jsp");
		response.sendRedirect("ListCartUIServlet");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
