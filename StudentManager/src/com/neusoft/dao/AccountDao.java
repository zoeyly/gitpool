package com.neusoft.dao;

import com.neusoft.entity.Account;
import com.neusoft.entity.PageModel;

/**
 * Dao½Ó¿Ú
 * */
public interface AccountDao {

	 
	/**		µÇÂ¼			*/
	public boolean getAccount(String username,String psw) throws DaoException;
	/**		×¢²á			*/
	public boolean insertAccount(Account acc) throws DaoException;
	/**		·ÖÒ³			*/
	public PageModel getAccountByPage(int pageNo,int pageSize) throws DaoException;
	
}
