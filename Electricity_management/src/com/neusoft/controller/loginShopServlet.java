package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Shoppinginfo;
import com.neusoft.service.ProductService;
import com.neusoft.service.ShoppinginfoService;
import com.neusoft.utils.DaoException;

/**
 * Servlet implementation class loginShopServlet
 */
@WebServlet("/loginShopServlet")
public class loginShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginShopServlet() {
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
		
		String said = request.getParameter("aid");
		Integer aid=Integer.parseInt(said);
		String nickname = request.getParameter("nickname");
		
		double money=Double.parseDouble((request.getParameter("price"))); 
		
		
		Shoppinginfo product=new Shoppinginfo(aid, nickname, money);
		ShoppinginfoService service=new ShoppinginfoService();
		boolean flag = service.addShoppinginfo(product);
		if(flag){
			System.out.println(111);
			response.sendRedirect("cate.jsp");
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
