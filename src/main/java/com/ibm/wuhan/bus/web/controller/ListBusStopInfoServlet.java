package com.ibm.wuhan.bus.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.wuhan.bus.domain.BusLineInfo;
import com.ibm.wuhan.bus.service.impl.BusLineBusinessService;

/**
 * Servlet implementation class ListBusStopInfoServlet
 */
@WebServlet("/bus/ListBusStopInfoServlet")
public class ListBusStopInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBusStopInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		BusLineBusinessService service = new BusLineBusinessService();
		BusLineInfo buslineinfo = service.findBus(id);
//		System.out.println(buslineinfo.toString());
//		System.out.println(buslineinfo.getBusstopinfo());
		//Map mapstop = buslineinfo.getBusstopinfo();

		request.getSession().setAttribute("buslininfo", buslineinfo);
		response.sendRedirect("ListStopInfoUIServlet");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
