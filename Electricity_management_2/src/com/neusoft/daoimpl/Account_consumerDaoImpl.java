package com.neusoft.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.dao.Account_consumerDao;
import com.neusoft.entity.Account_consumer;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Rule;
import com.neusoft.utils.DaoException;
import com.neusoft.utils.UtilC3P0;

public class Account_consumerDaoImpl implements Account_consumerDao {
	QueryRunner qr = new QueryRunner();
	Connection conn = null;
	
	public Account_consumerDaoImpl(){
		try {
			conn = UtilC3P0.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public boolean addAccount_consumerDao(Account_consumer consumer) throws DaoException {
		try {
			String sql = "insert into Account_consumer(loginname,password,registertime,lastlogintime,ip) values( ?, ?,?,?,?)";
			int count = qr.update(conn, sql, consumer.getLoginname(),consumer.getPassword(),consumer.getRegistertime(),consumer.getLastlogintime(),consumer.getIp());
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

	@Override
	public boolean deleteAccount_consumerDao(Account_consumer consumer) throws DaoException {
		try {
			String sql = "delete from Account_consumer where id=?";
			int count = qr.update(conn, sql, consumer.getId());
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

	@Override
	public boolean changeAccount_consumerDao(Account_consumer consumer) throws DaoException {
		// TODO Auto-generated method stub
		try {
			String sql = "update  Account_consumer set   loginname=?,password=?,registertime=?,lastlogintime=?,ip=? where id=?";
			int count = qr.update(conn, sql,consumer.getLoginname(),consumer.getPassword(),consumer.getRegistertime(),consumer.getLastlogintime(),consumer.getIp(),consumer.getId());
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

	@Override
	public List<Account_consumer> showAccount_consumerAll() throws DaoException {
		String sql = "select id,loginname,password,registertime,lastlogintime,ip from Account_consumer order by id";
		List<Account_consumer> list = null;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Account_consumer>(Account_consumer.class));
			System.out.println("��ѯ�ɹ�");
			System.out.println(list);
		} catch (SQLException e) {
			throw new DaoException("��ѯʧ��!",e);
		}
		return list;
	}
	
	
	@Override
	public PageModel<Account_consumer> getPageModel(int pageNo, int pageSize) throws DaoException {
		QueryRunner qRunner= new  QueryRunner();
		PageModel<Account_consumer> model=null;
		Connection conn = null;
		 try {
			conn  =	UtilC3P0.getConnection();
			//��ѯ���м�¼
			String totalcount_sql ="select count(id) from Account_consumer ";
			//��ѯ�ܵļ�¼ ScalarHandler:��һ�е�һ������
			ResultSetHandler<Long> rsh = new ScalarHandler<Long>(); 
			Integer totalcount =  qRunner.query(conn,totalcount_sql, rsh).intValue();
			
			
			if(totalcount>0) {
				model= new PageModel<Account_consumer>();
				//��PageModel ��ֵ  ���м�¼
				model.setTotalcount(totalcount);
				//��ҳ��ѯ
				String sql ="select id,loginname,password,registertime,lastlogintime,ip  from   Account_consumer limit ?,? ";
				
				ResultSetHandler<List<Account_consumer>> RSH = new BeanListHandler<Account_consumer>(Account_consumer.class);
				Object [] params = {(pageNo-1)*pageSize,pageSize};
				if(conn.isClosed()) {
					conn  =	UtilC3P0.getConnection();
				}
				List<Account_consumer> msgs  = qRunner.query(conn, sql, RSH,params);
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
