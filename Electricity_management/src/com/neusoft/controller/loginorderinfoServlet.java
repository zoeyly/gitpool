package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Orderinfo;
import com.neusoft.service.LoginService;
import com.neusoft.service.OrderinfoService;

/**
 * Servlet implementation class loginorderinfoServlet
 */
@WebServlet("/loginorderinfoServlet")
public class loginorderinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginorderinfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("aaa");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String orderno = request.getParameter("orderno");
		String saddrinfo = request.getParameter("addrinfo");
		Integer addrinfo=Integer.parseInt(saddrinfo);
		String mask = request.getParameter("mask");
		OrderinfoService service = new OrderinfoService();
		Orderinfo orderinfo=new Orderinfo(orderno,addrinfo, mask);
		System.out.println(orderno+""+addrinfo+""+ mask);
		boolean flag =service.loginaddOrderinfo(orderinfo);
	
			System.out.println(111);
			response.sendRedirect("from.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
