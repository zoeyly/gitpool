package com.neusoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Account_product;
import com.neusoft.entity.Address;
import com.neusoft.service.Account_productService;
import com.neusoft.service.AddressService;
import com.neusoft.utils.DaoException;

/**
 * Servlet implementation class findAccount_productServlet
 */
@WebServlet("/findAccount_productServlet")
public class findAccount_productServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findAccount_productServlet() {
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
		Account_productService mbs = new Account_productService();
		System.out.println(1111);
		try{
			List<Account_product> list=mbs.showproductAll();
			System.out.println(list);
			request.setAttribute("all", list);
			request.getRequestDispatcher("findProduct.jsp").forward(request, response);
		}catch(DaoException e){
			request.setAttribute("error", e.getMessage());
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
