package com.neusoft.dao;

import com.neusoft.entity.Account;
import com.neusoft.utils.DaoException;

/**
 * �ʻ�dao
 * @author Administrator
 *
 */
public interface AccountDao {

	public Account doLogin(Account mAcc) throws DaoException;

	public boolean updateAccount(Account mAcc)throws DaoException;
}
