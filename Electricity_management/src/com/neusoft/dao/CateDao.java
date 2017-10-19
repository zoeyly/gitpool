package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.DaoException;


public interface CateDao {
	//添加类别
	public boolean insertCate(Cate cate) throws DaoException;
	//删除类别
	public boolean deleteCate(Cate cate) throws DaoException;	
	//修改类别
	public boolean changeCate(Cate cate) throws DaoException;
	//查询类别
	public Cate findCate(Cate cate) throws DaoException;
	//查询所有
	public List<Cate> showCateAll() throws DaoException;
	//分页

	public PageModel<Cate> getPageModel(int  pageNo,int pageSize)throws DaoException;
	

	
}
