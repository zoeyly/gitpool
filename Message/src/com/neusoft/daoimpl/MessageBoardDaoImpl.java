package com.neusoft.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.dao.DaoException;
import com.neusoft.dao.MessageBoardDao;
import com.neusoft.entity.MessageBoard;
import com.neusoft.utils.PageModel;
import com.neusoft.utils.UtilC3P0;

public class MessageBoardDaoImpl implements MessageBoardDao {
	QueryRunner qr = new QueryRunner();
	Connection conn = null;
	
	public MessageBoardDaoImpl(){
		try {
			conn = UtilC3P0.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public boolean insertMessage(MessageBoard mbd) throws DaoException {
		try {
			
			String sql = "insert into MessageBoard(id,nickname,email,title,content,messagetime,ip) values(seq_mbd.nextval, ?, ?, ?, ?,sysdate,?)";
			int count = qr.update(conn, sql, mbd.getNickname(),mbd.getEmail(),mbd.getTitle(),mbd.getContent(),mbd.getIp());
			if(count>0){
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException("≤Â»Î¡Ù—‘ ß∞‹!",e);
		}
		return false;
	}

	@Override
	public List<MessageBoard> showMsgAll() throws DaoException {
		String sql = "select id,nickname,email,title,content,messagetime,ip from MessageBoard order by id";
		List<MessageBoard> list = null;
		try {
			list = qr.query(conn, sql, new BeanListHandler<MessageBoard>(MessageBoard.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public PageModel<MessageBoard> showPro(int pageNo, int pageSize) throws DaoException {
		PageModel<MessageBoard> pageModel = new PageModel<MessageBoard>();
		List<MessageBoard> list = new ArrayList<MessageBoard>();
		try {
			conn = UtilC3P0.getConnection();
			StringBuffer sbSql = new StringBuffer();
			sbSql.append("select id,nickname,email,title,content,messagetime,ip from ")
				.append("( ")
				.append("select rownum as rn, t.* ")
				.append("from ( ")
				.append("select * from MessageBoard order by id desc ")
				.append(") t where rownum <=? ")
				.append(") where rn>? ");
			list = qr.query(conn, sbSql.toString(), new BeanListHandler<MessageBoard>(MessageBoard.class), pageNo * pageSize,(pageNo - 1) * pageSize);
			pageModel.setTotalRecords(getProTotalRecords());
			pageModel.setList(list);
		} catch (SQLException e) {
			throw new DaoException("∑÷“≥≤È—Ø ß∞‹!",e);
		}
		return pageModel;
	}

	@Override
	public int getProTotalRecords() throws DaoException {
		int num = 0;
		String sql = "select count(id) from MessageBoard";
		try {
			conn = UtilC3P0.getConnection();
			Object obj = qr.query(conn, sql, new ScalarHandler<Object>());
			num = Integer.parseInt(obj.toString());
			System.out.println(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public static void main(String[] args) {
		PageModel<MessageBoard> pm = new MessageBoardDaoImpl().showPro(2,5);
		List<MessageBoard> list = pm.getList();
		for(int i=0; i<list.size(); i++){
			MessageBoard mb = list.get(i);
			System.out.println(mb);
		}
	}

}
