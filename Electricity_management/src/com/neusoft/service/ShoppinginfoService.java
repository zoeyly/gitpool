package com.neusoft.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.DbUtils;

import com.neusoft.dao.Account_consumerDao;
import com.neusoft.dao.CateDao;
import com.neusoft.dao.ProductDao;
import com.neusoft.dao.ShoppinginfoDao;
import com.neusoft.entity.Account_consumer;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.entity.Shoppinginfo;
import com.neusoft.utils.DaoException;
import com.neusoft.utils.DaoFactory;
import com.neusoft.utils.UtilC3P0;

public class ShoppinginfoService {

	public void addShoppinginfo(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String said = request.getParameter("aid");
		Integer aid=Integer.parseInt(said);
		String nickname = request.getParameter("nickname");
		String smoney = request.getParameter("money");
		Integer money=Integer.parseInt(smoney);
		
		
		Shoppinginfo product=new Shoppinginfo(aid, nickname, money);
		boolean flag = addShoppinginfo(product);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findShoppinginfo.jsp");
		}else{
			System.out.println(2221);
		}
	}
	
	//添加
	public boolean addShoppinginfo(Shoppinginfo product){
		Connection conn = null;
		boolean flag = false;
		ShoppinginfoDao productDao=DaoFactory.getInstance("Shoppinginfo", ShoppinginfoDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = productDao.insertShoppinginfo(product);
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
	
	
	
	public void deleteShoppinginfo(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String cid = request.getParameter("id");
		Integer id=Integer.parseInt(cid);
		Shoppinginfo product=new Shoppinginfo(id);
		boolean flag = deleteShoppinginfo(product);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findShoppinginfo.jsp");
		}else{
			System.out.println(222);
		}
	}
	//删除
	private boolean deleteShoppinginfo(	Shoppinginfo product){
		Connection conn = null;
		boolean flag = false;
		ShoppinginfoDao productDao=DaoFactory.getInstance("Shoppinginfo", ShoppinginfoDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = productDao.deleteShoppinginfo(product);
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
	
	
	
	public void changeShoppinginfo(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String sid = request.getParameter("id");
		Integer id=Integer.parseInt(sid);
		String said = request.getParameter("aid");
		Integer aid=Integer.parseInt(said);
		String nickname = request.getParameter("nickname");
		String smoney = request.getParameter("money");
		Integer money=Integer.parseInt(smoney);
		String slasttime = request.getParameter("lasttime");
		Integer lasttime=Integer.parseInt(slasttime);
		

		Shoppinginfo product=new Shoppinginfo(id, aid, nickname, money, lasttime);
		boolean flag = changeShoppinginfo(product);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findShoppinginfo.jsp");
		}else{
			System.out.println(2221);
		}
	}
	
	//添加
	private boolean changeShoppinginfo(Shoppinginfo product){
		Connection conn = null;
		boolean flag = false;
		ShoppinginfoDao productDao=DaoFactory.getInstance("Shoppinginfo", ShoppinginfoDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = productDao.changeShoppinginfo(product);
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
	
	


	public List<Shoppinginfo> showShoppinginfoAll() {
		ShoppinginfoDao productDao=DaoFactory.getInstance("Shoppinginfo", ShoppinginfoDao.class);
		return productDao.showShoppinginfoAll();
	}

	public void getMsgsLogic(HttpServletRequest request,HttpServletResponse response) throws DaoException,ServletException,IOException{
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		try {
			int _pageNo=Integer.parseInt(pageNo);
			int _pageSize=Integer.parseInt(pageSize);
			PageModel<Shoppinginfo>  cates=getPageModel(_pageNo,_pageSize);
			if(cates!=null) {
				//总页数
				int totalPageSize= (cates.getTotalcount()%_pageSize==0?cates.getTotalcount()/_pageSize:cates.getTotalcount()/_pageSize+1);
				cates.setTotalPageSize(totalPageSize);
				cates.setPageNo(_pageNo);
			}
			request.setAttribute("cates", cates);
//			request.getRequestDispatcher("Cate.jsp").forward(request, response);
			request.getRequestDispatcher("background/listShopinfo.jsp").forward(request, response);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 分页查询
	 */
	public PageModel<Shoppinginfo> getPageModel(int pageNo,int pageSize) throws DaoException{
		ShoppinginfoDao productDao=DaoFactory.getInstance("Shoppinginfo", ShoppinginfoDao.class);
		return productDao.getPageModel(pageNo, pageSize);
	}

	public static void main(String[] args) {
	 System.out.println(	new ShoppinginfoService().getPageModel(2, 2));
	}
	
	
}
