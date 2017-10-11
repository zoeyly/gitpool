package com.neusoft.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.neusoft.dao.Account_consumerDao;
import com.neusoft.entity.Account_consumer;
import com.neusoft.entity.Cate;
import com.neusoft.utils.DaoException;
import com.neusoft.utils.UtilC3P0;

public class Account_consumerDaoImpl implements Account_consumerDao {
	QueryRunner qr = new QueryRunner();
	Connection conn = null;
	
	public Account_consumerDaoImpl(){
		try {
			conn = UtilC3P0.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public boolean addAccount_consumerDao(Account_consumer consumer) throws DaoException {
		try {
			String sql = "insert into Account_consumer(loginname,password,registertime,lastlogintime,ip) values( ?, ?,?,?,?)";
			int count = qr.update(conn, sql, consumer.getLoginname(),consumer.getPassword(),consumer.getRegistertime(),consumer.getLastlogintime(),consumer.getIp());
				if(count>0){
					System.out.println("插入成功");
					System.out.println(count);
					return true;
				}
				
		} catch (SQLException e) {
			throw new DaoException("插入类别失败!",e);
		}	
		return false;
	}

	@Override
	public boolean deleteAccount_consumerDao(Account_consumer consumer) throws DaoException {
		try {
			String sql = "delete from Account_consumer where id=?";
			int count = qr.update(conn, sql, consumer.getId());
				if(count>0){
					System.out.println("删除成功");
					System.out.println(count);
					return true;
				}
		} catch (SQLException e) {
			throw new DaoException("删除失败!",e);
		}	
		return false;
	}

	@Override
	public boolean changeAccount_consumerDao(Account_consumer consumer) throws DaoException {
		// TODO Auto-generated method stub
		try {
			String sql = "update  Account_consumer set   loginname=?,password=?,registertime=?,lastlogintime=?,ip=? where id=?";
			int count = qr.update(conn, sql,consumer.getLoginname(),consumer.getPassword(),consumer.getRegistertime(),consumer.getLastlogintime(),consumer.getIp(),consumer.getId());
				if(count>0){
					System.out.println("修改成功");
					System.out.println(count);
					return true;
				}
		} catch (SQLException e) {
			throw new DaoException("修改失败!",e);
		}	
		return false;
	}

	@Override
	public List<Account_consumer> showAccount_consumerAll() throws DaoException {
		String sql = "select id,loginname,password,registertime,lastlogintime,ip from Account_consumer order by id";
		List<Account_consumer> list = null;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Account_consumer>(Account_consumer.class));
			System.out.println("查询成功");
			System.out.println(list);
		} catch (SQLException e) {
			throw new DaoException("查询失败!",e);
		}
		return list;
	}
	

	

}
