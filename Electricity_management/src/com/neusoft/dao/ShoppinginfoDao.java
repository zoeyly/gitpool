package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.Shoppinginfo;
import com.neusoft.utils.DaoException;


public interface ShoppinginfoDao {
	public boolean insertShoppinginfo(Shoppinginfo shoppinginfo) throws DaoException;
	public boolean deleteShoppinginfo(Shoppinginfo shoppinginfo) throws DaoException;	
	public boolean changeShoppinginfo(Shoppinginfo shoppinginfo) throws DaoException;
	public List<Shoppinginfo> showShoppinginfoAll() throws DaoException;
	public PageModel<Shoppinginfo> getPageModel(int pageNo, int pageSize);
	
//	public Cate findProduct(Product cate) throws DaoException;
//	public PageModel<Product> showPro(int pageNo, int pageSize) throws DaoException;
//	public int getProTotalRecords() throws DaoException;

	
}
