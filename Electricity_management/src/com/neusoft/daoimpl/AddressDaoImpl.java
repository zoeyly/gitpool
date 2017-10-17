package com.neusoft.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.dao.AddressDao;
import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.entity.Rule;
import com.neusoft.utils.DaoException;
import com.neusoft.utils.UtilC3P0;

public class AddressDaoImpl implements AddressDao {
	
	
	QueryRunner qr = new QueryRunner();
	Connection conn = null;
	
	public AddressDaoImpl(){
		try {
			conn = UtilC3P0.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean addAddress(Address address) throws DaoException {
		try {
			String sql = "insert into address(province,city,area) values(?,?,?)";
			int count = qr.update(conn, sql, address.getProvince(),address.getCity(),address.getArea());
				if(count>0){
					System.out.println("插入地址成功");
					System.out.println(count);
					return true;
				}
		} catch (SQLException e) {
			throw new DaoException("插入地址失败!",e);
		}	
		return false;
	}

	@Override
	public boolean deleteAddress(Address address) throws DaoException {
try {
			String sql = "delete from address where id=?";
			int count = qr.update(conn, sql, address.getId());
				if(count>0){
					System.out.println("删除成功");
					System.out.println(count);
					return true;
				}
		} catch (SQLException e) {
			throw new DaoException("删除失败!",e);
		}	
		return false;
	}

	@Override
	public boolean changeAddress(Address address) throws DaoException {
		try {
			String sql = "update  address set province=?,city=?,area=?  where id=?";
			int count = qr.update(conn, sql,address.getProvince(),address.getCity(),address.getArea(),address.getId());
				if(count>0){
					System.out.println("修改成功");
					return true;
				}
		} catch (SQLException e) {
			throw new DaoException("修改失败!",e);
		}	
		return false;
	}

	@Override
	public List<Address> showAddressAll() throws DaoException {
		String sql = "select id,province,city,area from address order by id";
		List<Address> list = null;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Address>(Address.class));
			System.out.println("查询成功");
			System.out.println(list);
		} catch (SQLException e) {
			throw new DaoException("查询失败!",e);
		}
		return list;
	}
	
	@Override
	public PageModel<Address> getPageModel(int pageNo, int pageSize) throws DaoException {
		QueryRunner qRunner= new  QueryRunner();
		PageModel<Address> model=null;
		Connection conn = null;
		 try {
			conn  =	UtilC3P0.getConnection();
			//查询所有记录
			String totalcount_sql ="select count(id) from Address ";
			//查询总的记录 ScalarHandler:第一行第一列数据
			ResultSetHandler<Long> rsh = new ScalarHandler<Long>(); 
			Integer totalcount =  qRunner.query(conn,totalcount_sql, rsh).intValue();
			
			
			if(totalcount>0) {
				model= new PageModel<Address>();
				//给PageModel 赋值  所有记录
				model.setTotalcount(totalcount);
				//分页查询
				String sql ="select id,province,city,area from   Address limit ?,? ";
				
				ResultSetHandler<List<Address>> RSH = new BeanListHandler<Address>(Address.class);
				Object [] params = {(pageNo-1)*pageSize,pageSize};
				if(conn.isClosed()) {
					conn  =	UtilC3P0.getConnection();
				}
				List<Address> msgs  = qRunner.query(conn, sql, RSH,params);
				//给PageModel 赋值   每页显示数据
				model.setDatas(msgs);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("分页查询出错",e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
		return model;
	}


}
