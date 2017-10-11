package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.DaoException;


public interface CateDao {
	//������
	public boolean insertCate(Cate cate) throws DaoException;
	//ɾ�����
	public boolean deleteCate(Cate cate) throws DaoException;	
	//�޸����
	public boolean changeCate(Cate cate) throws DaoException;
	//��ѯ���
	public Cate findCate(Cate cate) throws DaoException;
	//��ѯ����
	public List<Cate> showCateAll() throws DaoException;
	//��ҳ

	public PageModel<Cate> getPageModel(int  pageNo,int pageSize)throws DaoException;
	

	
}
