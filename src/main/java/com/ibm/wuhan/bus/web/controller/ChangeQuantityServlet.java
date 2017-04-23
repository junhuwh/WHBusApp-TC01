package com.ibm.wuhan.bus.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.wuhan.bus.domain.Cart;
import com.ibm.wuhan.bus.service.impl.BookBusinessService;

/**
 * Servlet implementation class ChangeQuantityServlet
 */
//修改购物车内某项的数量
@WebServlet("/book/ChangeQuantityServlet")
public class ChangeQuantityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeQuantityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id= request.getParameter("id");
		String quantity = request.getParameter("quantity");
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		BookBusinessService service = new BookBusinessService();
		
		service.changeItemQuantity(id, quantity,cart);
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
