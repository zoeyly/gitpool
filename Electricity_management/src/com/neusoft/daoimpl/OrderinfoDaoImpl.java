package com.neusoft.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.dao.OrderinfoDao;
import com.neusoft.entity.Orderinfo;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.utils.DaoException;
import com.neusoft.utils.UtilC3P0;

public class OrderinfoDaoImpl implements OrderinfoDao {

	QueryRunner qr = new QueryRunner();
	Connection conn = null;
	
	public OrderinfoDaoImpl(){
		try {
			conn = UtilC3P0.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean addOrderinfo(Orderinfo orderinfo) throws DaoException {
		try {
			String sql = "insert into orderinfo(orderno,orderstatus,paystatus,ordertime,paytime,addrinfo,mask) values( ?, ?,?,?,?,?,?)";
			int count = qr.update(conn, sql,orderinfo.getOrderno(),orderinfo.getOrderstatus(),orderinfo.getPaystatus(),orderinfo.getOrdertime(),orderinfo.getPaytime(),orderinfo.getAddrinfo(),orderinfo.getMask());
				if(count>0){
					System.out.println("���붩���ɹ�");
					System.out.println(count);
					return true;
				}
		} catch (SQLException e) {
			throw new DaoException("���붩��ʧ��!",e);
		}	
		return false;
	}

	@Override
	public boolean deleteOrderinfo(Orderinfo orderinfo) throws DaoException {
		try {
			
			String sql = "delete from orderinfo where id=?";
			int count = qr.update(conn, sql, orderinfo.getId());
				if(count>0){
					System.out.println("ɾ�������ɹ�");
					System.out.println(count);
					return true;
				}
		} catch (SQLException e) {
			throw new DaoException("ɾ������ʧ��!",e);
		}	
		return false;
	}

	@Override
	public boolean changeOrderinfo(Orderinfo orderinfo) throws DaoException {
		try {
			String sql = "update  orderinfo set   orderno=?,orderstatus=?,paystatus=?,ordertime=?,paytime=?,addrinfo=?,mask=?  where id=?";
			int count = qr.update(conn, sql,orderinfo.getOrderno(),orderinfo.getOrderstatus(),orderinfo.getPaystatus(),orderinfo.getOrdertime(),orderinfo.getPaytime(),orderinfo.getAddrinfo(),orderinfo.getMask(),orderinfo.getId());
				if(count>0){
					System.out.println("�޸Ķ����ɹ�");
					return true;
				}
		} catch (SQLException e) {
			throw new DaoException("�޸Ķ���ʧ��!",e);
		}	
		return false;
	}

	@Override
	public List<Orderinfo> showOrderinfoAll() throws DaoException {		
		String sql = "select id,orderno,orderstatus,paystatus,ordertime,paytime,addrinfo,mask from orderinfo order by id";
		List<Orderinfo> list = null;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Orderinfo>(Orderinfo.class));
			System.out.println("qqqqqqqq");
			System.out.println("��ѯ�����ɹ�");
			System.out.println(list);
		} catch (SQLException e) {
			throw new DaoException("��ѯ����ʧ��!",e);
		}
		return list;
	}

	
	@Override
	public PageModel<Orderinfo> getPageModel(int pageNo, int pageSize) throws DaoException {
		QueryRunner qRunner= new  QueryRunner();
		PageModel<Orderinfo> model=null;
		Connection conn = null;
		 try {
			conn  =	UtilC3P0.getConnection();
			//��ѯ���м�¼
			String totalcount_sql ="select count(id) from Orderinfo ";
			//��ѯ�ܵļ�¼ ScalarHandler:��һ�е�һ������
			ResultSetHandler<Long> rsh = new ScalarHandler<Long>(); 
			Integer totalcount =  qRunner.query(conn,totalcount_sql, rsh).intValue();
			
			
			if(totalcount>0) {
				model= new PageModel<Orderinfo>();
				//��PageModel ��ֵ  ���м�¼
				model.setTotalcount(totalcount);
				//��ҳ��ѯ
				String sql ="select id,orderno,orderstatus,paystatus,ordertime,paytime,addrinfo,mask from   Orderinfo limit ?,? ";
				
				ResultSetHandler<List<Orderinfo>> RSH = new BeanListHandler<Orderinfo>(Orderinfo.class);
				Object [] params = {(pageNo-1)*pageSize,pageSize};
				if(conn.isClosed()) {
					conn  =	UtilC3P0.getConnection();
				}
				List<Orderinfo> msgs  = qRunner.query(conn, sql, RSH,params);
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
