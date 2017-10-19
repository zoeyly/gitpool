package com.neusoft.dao;

import com.neusoft.entity.Account;
import com.neusoft.entity.PageModel;

/**
 * Dao�ӿ�
 * */
public interface AccountDao {

	 
	/**		��¼			*/
	public boolean getAccount(String username,String psw) throws DaoException;
	/**		ע��			*/
	public boolean insertAccount(Account acc) throws DaoException;
	/**		��ҳ			*/
	public PageModel getAccountByPage(int pageNo,int pageSize) throws DaoException;
	
}
