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
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.DaoException;
import com.neusoft.utils.DaoFactory;
import com.neusoft.utils.UtilC3P0;

public class CateService {
	
	public void addCate(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String cname = request.getParameter("cname");
		String spid = request.getParameter("pid");
		Integer pid=Integer.parseInt(spid);
		if(cname == null || cname.equals("")){
			throw new DaoException("cname不能为空");
		}
		Cate cate = new Cate(cname, pid);
		boolean flag = addCate(cate);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findCate.jsp");
		}else{
			System.out.println(2221);
		}
	}
	
	//添加
	private boolean addCate(Cate cate){
		Connection conn = null;
		boolean flag = false;
		CateDao cateDao = DaoFactory.getInstance("catedao",CateDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = cateDao.insertCate(cate);
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
	
	public void deleteCate(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String cpid = request.getParameter("cid");
		Cate cates=new Cate();
		Integer cid=Integer.parseInt(cpid);
		Cate cate = new Cate(cid);
		boolean flag = deleteCate(cate);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findCate.jsp");
		}else{
			System.out.println(222);
		}
	}
	//删除
	private boolean deleteCate(Cate cate){
		Connection conn = null;
		boolean flag = false;
		CateDao cateDao = DaoFactory.getInstance("catedao",CateDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = cateDao.deleteCate(cate);
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
	


	public List<Cate> showCateAll(){
		CateDao mbd = DaoFactory.getInstance("catedao", CateDao.class);
		return mbd.showCateAll();
	}


	public void changeCate(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String scid = request.getParameter("cid");
		Integer cid=Integer.parseInt(scid);
		String cname = request.getParameter("cname");
		String spid = request.getParameter("pid");
		Integer pid=Integer.parseInt(spid);
		
		if(cname == null || cname.equals("")){
			throw new DaoException("cname不能为空");
		}
		Cate cate = new Cate(cid,cname, pid);
		boolean flag = changeCate(cate);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findCate.jsp");
		}else{
			System.out.println(2221);
		}
	}
	

	private boolean changeCate(Cate cate){
		Connection conn = null;
		boolean flag = false;
		CateDao cateDao = DaoFactory.getInstance("catedao",CateDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = cateDao.changeCate(cate);
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

	
	public void getMsgsLogic(HttpServletRequest request,HttpServletResponse response) throws DaoException,ServletException,IOException{
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		try {
			int _pageNo=Integer.parseInt(pageNo);
			int _pageSize=Integer.parseInt(pageSize);
			PageModel<Cate>  cates=getPageModel(_pageNo,_pageSize);
			if(cates!=null) {
				//总页数
				int totalPageSize= (cates.getTotalcount()%_pageSize==0?cates.getTotalcount()/_pageSize:cates.getTotalcount()/_pageSize+1);
				cates.setTotalPageSize(totalPageSize);
				cates.setPageNo(_pageNo);
			}
			request.setAttribute("cates", cates);
//			request.getRequestDispatcher("Cate.jsp").forward(request, response);
			request.getRequestDispatcher("background/listCate.jsp").forward(request, response);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 分页查询
	 */
	public PageModel<Cate> getPageModel(int pageNo,int pageSize) throws DaoException{
		CateDao cateDao = DaoFactory.getInstance("catedao",CateDao.class);
	
		return cateDao.getPageModel(pageNo, pageSize);
	}

	public static void main(String[] args) {
	 System.out.println(	new CateService().getPageModel(2, 2));
	}
}
