package com.neusoft.service;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.DbUtils;

import com.neusoft.dao.OrderinfoDao;
import com.neusoft.dao.RuleDao;
import com.neusoft.entity.Orderinfo;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Rule;
import com.neusoft.utils.DaoException;
import com.neusoft.utils.DaoFactory;
import com.neusoft.utils.UtilC3P0;

public class OrderinfoService {
	public void addOrderinfo(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String orderno = request.getParameter("orderno");
		String sorderstatus = request.getParameter("orderstatus");
		Integer orderstatus=Integer.parseInt(sorderstatus);
		String spaystatus = request.getParameter("paystatus");
		Integer paystatus=Integer.parseInt(spaystatus);
		String sordertime = request.getParameter("ordertime");
		Integer ordertime=Integer.parseInt(sordertime);
		String spaytime = request.getParameter("paytime");
		Integer paytime=Integer.parseInt(spaytime);
		String saddrinfo = request.getParameter("addrinfo");
		Integer addrinfo=Integer.parseInt(saddrinfo);
		String mask = request.getParameter("mask");
	
		Orderinfo orderinfo=new Orderinfo(orderno, orderstatus, paystatus, ordertime, paytime, addrinfo, mask);
		boolean flag = addOrderinfo(orderinfo);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findOrderinfo.jsp");
		}else{
			System.out.println(2221);
		}
	}
	
	//添加
	private boolean addOrderinfo(Orderinfo orderinfo){
		Connection conn = null;
		boolean flag = false;
		OrderinfoDao orderinfoDao=DaoFactory.getInstance("ordertimedao", OrderinfoDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = orderinfoDao.addOrderinfo(orderinfo);
			if(flag){
				conn.commit();
				return true;
			}
		}catch(DaoException e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
		}catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(conn);
		}
		return false;
	}
	
	
	
	public void deleteOrderinfo(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String cid = request.getParameter("id");
		Integer id=Integer.parseInt(cid);
		Orderinfo orderinfo=new Orderinfo(id);
		boolean flag = deleteOrderinfo(orderinfo);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findOrderinfo.jsp");
		}else{
			System.out.println(222);
		}
	}
	//删除
	private boolean deleteOrderinfo(	Orderinfo orderinfo){
		Connection conn = null;
		boolean flag = false;
		OrderinfoDao orderinfoDao=DaoFactory.getInstance("ordertimedao", OrderinfoDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = orderinfoDao.deleteOrderinfo(orderinfo);
			if(flag){
				conn.commit();
				return true;
			}
		}catch(DaoException e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
		}catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(conn);
		}
		return false;
	}
	
	
	
	public void changeOrderinfo(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String sid = request.getParameter("id");
		Integer id=Integer.parseInt(sid);
		String orderno = request.getParameter("orderno");
		String sorderstatus = request.getParameter("orderstatus");
		Integer orderstatus=Integer.parseInt(sorderstatus);
		String spaystatus = request.getParameter("paystatus");
		Integer paystatus=Integer.parseInt(spaystatus);
		String sordertime = request.getParameter("ordertime");
		Integer ordertime=Integer.parseInt(sordertime);
		String spaytime = request.getParameter("paytime");
		Integer paytime=Integer.parseInt(spaytime);
		String saddrinfo = request.getParameter("addrinfo");
		Integer addrinfo=Integer.parseInt(saddrinfo);
		String mask = request.getParameter("mask");
		
		Orderinfo orderinfo =new Orderinfo(id, orderno, orderstatus, paystatus, ordertime, paytime, addrinfo, mask);

		boolean flag = changeOrderinfo(orderinfo);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findOrderinfo.jsp");
		}else{
			System.out.println(2221);
		}
	}
	
	//添加
	private boolean changeOrderinfo(Orderinfo orderinfo){
		Connection conn = null;
		boolean flag = false;
		OrderinfoDao orderinfoDao=DaoFactory.getInstance("ordertimedao", OrderinfoDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag =orderinfoDao.changeOrderinfo(orderinfo);
			if(flag){
				conn.commit();
				return true;
			}
		}catch(DaoException e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
		}catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(conn);
		}
		return false;
	}
	
	


	public List<Orderinfo> showOrderinfoAll() {
		OrderinfoDao orderinfoDao=DaoFactory.getInstance("ordertimedao", OrderinfoDao.class);
		return orderinfoDao.showOrderinfoAll();
	}

	public void getMsgsLogic(HttpServletRequest request,HttpServletResponse response) throws DaoException,ServletException,IOException{
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		try {
			int _pageNo=Integer.parseInt(pageNo);
			int _pageSize=Integer.parseInt(pageSize);
			PageModel<Orderinfo>  cates=getPageModel(_pageNo,_pageSize);
			if(cates!=null) {
				//总页数
				int totalPageSize= (cates.getTotalcount()%_pageSize==0?cates.getTotalcount()/_pageSize:cates.getTotalcount()/_pageSize+1);
				cates.setTotalPageSize(totalPageSize);
				cates.setPageNo(_pageNo);
			}
			request.setAttribute("cates", cates);
//			request.getRequestDispatcher("Cate.jsp").forward(request, response);
			request.getRequestDispatcher("background/listOrderinfo.jsp").forward(request, response);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 分页查询
	 */
	public PageModel<Orderinfo> getPageModel(int pageNo,int pageSize) throws DaoException{
		OrderinfoDao orderinfoDao=DaoFactory.getInstance("ordertimedao", OrderinfoDao.class);
	
		return orderinfoDao.getPageModel(pageNo, pageSize);
	}

	public static void main(String[] args) {
	 System.out.println(	new OrderinfoService().getPageModel(2, 2));
	}
	
}
