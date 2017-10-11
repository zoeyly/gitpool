package com.neusoft.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.DbUtils;

import com.neusoft.dao.CateDao;
import com.neusoft.dao.ProductDao;
import com.neusoft.dao.ShoppinginfoDao;
import com.neusoft.entity.Cate;
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
		String slasttime = request.getParameter("lasttime");
		Integer lasttime=Integer.parseInt(slasttime);
		
		Shoppinginfo product=new Shoppinginfo(aid, nickname, money, lasttime);
		boolean flag = addShoppinginfo(product);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findShoppinginfo.jsp");
		}else{
			System.out.println(2221);
		}
	}
	
	//Ìí¼Ó
	private boolean addShoppinginfo(Shoppinginfo product){
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
	//É¾³ý
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
	
	//Ìí¼Ó
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
	
}
