package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Address;
import com.neusoft.service.AddressService;
import com.neusoft.utils.DaoException;

/**
 * Servlet implementation class loginAddressServlet
 */
@WebServlet("/loginAddressServlet")
public class loginAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		System.out.println("loginAddressServlet");
		
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String area = request.getParameter("county");
		if(area==null&& area.equals("")) {
			area=null;
		}
		System.out.println(province+":"+city+":"+ area);
		
		Address address=new Address(province, city, area);
		AddressService addressService=new AddressService();
		
		boolean flag =addressService.addAddress(address);
		
	
			response.sendRedirect("seccress.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
