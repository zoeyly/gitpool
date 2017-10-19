package com.neusoft.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

import com.neusoft.dao.AccountDao;
import com.neusoft.dao.Account_productDao;
import com.neusoft.entity.Account;
import com.neusoft.entity.Account_product;
import com.neusoft.utils.DaoFactory;
import com.neusoft.utils.UtilC3P0;

public class CkeditorService {

	public CkeditorService() {
	}
	
		/*System.out.println(1);
		System.out.println(username);
		System.out.println(password);*/
	
	public Account_product login(Account_product mAcc){
		
		Connection conn = null;
		Account_productDao acc = null;
		try {
			conn = UtilC3P0.getConnection();
			conn.setAutoCommit(false);
			acc = DaoFactory.getInstance("accproductdao", Account_productDao.class);
			
			mAcc = acc.doLogin(mAcc);
			
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
