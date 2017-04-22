package com.ibm.wuhan.bus.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.wuhan.bus.domain.User;
import com.ibm.wuhan.bus.service.impl.BusinessServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
//处理登陆请求
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String username= request.getParameter("username");
		String password= request.getParameter("password");
		
		BusinessServiceImpl service = new BusinessServiceImpl();
		User user = service.login(username, password);
		if(user!=null){
			request.getSession().setAttribute("user", user);
			//登陆成功后跳转到首页
			response.sendRedirect("index.jsp");
			return;
			
		}
		System.out.println(username +" "+ password);
		request.setAttribute("message", "用户名或密码错误");
		request.getRequestDispatcher("WEB-INF/jsp/message.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
