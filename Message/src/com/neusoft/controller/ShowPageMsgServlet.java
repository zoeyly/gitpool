package com.neusoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.MessageBoard;
import com.neusoft.service.MessageBoardService;
import com.neusoft.utils.PageModel;

/**
 * Servlet implementation class ShowPageMsgServlet
 */
@WebServlet("/page")
public class ShowPageMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPageMsgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pageNo = 1;
		int pageSize = 5;
		
		String pageNoString = request.getParameter("pageNo");
		if(pageNoString != null && !"".equals(pageNoString)){
			pageNo = Integer.parseInt(pageNoString);
		}
		
		
		MessageBoardService mbs = new MessageBoardService();
		PageModel<MessageBoard> pm = mbs.showPageModel(pageNo, pageSize);
		int totalPageNo = (pm.getTotalRecords()%pageSize==0?pm.getTotalRecords()/pageSize:pm.getTotalRecords()/pageSize+1);
		pm.setTotalPageNo(totalPageNo);
		pm.setPageSize(pageSize);
		pm.setPageNo(pageNo);
		request.setAttribute("mb", pm);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
