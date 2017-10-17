package com.neusoft.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.dao.Account_productDao;
import com.neusoft.entity.Account_product;
import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.DaoException;
import com.neusoft.utils.UtilC3P0;

public class Account_productDaoImpl implements Account_productDao {
	QueryRunner qr = new QueryRunner();
	Connection conn = null;
	
	public Account_productDaoImpl(){
		try {
			conn = UtilC3P0.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	@Override
	public boolean addAccount_productDao(Account_product product) throws DaoException {
		try {
			String sql = "insert into Account_product(loginname,password,registertime,lastlogintime,ip) values( ?, ?,?,?,?)";
			int count = qr.update(conn, sql, product.getLoginname(),product.getPassword(),product.getRegistertime(),product.getLastlogintime(),product.getIp());
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
	public boolean deleteAccount_productDao(Account_product product) throws DaoException {
		try {
			String sql = "delete from Account_product where id=?";
			int count = qr.update(conn, sql, product.getId());
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
	public boolean changeAccount_productDao(Account_product product) throws DaoException {
		try {
			String sql = "update  Account_product set   loginname=?,password=?,registertime=?,lastlogintime=?,ip=? where id=?";
			int count = qr.update(conn, sql,product.getLoginname(),product.getPassword(),product.getRegistertime(),product.getLastlogintime(),product.getIp(),product.getId());
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
	public List<Account_product> showAccount_productAll() throws DaoException {
		String sql = "select id,loginname,password,registertime,lastlogintime,ip from Account_product order by id";
		List<Account_product> list = null;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Account_product>(Account_product.class));
			System.out.println("��ѯ�ɹ�");
			System.out.println(list);
		} catch (SQLException e) {
			throw new DaoException("��ѯʧ��!",e);
		}
		return list;
	}



	@Override
	public Account_product doLogin(Account_product mAcc) throws DaoException {
		Account_product acc = null;
		String sql = "select id,loginname,password,ip from Account_product where loginname = ? and password = ?";
		try {
			acc = qr.query(conn, sql, new BeanHandler<Account_product>(Account_product.class), mAcc.getLoginname(),mAcc.getPassword());
		} catch (SQLException e) {
			throw new DaoException("��ѯ�û���Ϣ����",e);
		}
		return acc;
	}



	@Override
	public boolean updateAccount(Account_product mAcc) throws DaoException {
		String sql = "update Account_product set ip = ?where id = ?";
		try{
			int count = qr.update(conn, sql, mAcc.getIp(),mAcc.getId());
			if(count>0){
				return true;
			}
		}catch (SQLException e) {
			throw new DaoException("�޸��û���Ϣ����",e);
		}
		return false;
	}


	@Override
	public PageModel<Account_product> getPageModel(int pageNo, int pageSize) throws DaoException {
		QueryRunner qRunner= new  QueryRunner();
		PageModel<Account_product> model=null;
		Connection conn = null;
		 try {
			conn  =	UtilC3P0.getConnection();
			//��ѯ���м�¼
			String totalcount_sql ="select count(id) from Account_product ";
			//��ѯ�ܵļ�¼ ScalarHandler:��һ�е�һ������
			ResultSetHandler<Long> rsh = new ScalarHandler<Long>(); 
			Integer totalcount =  qRunner.query(conn,totalcount_sql, rsh).intValue();
			
			
			if(totalcount>0) {
				model= new PageModel<Account_product>();
				//��PageModel ��ֵ  ���м�¼
				model.setTotalcount(totalcount);
				//��ҳ��ѯ
				String sql ="select id,loginname,password,ip from   Account_product limit ?,? ";
				
				ResultSetHandler<List<Account_product>> RSH = new BeanListHandler<Account_product>(Account_product.class);
				Object [] params = {(pageNo-1)*pageSize,pageSize};
				if(conn.isClosed()) {
					conn  =	UtilC3P0.getConnection();
				}
				List<Account_product> msgs  = qRunner.query(conn, sql, RSH,params);
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
