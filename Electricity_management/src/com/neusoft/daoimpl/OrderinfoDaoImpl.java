package com.neusoft.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.neusoft.dao.OrderinfoDao;
import com.neusoft.entity.Orderinfo;
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
					System.out.println("插入订单成功");
					System.out.println(count);
					return true;
				}
		} catch (SQLException e) {
			throw new DaoException("插入订单失败!",e);
		}	
		return false;
	}

	@Override
	public boolean deleteOrderinfo(Orderinfo orderinfo) throws DaoException {
		try {
			
			String sql = "delete from orderinfo where id=?";
			int count = qr.update(conn, sql, orderinfo.getId());
				if(count>0){
					System.out.println("删除订单成功");
					System.out.println(count);
					return true;
				}
		} catch (SQLException e) {
			throw new DaoException("删除订单失败!",e);
		}	
		return false;
	}

	@Override
	public boolean changeOrderinfo(Orderinfo orderinfo) throws DaoException {
		try {
			String sql = "update  orderinfo set   orderno=?,orderstatus=?,paystatus=?,ordertime=?,paytime=?,addrinfo=?,mask=?  where id=?";
			int count = qr.update(conn, sql,orderinfo.getOrderno(),orderinfo.getOrderstatus(),orderinfo.getPaystatus(),orderinfo.getOrdertime(),orderinfo.getPaytime(),orderinfo.getAddrinfo(),orderinfo.getMask(),orderinfo.getId());
				if(count>0){
					System.out.println("修改订单成功");
					return true;
				}
		} catch (SQLException e) {
			throw new DaoException("修改订单失败!",e);
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
			System.out.println("查询订单成功");
			System.out.println(list);
		} catch (SQLException e) {
			throw new DaoException("查询订单失败!",e);
		}
		return list;
	}

}
