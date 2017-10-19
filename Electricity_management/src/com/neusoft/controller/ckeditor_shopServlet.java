package com.neusoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.Product;
import com.neusoft.service.ProductService;
import com.neusoft.utils.DaoException;

/**
 * Servlet implementation class ckeditor_shopServlet
 */
@WebServlet("/ckeditor_shopServlet")
public class ckeditor_shopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ckeditor_shopServlet() {
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
		ProductService mbs = new ProductService();
		System.out.println(1111);
		try{
			System.out.println(1111);
			List<Product> list=mbs.showProductAll();
			System.out.println(1111);
			System.out.println(list);
			
			HttpSession httpSession=request.getSession();
			httpSession.setAttribute("shop", list);
			
			request.setAttribute("all", list);
			request.getRequestDispatcher("shop.jsp").forward(request, response);
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
