package com.neusoft.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

import com.neusoft.dao.AccountDao;
import com.neusoft.entity.Account;
import com.neusoft.utils.DaoFactory;
import com.neusoft.utils.UtilC3P0;

public class LoginService {

	public LoginService() {
	}
	
		/*System.out.println(1);
		System.out.println(username);
		System.out.println(password);*/
	
	public Account login(Account mAcc){
		
		Connection conn = null;
		AccountDao acc = null;
		try {
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			acc = DaoFactory.getInstance("accdaoimpl", AccountDao.class);
			
			mAcc = acc.doLogin(mAcc);
			if(mAcc!=null){
				mAcc.setIp(mAcc.getIp());
				mAcc.setLogindate(System.currentTimeMillis());
				acc.updateAccount(mAcc);
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

	
		
//		public Account login(Account mAcc){
//		AccountDao ad = DaoFactory.getInstance("accdaoimpl", AccountDao.class);
//		boolean flag = false;
//		try{
//			flag = ad.doLogin(mAcc);
//			System.out.println(flag);
//		}catch(DaoException e){
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		return mAcc;
//	}

/*	public static void main(String[] args) {
	new LoginService().login("admin", "admin");
	}
*/	
}
