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
		System.out.println("aaa");
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
	
		String said = request.getParameter("aid");
		Integer aid=Integer.parseInt(said);
		String nickname = request.getParameter("nickname");
		System.out.println("价格"+request.getParameter("price"));
		double money=Double.parseDouble((request.getParameter("price"))); 
		String pname = request.getParameter("pname");
		System.out.println("商品的名字为:"+pname);
		request.setAttribute("aid", aid);
		request.setAttribute("nickname", pname);
		request.setAttribute("pname", pname);
		System.out.println(aid+""+ nickname+""+ money+""+pname);
		Shoppinginfo product=new Shoppinginfo(aid, nickname, money);
		ShoppinginfoService service=new ShoppinginfoService();
		boolean flag = service.addShoppinginfo(product);
		if(flag){
			System.out.println(111);
			request.getRequestDispatcher("shop.jsp").forward(request, response);
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
