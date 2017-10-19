package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Orderinfo;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.DaoException;

public interface OrderinfoDao {
		//�������
		public boolean addOrderinfo(Orderinfo orderinfo) throws DaoException;
		//ɾ�����
		public boolean deleteOrderinfo(Orderinfo orderinfo) throws DaoException;	
		//�޸����
		public boolean changeOrderinfo(Orderinfo orderinfo) throws DaoException;
		//��ѯ����
		public List<Orderinfo> showOrderinfoAll() throws DaoException;
		
		public PageModel<Orderinfo> getPageModel(int pageNo, int pageSize) throws DaoException;
		boolean loginaddOrderinfo(Orderinfo orderinfo) throws DaoException;
}