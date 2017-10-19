package com.neusoft.accountimpl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.neusoft.accountdao.AccountDao;
import com.neusoft.accountdao.DaoException;
import com.neusoft.entity.Account;
import com.neusoft.utils.UtilC3P0;

/**
 * oracle AccountDao实现
 * @author Administrator
 *
 */
public class AccountDaoImpl implements AccountDao {

	Connection conn = null;
	QueryRunner qr = new QueryRunner();
	
	public AccountDaoImpl() {
		try {
			conn = UtilC3P0.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Account doLogin(Account mAcc) throws DaoException {
		Account acc = null;
		String sql = "select id,username,password,ip, logindate from account where username = ? and password = ?";
		try {
			acc = qr.query(conn, sql, new BeanHandler<Account>(Account.class), mAcc.getUsername(),mAcc.getPassword());
		} catch (SQLException e) {
			throw new DaoException("查询用户信息出错",e);
		}
		return acc;
	}

	@Override
	public boolean updateAccount(Account acc) throws DaoException {
		String sql = "update account set ip = ? where id = ?";
		try{
			int count = qr.update(conn, sql, acc.getIp(),acc.getId());
			if(count>0){
				return true;
			}
		}catch (SQLException e) {
			throw new DaoException("修改用户信息出错",e);
		}
		return false;
	}



//	@Override
//	public Account doLogin(Account mAcc) throws DaoException {
//		String sql = "select * from account where username = ? and password = ?";
//		try {
//			System.out.println(username + " " + password);
//			Account acc = qr.query(UtilC3P0.getConnection(), sql, new BeanHandler<Account>(Account.class), username,password);
//			//System.out.println(acc);
//			if(acc != null){
//				return true;
//			}
//		} catch (SQLException e) {
//			throw new DaoException("查询用户信息出错",e);
//		}
//		return false;
//	}


//	
//@Override
//	public boolean doLogin(String username, String password) throws DaoException {
//		String sql = "select * from accounts where username = ? and password = ?";
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		Connection conn = null;
//		try {
//			conn = DbUtil.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, username);
//			pstmt.setString(2, password);
//			rs = pstmt.executeQuery();
//			if(rs.next()){
//				System.out.println("a");
//				return true;
//			}
//		} catch (SQLException e) {
//			throw new DaoException("查询用户信息出错",e);
//		}
//		return false;
//	}
//	
	

//	public static void main(String[] args) {
//		System.out.println(new AccountDaoImpl().doLogin("admin", "admin"));
//	}
}
