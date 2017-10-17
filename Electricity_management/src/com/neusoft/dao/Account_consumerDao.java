package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Account_consumer;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.DaoException;

public interface Account_consumerDao {
	//添加类别
	public boolean addAccount_consumerDao(Account_consumer account_consumerDao) throws DaoException;
	//删除类别
	public boolean deleteAccount_consumerDao(Account_consumer account_consumerDao) throws DaoException;	
	//修改类别
	public boolean changeAccount_consumerDao(Account_consumer account_consumerDao) throws DaoException;
	//查询所有
	public List<Account_consumer> showAccount_consumerAll() throws DaoException;
	public PageModel<Account_consumer> getPageModel(int pageNo, int pageSize);
}
