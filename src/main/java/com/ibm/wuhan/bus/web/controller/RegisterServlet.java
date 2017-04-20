package com.ibm.wuhan.bus.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.wuhan.bus.domain.User;
import com.ibm.wuhan.bus.exception.UserExistExcepiton;
import com.ibm.wuhan.bus.service.impl.BusinessServiceImpl;
import com.ibm.wuhan.bus.utils.WebUtils;
import com.ibm.wuhan.bus.web.formbean.RegisterForm;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		
		
		//1 表单字段合法性校验(formbean) 
		//把表单封装到formbean
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		boolean b = form.validate();
		
		
		//2 如果校验失败 跳回到表单页面 回显校验失败信息
		if(!b){
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			
			return;
		}
		
		//3 如果校验成功则调用service处理注册请求
		User user = new User();
		WebUtils.copyBean(form, user);
		user.setId(WebUtils.generateID());
		BusinessServiceImpl service = new BusinessServiceImpl();
		
		try {
			service.register(user);
			//6 如果service处理成功 跳转到全局显示页面 显示注册成功消息
			request.setAttribute("message", "恭喜您注册成功");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
			
			
		} catch (UserExistExcepiton e) {
			//4 如果service处理不成功 用户已经存在则 跳回注册页面 显示注册用户存在
			form.getErrors().put("username", "注册用户已经存在");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
		
			e.printStackTrace();
		}catch(Exception e){
			//5 如果service处理不成功 原因是其他问题  跳转到网站全局消息显示页面 显示友好错误消息

			e.printStackTrace();
			request.setAttribute("message", "服务器出现未知错误");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
			
		}
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
