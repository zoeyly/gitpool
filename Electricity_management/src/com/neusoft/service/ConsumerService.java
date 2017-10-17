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
import com.neusoft.dao.AddressDao;
import com.neusoft.dao.ProductDao;
import com.neusoft.dao.RuleDao;
import com.neusoft.dao.ShoppinginfoDao;
import com.neusoft.entity.Account_consumer;
import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.entity.Rule;
import com.neusoft.entity.Shoppinginfo;
import com.neusoft.utils.DaoException;
import com.neusoft.utils.DaoFactory;
import com.neusoft.utils.UtilC3P0;

public class ConsumerService {
	public void addConsumer(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		String sregistertime = request.getParameter("registertime");
		Integer registertime=Integer.parseInt(sregistertime);
		String slastlogintime = request.getParameter("lastlogintime");
		Integer lastlogintime=Integer.parseInt(slastlogintime);
		String ip = request.getParameter("ip");
	
		Account_consumer consumer=new Account_consumer(loginname, password, registertime, lastlogintime, ip);
		boolean flag = addConsumer(consumer);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findConsumer.jsp");
		}else{
			System.out.println(2221);
		}
	}
	
	//添加
	private boolean addConsumer(Account_consumer consumer){
		Connection conn = null;
		boolean flag = false;
		Account_consumerDao account_consumerDao=DaoFactory.getInstance("consumerdao",Account_consumerDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = account_consumerDao.addAccount_consumerDao(consumer);
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
	
	
	
	public void deleteConsumer(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String cid = request.getParameter("id");
		Integer id=Integer.parseInt(cid);
		Account_consumer consumer=new Account_consumer(id);
		boolean flag = deleteConsumer(consumer);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findConsumer.jsp");
		}else{
			System.out.println(222);
		}
	}
	//删除
	private boolean deleteConsumer(	Account_consumer  consumer){
		Connection conn = null;
		boolean flag = false;
		Account_consumerDao account_consumerDao=DaoFactory.getInstance("consumerdao",Account_consumerDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = account_consumerDao.deleteAccount_consumerDao(consumer);
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
	
	
	
	public void changeConsumer(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String sid = request.getParameter("id");
		Integer id=Integer.parseInt(sid);
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		String sregistertime = request.getParameter("registertime");
		Integer registertime=Integer.parseInt(sregistertime);
		String slastlogintime = request.getParameter("lastlogintime");
		Integer lastlogintime=Integer.parseInt(slastlogintime);
		String ip = request.getParameter("ip");
	
		Account_consumer consumer=new Account_consumer(id,loginname, password, registertime, lastlogintime, ip);
		boolean flag = changeConsumer(consumer);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/listConsumer.jsp");
		}else{
			System.out.println(2221);
		}
	}
	
	//添加
	private boolean changeConsumer(Account_consumer consumer){
		Connection conn = null;
		boolean flag = false;
		Account_consumerDao account_consumerDao=DaoFactory.getInstance("consumerdao",Account_consumerDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = account_consumerDao.changeAccount_consumerDao(consumer);
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
	
	


	public List<Account_consumer> showConsumerAll() {
		Account_consumerDao account_consumerDao=DaoFactory.getInstance("consumerdao",Account_consumerDao.class);
		return account_consumerDao.showAccount_consumerAll();
	}
	
	
	public void getMsgsLogic(HttpServletRequest request,HttpServletResponse response) throws DaoException,ServletException,IOException{
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		try {
			int _pageNo=Integer.parseInt(pageNo);
			int _pageSize=Integer.parseInt(pageSize);
			PageModel<Account_consumer>  cates=getPageModel(_pageNo,_pageSize);
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
	public PageModel<Account_consumer> getPageModel(int pageNo,int pageSize) throws DaoException{
		Account_consumerDao account_consumerDao=DaoFactory.getInstance("consumerdao",Account_consumerDao.class);
		return account_consumerDao.getPageModel(pageNo, pageSize);
	}

	public static void main(String[] args) {
	 System.out.println(	new ConsumerService().getPageModel(2, 2));
	}
	
	
}
