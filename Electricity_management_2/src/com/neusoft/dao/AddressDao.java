package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.DaoException;


public interface AddressDao {
	//������
	public boolean addAddress(Address address) throws DaoException;
	//ɾ�����
	public boolean deleteAddress(Address address) throws DaoException;	
	//�޸����
	public boolean changeAddress(Address address) throws DaoException;
	//��ѯ����
	public List<Address> showAddressAll() throws DaoException;
	public PageModel<Address> getPageModel(int pageNo, int pageSize) throws DaoException;

	
}
