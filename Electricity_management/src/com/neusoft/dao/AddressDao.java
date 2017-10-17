package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.DaoException;


public interface AddressDao {
	//添加类别
	public boolean addAddress(Address address) throws DaoException;
	//删除类别
	public boolean deleteAddress(Address address) throws DaoException;	
	//修改类别
	public boolean changeAddress(Address address) throws DaoException;
	//查询所有
	public List<Address> showAddressAll() throws DaoException;
	public PageModel<Address> getPageModel(int pageNo, int pageSize) throws DaoException;

	
}
