package com.neusoft.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.neusoft.dao.AddressDao;
import com.neusoft.entity.Address;
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
					System.out.println("插入规格成功");
					System.out.println(count);
					return true;
				}
		} catch (SQLException e) {
			throw new DaoException("插入规格失败!",e);
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

}
