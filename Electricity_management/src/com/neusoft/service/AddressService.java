package com.neusoft.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.DbUtils;

import com.neusoft.dao.AddressDao;
import com.neusoft.dao.RuleDao;
import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Rule;
import com.neusoft.utils.DaoException;
import com.neusoft.utils.DaoFactory;
import com.neusoft.utils.UtilC3P0;

public class AddressService {
	
	public void addAddress(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		System.out.println(province+":"+city+":"+ area);
		Address address=new Address(province, city, area);
		boolean flag = addAddress(address);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findAddress.jsp");
		}else{
			System.out.println(2221);
		}
	}
	
	//添加
	public boolean addAddress(Address address){
		Connection conn = null;
		boolean flag = false;
		AddressDao addressDao=DaoFactory.getInstance("addressdao",AddressDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = addressDao.addAddress(address);

		}catch(DaoException e){
			System.out.println(e.getMessage());
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
		}
		return false;
	}
	
	
	
	public void deleteAddress(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String cid = request.getParameter("id");
		Integer id=Integer.parseInt(cid);
		Address address=new Address(id);
		boolean flag = deleteAddress(address);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findAddress.jsp");
		}else{
			System.out.println(222);
		}
	}
	//删除
	private boolean deleteAddress(	Address address){
		Connection conn = null;
		boolean flag = false;
		AddressDao addressDao=DaoFactory.getInstance("addressdao",AddressDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = addressDao.deleteAddress(address);
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
	
	
	
	public void changeAddress(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String sid = request.getParameter("id");
		Integer id=Integer.parseInt(sid);
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		Address address=new Address(id, province, city, area);
		boolean flag = changeAddress(address);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findAddress.jsp");
		}else{
			System.out.println(2221);
		}
	}
	
	//添加
	private boolean changeAddress(Address address){
		Connection conn = null;
		boolean flag = false;
		AddressDao addressDao=DaoFactory.getInstance("addressdao",AddressDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = addressDao.changeAddress(address);
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
	
	


	public List<Address> showAddressAll() {
		AddressDao addressDao=DaoFactory.getInstance("addressdao",AddressDao.class);
		return addressDao.showAddressAll();
	}
	

	public void getMsgsLogic(HttpServletRequest request,HttpServletResponse response) throws DaoException,ServletException,IOException{
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		try {
			int _pageNo=Integer.parseInt(pageNo);
			int _pageSize=Integer.parseInt(pageSize);
			PageModel<Address>  cates=getPageModel(_pageNo,_pageSize);
			if(cates!=null) {
				//总页数
				int totalPageSize= (cates.getTotalcount()%_pageSize==0?cates.getTotalcount()/_pageSize:cates.getTotalcount()/_pageSize+1);
				cates.setTotalPageSize(totalPageSize);
				cates.setPageNo(_pageNo);
			}
			request.setAttribute("cates", cates);
//			request.getRequestDispatcher("Cate.jsp").forward(request, response);
			request.getRequestDispatcher("background/listAddress.jsp").forward(request, response);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 分页查询
	 */
	public PageModel<Address> getPageModel(int pageNo,int pageSize) throws DaoException{
		AddressDao addressDao=DaoFactory.getInstance("addressdao",AddressDao.class);
	
		return addressDao.getPageModel(pageNo, pageSize);
	}

	public static void main(String[] args) {
	 System.out.println(	new AddressService().getPageModel(2, 2));
	}
	
	
}
