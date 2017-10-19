package com.neusoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Product;
import com.neusoft.service.ProductService;

/**
 * Servlet implementation class loginCateServlet
 */
@WebServlet("/loginCate")
public class loginCateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginCateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		request.getParameter("cid");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		ProductService productService=new ProductService();
		String scid = request.getParameter("cid");
		Integer cid=Integer.parseInt(scid);
		Product product=new Product();
		product.setCid(cid);
		List<Product> flag =productService.findProduct(product);
		
		if(flag!=null){
			request.setAttribute("flag", flag);
			System.out.println(111);
		//	response.sendRedirect("cate1.jsp");u
 		request.getRequestDispatcher("cate1.jsp").forward(request, response);
		}else{
			System.out.println(2221);
		}
//		productService.findProduct(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
