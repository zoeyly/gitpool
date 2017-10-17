package com.neusoft.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.DbUtils;

import com.neusoft.dao.ProductDao;
import com.neusoft.dao.RuleDao;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.entity.Rule;
import com.neusoft.utils.DaoException;
import com.neusoft.utils.DaoFactory;
import com.neusoft.utils.UtilC3P0;

public class RuleService {

	
	public void addRule(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String spid = request.getParameter("pid");
		Integer pid=Integer.parseInt(spid);
		String size = request.getParameter("size");
	
		Rule rule=new Rule(pid, size);
		boolean flag = addRule(rule);
		System.out.println(111);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findRule.jsp");
		}else{
			System.out.println(2221);
		}
	}
	
	//添加
	private boolean addRule(Rule rule){
		Connection conn = null;
		boolean flag = false;
		RuleDao ruleDao=DaoFactory.getInstance("ruledaoimpl", RuleDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = ruleDao.addRule(rule);
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
	
	
	
	public void deleteRule(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String cid = request.getParameter("id");
		Integer id=Integer.parseInt(cid);
		Rule rule=new Rule(id);
		boolean flag = deleteRule(rule);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findRule.jsp");
		}else{
			System.out.println(222);
		}
	}
	//删除
	private boolean deleteRule(	Rule rule){
		Connection conn = null;
		boolean flag = false;
		RuleDao ruleDao=DaoFactory.getInstance("ruledao", RuleDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = ruleDao.deleteRule(rule);
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
	
	
	
	public void changeRule(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String sid = request.getParameter("id");
		Integer id=Integer.parseInt(sid);
		String spid = request.getParameter("pid");
		Integer pid=Integer.parseInt(spid);
		String size = request.getParameter("size");
		

		Rule rule=new Rule(id, pid, size);
		boolean flag = changeRule(rule);
		if(flag){
			System.out.println(111);
			response.sendRedirect("background/findRule.jsp");
		}else{
			System.out.println(2221);
		}
	}
	
	//添加
	private boolean changeRule(Rule rule){
		Connection conn = null;
		boolean flag = false;
		RuleDao ruleDao=DaoFactory.getInstance("ruledao", RuleDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = ruleDao.changeRule(rule);
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
	
	


	public List<Rule> showRuleAll() {
		RuleDao ruleDao=DaoFactory.getInstance("ruledao", RuleDao.class);
		return ruleDao.showRuleAll();
	}


	
	public void getMsgsLogic(HttpServletRequest request,HttpServletResponse response) throws DaoException,ServletException,IOException{
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		try {
			int _pageNo=Integer.parseInt(pageNo);
			int _pageSize=Integer.parseInt(pageSize);
			PageModel<Rule>  cates=getPageModel(_pageNo,_pageSize);
			if(cates!=null) {
				//总页数
				int totalPageSize= (cates.getTotalcount()%_pageSize==0?cates.getTotalcount()/_pageSize:cates.getTotalcount()/_pageSize+1);
				cates.setTotalPageSize(totalPageSize);
				cates.setPageNo(_pageNo);
			}
			request.setAttribute("cates", cates);
//			request.getRequestDispatcher("Cate.jsp").forward(request, response);
			request.getRequestDispatcher("background/listRule.jsp").forward(request, response);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 分页查询
	 */
	public PageModel<Rule> getPageModel(int pageNo,int pageSize) throws DaoException{
		RuleDao ruleDao=DaoFactory.getInstance("ruledao", RuleDao.class);
	
		return ruleDao.getPageModel(pageNo, pageSize);
	}

	public static void main(String[] args) {
	 System.out.println(	new RuleService().getPageModel(2, 2));
	}
	
}
