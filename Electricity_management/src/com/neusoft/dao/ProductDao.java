package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.utils.DaoException;


public interface ProductDao {
	public boolean insertProduct(Product product) throws DaoException;
	public boolean deleteProduct(Product product) throws DaoException;	
	public boolean changeProduct(Product product) throws DaoException;
	public List<Product> showProductAll() throws DaoException;
	public PageModel<Product> getPageModel(int pageNo, int pageSize) throws DaoException;
	
	public List<Product> findProduct(Product cid) throws DaoException;

	
}
