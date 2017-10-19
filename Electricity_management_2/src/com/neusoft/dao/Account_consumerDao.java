package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Account_consumer;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.DaoException;

public interface Account_consumerDao {
	//������
	public boolean addAccount_consumerDao(Account_consumer account_consumerDao) throws DaoException;
	//ɾ�����
	public boolean deleteAccount_consumerDao(Account_consumer account_consumerDao) throws DaoException;	
	//�޸����
	public boolean changeAccount_consumerDao(Account_consumer account_consumerDao) throws DaoException;
	//��ѯ����
	public List<Account_consumer> showAccount_consumerAll() throws DaoException;
	public PageModel<Account_consumer> getPageModel(int pageNo, int pageSize);
}
