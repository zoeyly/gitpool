package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Account;
import com.neusoft.entity.Account_product;
import com.neusoft.utils.DaoException;

public interface Account_productDao {
	//������
	public boolean addAccount_productDao(Account_product account_consumerDao) throws DaoException;
	//ɾ�����
	public boolean deleteAccount_productDao(Account_product account_consumerDao) throws DaoException;	
	//�޸����
	public boolean changeAccount_productDao(Account_product account_consumerDao) throws DaoException;
	//��ѯ����
	public List< Account_product> showAccount_productAll() throws DaoException;
	
	//�û� ��¼
	public Account_product doLogin(Account_product mAcc) throws DaoException;

	public boolean updateAccount(Account_product mAcc)throws DaoException;
}
