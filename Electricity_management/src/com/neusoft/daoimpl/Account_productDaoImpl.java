package com.neusoft.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.neusoft.dao.Account_productDao;
import com.neusoft.entity.Account_product;
import com.neusoft.utils.DaoException;
import com.neusoft.utils.UtilC3P0;

public class Account_productDaoImpl implements Account_productDao {
	QueryRunner qr = new QueryRunner();
	Connection conn = null;
	
	public Account_productDaoImpl(){
		try {
			conn = UtilC3P0.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	@Override
	public boolean addAccount_productDao(Account_product product) throws DaoException {
		try {
			String sql = "insert into Account_product(loginname,password,registertime,lastlogintime,ip) values( ?, ?,?,?,?)";
			int count = qr.update(conn, sql, product.getLoginname(),product.getPassword(),product.getRegistertime(),product.getLastlogintime(),product.getIp());
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
	public boolean deleteAccount_productDao(Account_product product) throws DaoException {
		try {
			String sql = "delete from Account_product where id=?";
			int count = qr.update(conn, sql, product.getId());
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
	public boolean changeAccount_productDao(Account_product product) throws DaoException {
		try {
			String sql = "update  Account_product set   loginname=?,password=?,registertime=?,lastlogintime=?,ip=? where id=?";
			int count = qr.update(conn, sql,product.getLoginname(),product.getPassword(),product.getRegistertime(),product.getLastlogintime(),product.getIp(),product.getId());
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
	public List<Account_product> showAccount_productAll() throws DaoException {
		String sql = "select id,loginname,password,registertime,lastlogintime,ip from Account_product order by id";
		List<Account_product> list = null;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Account_product>(Account_product.class));
			System.out.println("查询成功");
			System.out.println(list);
		} catch (SQLException e) {
			throw new DaoException("查询失败!",e);
		}
		return list;
	}



	@Override
	public Account_product doLogin(Account_product mAcc) throws DaoException {
		Account_product acc = null;
		String sql = "select id,loginname,password,ip from Account_product where loginname = ? and password = ?";
		try {
			acc = qr.query(conn, sql, new BeanHandler<Account_product>(Account_product.class), mAcc.getLoginname(),mAcc.getPassword());
		} catch (SQLException e) {
			throw new DaoException("查询用户信息出错",e);
		}
		return acc;
	}



	@Override
	public boolean updateAccount(Account_product mAcc) throws DaoException {
		String sql = "update Account_product set ip = ?where id = ?";
		try{
			int count = qr.update(conn, sql, mAcc.getIp(),mAcc.getId());
			if(count>0){
				return true;
			}
		}catch (SQLException e) {
			throw new DaoException("修改用户信息出错",e);
		}
		return false;
	}


	

}
