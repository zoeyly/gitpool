package com.neusoft.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.dao.CateDao;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.DaoException;
import com.neusoft.utils.UtilC3P0;

public  class CateDaoImpl implements CateDao {
	
	QueryRunner qr = new QueryRunner();
	Connection conn = null;
	private static List<Cate> showCateld ;
	
	public CateDaoImpl(){
		try {
			conn = UtilC3P0.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//������
	@Override
	public boolean insertCate(Cate cate) throws DaoException {
		try {
			String sql = "insert into Cate(cname,pid) values( ?, ?)";
			int count = qr.update(conn, sql, cate.getCname(),cate.getPid());
				if(count>0){
					System.out.println("����ɹ�");
					System.out.println(count);
					return true;
				}
				
		} catch (SQLException e) {
			throw new DaoException("�������ʧ��!",e);
		}	
		return false;
	}
	//ɾ�����
	@Override
	public boolean deleteCate(Cate cate) throws DaoException {
		// TODO Auto-generated method stub
		try {
			String sql = "delete from cate where cid=?";
			int count = qr.update(conn, sql, cate.getCid());
				if(count>0){
					System.out.println("ɾ���ɹ�");
					System.out.println(count);
					return true;
				}
		} catch (SQLException e) {
			throw new DaoException("ɾ��ʧ��!",e);
		}	
		return false;
	}
	
	//�޸����
	@Override
	public boolean changeCate(Cate cate) throws DaoException {
		// TODO Auto-generated method stub
		try {
			String sql = "update  cate set   cname=?,pid=? where cid=?";
			int count = qr.update(conn, sql, cate.getCname(),cate.getPid(),cate.getCid());
				if(count>0){
					System.out.println("�޸ĳɹ�");
					System.out.println(count);
					return true;
				}
		} catch (SQLException e) {
			throw new DaoException("�޸�ʧ��!",e);
		}	
		return false;
	}
	//��ѯ���
	@Override
	public Cate findCate(Cate cate) throws DaoException {
		// TODO Auto-generated method stub
		Cate count =null;
		try {
			String sql = "select   cid,cname,pid  from cate  where cid=?";
		    count = qr.query(conn, sql, new BeanHandler<Cate>(Cate.class), cate.getCid());
			System.out.println("��ѯ�ɹ�");
			System.out.println(count);
		} catch (SQLException e) {
			throw new DaoException("��ѯʧ��!",e);
		}	
		return count;
	}
	

	@Override
	public List<Cate> showCateAll() throws DaoException {
		String sql = "select cid,cname,pid from cate order by cid";
		List<Cate> list = null;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Cate>(Cate.class));
			System.out.println("��ѯ�ɹ�");
			System.out.println(list);
		} catch (SQLException e) {
			throw new DaoException("��ѯʧ��!",e);
		}
		return list;
	}

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public PageModel<Cate> getPageModel(int pageNo, int pageSize) throws DaoException {
		QueryRunner qRunner= new  QueryRunner();
		PageModel<Cate> model=null;
		Connection conn = null;
		 try {
			conn  =	UtilC3P0.getConnection();
			//��ѯ���м�¼
			String totalcount_sql ="select count(cid) from cate ";
			//��ѯ�ܵļ�¼ ScalarHandler:��һ�е�һ������
			ResultSetHandler<Long> rsh = new ScalarHandler<Long>(); 
			Integer totalcount =  qRunner.query(conn,totalcount_sql, rsh).intValue();
			
			
			if(totalcount>0) {
				model= new PageModel<Cate>();
				//��PageModel ��ֵ  ���м�¼
				model.setTotalcount(totalcount);
				//��ҳ��ѯ
				String sql ="select cid,cname,pid from   cate limit ?,? ";
				
				ResultSetHandler<List<Cate>> RSH = new BeanListHandler<Cate>(Cate.class);
				Object [] params = {(pageNo-1)*pageSize,pageSize};
				
				List<Cate> msgs  = qRunner.query(conn, sql, RSH,params);
				//��PageModel ��ֵ   ÿҳ��ʾ����
				model.setDatas(msgs);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("��ҳ��ѯ����",e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
		return model;
	}


}
