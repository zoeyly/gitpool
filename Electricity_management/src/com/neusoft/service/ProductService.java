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
import com.neusoft.daoimpl.ProductDaoImpl;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.utils.DaoException;
import com.neusoft.utils.DaoFactory;
import com.neusoft.utils.UtilC3P0;

public class ProductService {

	
	public void addProduct(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String pname = request.getParameter("pname");
		
		String scid = request.getParameter("cid");
		Integer cid=Integer.parseInt(scid);
		String pno = request.getParameter("pno");
		String pic = request.getParameter("pic");
		String sprice = request.getParameter("price");
		Integer price=Integer.parseInt(sprice);
		String sonline = request.getParameter("online");
		Integer online=Integer.parseInt(sonline);
		String pdetail = request.getParameter("pdetail");
		
		if(pname == null || pname.equals("")){
			throw new DaoException("cname不能为空");
		}
		Product product=new Product(pname, cid, pno, pic, price, online, pdetail);
		boolean flag = addProduct(product);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findShop.jsp");
		}else{
			System.out.println(2221);
		}
	}
	
	//添加
	private boolean addProduct(Product product){
		Connection conn = null;
		boolean flag = false;
		ProductDao productDao=DaoFactory.getInstance("productdao", ProductDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = productDao.insertProduct(product);
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
	
	
	
	public void deleteShop(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String cid = request.getParameter("id");
		Integer id=Integer.parseInt(cid);
		Product product=new Product(id);
		boolean flag = deleteShop(product);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findShop.jsp");
		}else{
			System.out.println(222);
		}
	}
	//删除
	private boolean deleteShop(	Product product){
		Connection conn = null;
		boolean flag = false;
		ProductDao productDao=DaoFactory.getInstance("productdao", ProductDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = productDao.deleteProduct(product);
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
	
	
	
	public void changeProduct(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String sid = request.getParameter("id");
		Integer id=Integer.parseInt(sid);
		String pname = request.getParameter("pname");
		String scid = request.getParameter("cid");
		Integer cid=Integer.parseInt(scid);
		String pno = request.getParameter("pno");
		String pic = request.getParameter("pic");
		String sprice = request.getParameter("price");
		Integer price=Integer.parseInt(sprice);
		String sonline = request.getParameter("online");
		Integer online=Integer.parseInt(sonline);
		String pdetail = request.getParameter("pdetail");
		
		if(pname == null || pname.equals("")){
			throw new DaoException("cname不能为空");
		}
		Product product=new Product(id,pname, cid, pno, pic, price, online, pdetail);
		boolean flag = changeProduct(product);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findShop.jsp");
		}else{
			System.out.println(2221);
		}
	}
	
	//添加
	private boolean changeProduct(Product product){
		Connection conn = null;
		boolean flag = false;
		ProductDao productDao=DaoFactory.getInstance("productdao", ProductDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = productDao.changeProduct(product);
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
	
	


	public List<Product> showProductAll() {
		ProductDao productDao=DaoFactory.getInstance("productdao", ProductDao.class);
		return productDao.showProductAll();
	}
	
	
	
	public void getMsgsLogic(HttpServletRequest request,HttpServletResponse response) throws DaoException,ServletException,IOException{
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		try {
			int _pageNo=Integer.parseInt(pageNo);
			int _pageSize=Integer.parseInt(pageSize);
			PageModel<Product>  cates=getPageModel(_pageNo,_pageSize);
			if(cates!=null) {
				//总页数
				int totalPageSize= (cates.getTotalcount()%_pageSize==0?cates.getTotalcount()/_pageSize:cates.getTotalcount()/_pageSize+1);
				cates.setTotalPageSize(totalPageSize);
				cates.setPageNo(_pageNo);
			}
			request.setAttribute("cates", cates);
//			request.getRequestDispatcher("Cate.jsp").forward(request, response);
			request.getRequestDispatcher("background/listShop.jsp").forward(request, response);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 分页查询
	 */
	public PageModel<Product> getPageModel(int pageNo,int pageSize) throws DaoException{
		ProductDao productDao=DaoFactory.getInstance("productdao", ProductDao.class);
	
		return productDao.getPageModel(pageNo, pageSize);
	}
	

	


	public List<Product> findProduct(Product cid){
		Connection conn = null;
		List<Product> flag = null;
		ProductDao productDao=DaoFactory.getInstance("productdao", ProductDao.class);
		try{
			conn = UtilC3P0.getConnection();
			
			flag = productDao.findProduct(cid);
		
		}catch(DaoException e){
		
			System.out.println(e.getMessage());
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}


	
}
