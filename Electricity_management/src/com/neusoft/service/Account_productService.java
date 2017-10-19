package com.neusoft.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.DbUtils;

import com.neusoft.dao.Account_productDao;
import com.neusoft.dao.RuleDao;
import com.neusoft.entity.Account_product;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Rule;
import com.neusoft.utils.DaoException;
import com.neusoft.utils.DaoFactory;
import com.neusoft.utils.UtilC3P0;

public class Account_productService {
	
	public void zhuceproduct(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		Account_product consumer=new Account_product(loginname, password, 0,0, null);
		System.out.println(loginname);
		boolean flag = addproduct(consumer);
		if(flag){
			System.out.println(111);
			response.sendRedirect("login/index.jsp");
		}else{
			System.out.println(2221);
		}
	}
	
	public void addproduct(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		String sregistertime = request.getParameter("registertime");
		Integer registertime=Integer.parseInt(sregistertime);
		String slastlogintime = request.getParameter("lastlogintime");
		Integer lastlogintime=Integer.parseInt(slastlogintime);
		String ip = request.getParameter("ip");
	
		Account_product consumer=new Account_product(loginname, password, registertime, lastlogintime, ip);
		boolean flag = addproduct(consumer);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findProduct.jsp");
		}else{
			System.out.println(2221);
		}
	}
	
	//添加
	private boolean addproduct(Account_product consumer){
		Connection conn = null;
		boolean flag = false;
		Account_productDao account_consumerDao=DaoFactory.getInstance("accproductdao",Account_productDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = account_consumerDao.addAccount_productDao(consumer);
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
	
	
	
	public void deleteproduct(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String cid = request.getParameter("id");
		Integer id=Integer.parseInt(cid);
		Account_product consumer=new Account_product(id);
		boolean flag = deleteproduct(consumer);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findProduct.jsp");
		}else{
			System.out.println(222);
		}
	}
	//删除
	private boolean deleteproduct(	Account_product  consumer){
		Connection conn = null;
		boolean flag = false;
		Account_productDao account_consumerDao=DaoFactory.getInstance("accproductdao",Account_productDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = account_consumerDao.deleteAccount_productDao(consumer);
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
	
	
	
	public void changeproduct(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String sid = request.getParameter("id");
		Integer id=Integer.parseInt(sid);
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		String sregistertime = request.getParameter("registertime");
		Integer registertime=Integer.parseInt(sregistertime);
		String slastlogintime = request.getParameter("lastlogintime");
		Integer lastlogintime=Integer.parseInt(slastlogintime);
		String ip = request.getParameter("ip");
	
		Account_product consumer=new Account_product(id,loginname, password, registertime, lastlogintime, ip);
		boolean flag = changeproduct(consumer);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findProduct.jsp");
		}else{
			System.out.println(2221);
		}
	}
	
	//添加
	private boolean changeproduct(Account_product consumer){
		Connection conn = null;
		boolean flag = false;
		Account_productDao account_consumerDao=DaoFactory.getInstance("accproductdao",Account_productDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = account_consumerDao.changeAccount_productDao(consumer);
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
	
	


	public List<Account_product> showproductAll() {
		Account_productDao account_consumerDao=DaoFactory.getInstance("accproductdao",Account_productDao.class);
		return account_consumerDao.showAccount_productAll();
	}
	
	
public Account_product login(Account_product mAcc){
		
		Connection conn = null;
		Account_productDao acc = null;
		try {
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			acc = DaoFactory.getInstance("accproductdao", Account_productDao.class);
			
			mAcc = acc.doLogin(mAcc);
			if(mAcc!=null){
				mAcc.setIp(mAcc.getIp());
			}
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(conn);
		}
		
		return mAcc;
	}


public void getMsgsLogic(HttpServletRequest request,HttpServletResponse response) throws DaoException,ServletException,IOException{
	String pageNo=request.getParameter("pageNo");
	String pageSize=request.getParameter("pageSize");
	try {
		int _pageNo=Integer.parseInt(pageNo);
		int _pageSize=Integer.parseInt(pageSize);
		PageModel<Account_product>  cates=getPageModel(_pageNo,_pageSize);
		if(cates!=null) {
			//总页数
			int totalPageSize= (cates.getTotalcount()%_pageSize==0?cates.getTotalcount()/_pageSize:cates.getTotalcount()/_pageSize+1);
			cates.setTotalPageSize(totalPageSize);
			cates.setPageNo(_pageNo);
		}
		request.setAttribute("cates", cates);
//		request.getRequestDispatcher("Cate.jsp").forward(request, response);
		request.getRequestDispatcher("background/listACCProduct.jsp").forward(request, response);
	}catch(NumberFormatException e) {
		e.printStackTrace();
	}
}

/**
 * 分页查询
 */
public PageModel<Account_product> getPageModel(int pageNo,int pageSize) throws DaoException{
	Account_productDao account_consumerDao=DaoFactory.getInstance("accproductdao",Account_productDao.class);

	return account_consumerDao.getPageModel(pageNo, pageSize);
}

public static void main(String[] args) {
 System.out.println(	new RuleService().getPageModel(2, 2));
}

}
