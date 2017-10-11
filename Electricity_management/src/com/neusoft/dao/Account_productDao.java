package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Account;
import com.neusoft.entity.Account_product;
import com.neusoft.utils.DaoException;

public interface Account_productDao {
	//添加类别
	public boolean addAccount_productDao(Account_product account_consumerDao) throws DaoException;
	//删除类别
	public boolean deleteAccount_productDao(Account_product account_consumerDao) throws DaoException;	
	//修改类别
	public boolean changeAccount_productDao(Account_product account_consumerDao) throws DaoException;
	//查询所有
	public List< Account_product> showAccount_productAll() throws DaoException;
	
	//用户 登录
	public Account_product doLogin(Account_product mAcc) throws DaoException;

	public boolean updateAccount(Account_product mAcc)throws DaoException;
}
