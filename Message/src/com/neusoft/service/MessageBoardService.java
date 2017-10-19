package com.neusoft.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.DbUtils;

import com.neusoft.dao.DaoException;
import com.neusoft.dao.DaoFactory;
import com.neusoft.dao.MessageBoardDao;
import com.neusoft.entity.MessageBoard;
import com.neusoft.utils.PageModel;
import com.neusoft.utils.UtilC3P0;

public class MessageBoardService {
	
	/**
	 * 添加业务逻辑
	 */
	public void addMsg(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServletException, IOException {
		String name = request.getParameter("msg_nickname");
		String email = request.getParameter("msg_email");
		String title = request.getParameter("msg_title");
		String content = request.getParameter("msg_content");
		
		if(name == null || name.equals("")){
			throw new DaoException("用户名不能为空");
		}
		
		if(email == null || email.equals("")){
			throw new DaoException("邮箱不能为空");
		}
		
		if(title == null || title.equals("")){
			throw new DaoException("标题不能为空");
		}
		
		if(content == null || content.equals("")){
			throw new DaoException("内容不能为空");
		}
		
		MessageBoard mb = new MessageBoard(name,email,title,content);
		mb.setIp(request.getRemoteAddr());
		
		System.out.println(3333);
		
		boolean flag = addMessage(mb);
		if(flag){
			System.out.println(111);
			response.sendRedirect("page");
		}else{
			System.out.println(2221);
			response.sendRedirect("page");
		}
	
	}
	
	
	
	
	private boolean addMessage(MessageBoard mb){
		Connection conn = null;
		boolean flag = false;
		MessageBoardDao mbd = DaoFactory.getInstance("messagedao", MessageBoardDao.class);
		try{
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			flag = mbd.insertMessage(mb);
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
	
	public List<MessageBoard> showMsgAll(){
		MessageBoardDao mbd = DaoFactory.getInstance("messagedao", MessageBoardDao.class);
		return mbd.showMsgAll();
	}
	
	public PageModel<MessageBoard> showPageModel(int pageNo,int pageSize){
		MessageBoardDao mbd = DaoFactory.getInstance("messagedao", MessageBoardDao.class);
		PageModel<MessageBoard> mb = mbd.showPro(pageNo, pageSize);
		return mb;
	}
}
