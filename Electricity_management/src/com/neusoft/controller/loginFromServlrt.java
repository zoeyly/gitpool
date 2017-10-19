package com.neusoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Product;
import com.neusoft.entity.Shoppinginfo;
import com.neusoft.service.ProductService;
import com.neusoft.service.ShoppinginfoService;

/**
 * Servlet implementation class loginFromServlrt
 */
@WebServlet("/loginFromServlrt")
public class loginFromServlrt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginFromServlrt() {
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
		ShoppinginfoService productService=new ShoppinginfoService();
		List<Shoppinginfo> flag =productService.showShoppinginfoAll();
		if(flag!=null){
			request.setAttribute("flag", flag);
			System.out.println(111);
		//	response.sendRedirect("cate1.jsp");u
 		request.getRequestDispatcher("from.jsp").forward(request, response);
		}else{
			System.out.println(2221);
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
