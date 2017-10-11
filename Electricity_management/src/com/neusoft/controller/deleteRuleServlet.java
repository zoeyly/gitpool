package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.service.ProductService;
import com.neusoft.service.RuleService;
import com.neusoft.utils.DaoException;

/**
 * Servlet implementation class deleteRuleServlet
 */
@WebServlet("/deleteRuleServlet")
public class deleteRuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteRuleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		request.getRequestDispatcher("deleteRule.jsp").forward(request,response);

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		RuleService ruleService = new RuleService();
		try{
			ruleService.deleteRule(request, response);
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
