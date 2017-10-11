package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Orderinfo;
import com.neusoft.utils.DaoException;

public interface OrderinfoDao {
		//添加类别
		public boolean addOrderinfo(Orderinfo orderinfo) throws DaoException;
		//删除类别
		public boolean deleteOrderinfo(Orderinfo orderinfo) throws DaoException;	
		//修改类别
		public boolean changeOrderinfo(Orderinfo orderinfo) throws DaoException;
		//查询所有
		public List<Orderinfo> showOrderinfoAll() throws DaoException;
}
