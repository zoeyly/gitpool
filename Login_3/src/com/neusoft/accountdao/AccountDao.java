package com.neusoft.accountdao;

import com.neusoft.entity.Account;

/**
 * �ʻ�dao
 * @author Administrator
 *
 */
public interface AccountDao {

	public Account doLogin(Account mAcc) throws DaoException;

	public boolean updateAccount(Account mAcc)throws DaoException;
}
