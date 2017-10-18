package com.neusoft.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.Account_product;
import com.neusoft.service.Account_productService;

/**
 * Servlet implementation class newLoginServlet
 */
@WebServlet("/newLoginServlet")
public class newLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newLoginServlet() {
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
		PrintWriter pw = response.getWriter();
		String _username = request.getParameter("loginname");
		String _password = request.getParameter("password");
			
			System.out.println(_username + " " + _password);
			
			Account_product mAcc = new Account_product();
			mAcc.setLoginname(_username);
			mAcc.setPassword(_password);
			mAcc.setIp(request.getRemoteAddr());
			
			if(_username !=null || _username != "" && _password !=null || _password != ""){
				 mAcc = new Account_productService().login(mAcc);
			}
			if(mAcc!=null){
				String isCheck = request.getParameter("checkbox");
				System.out.println(isCheck);
				if(isCheck != null && isCheck.equals("1")){
					//±‡¬Î
					Cookie use_ck = new Cookie("username",URLEncoder.encode(_username,"utf-8"));
					use_ck.setMaxAge(7*24*60*60);
					//º”√‹  
					/*Cookie psw_ck = new Cookie("password",MD5Utils.GetMD5Code(_password));*/
					Cookie psw_ck = new Cookie("password",_password);
				/*	System.out.println(MD5Utils.GetMD5Code(_password));*/
					psw_ck.setMaxAge(7*24*60*60);
					response.addCookie(use_ck);
					response.addCookie(psw_ck);
				}	
				
					HttpSession httpSession=request.getSession();
					httpSession.setAttribute("user", mAcc);
					
				request.setAttribute("username", _username);
				response.sendRedirect("login.jsp");
			}else{
				pw.append("<script> alert(\"unacc\")</script>");

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
