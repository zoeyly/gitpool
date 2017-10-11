package com.neusoft.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.neusoft.dao.ProductDao;
import com.neusoft.dao.ShoppinginfoDao;
import com.neusoft.entity.Cate;
import com.neusoft.entity.Product;
import com.neusoft.entity.Shoppinginfo;
import com.neusoft.utils.DaoException;
import com.neusoft.utils.UtilC3P0;

public class ShoppinginfoDaoImpl  implements ShoppinginfoDao{
	
	QueryRunner qr = new QueryRunner();
	Connection conn = null;
	
	public ShoppinginfoDaoImpl(){
		try {
			conn = UtilC3P0.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	@Override
	public boolean insertShoppinginfo(Shoppinginfo shoppinginfo) throws DaoException {
	
		try {	
			System.out.println(111);
			String sql = "insert into shoppinginfo_consumer(aid,nickname,money,lasttime) values( ?,?,?,?)";
			System.out.println(111);
			int count = qr.update(conn, sql,shoppinginfo.getAid(),shoppinginfo.getNickname(),shoppinginfo.getMoney(),shoppinginfo.getLasttime());
			System.out.println(111);
				if(count>0){
					System.out.println("插入成功");
					System.out.println(count);
					return true;
				}
		} catch (SQLException e) {
			throw new DaoException("插入失败!",e);
		}	
		return false;
	}

	@Override
	public boolean deleteShoppinginfo(Shoppinginfo shoppinginfo) throws DaoException {
	try {
			
			String sql = "delete from shoppinginfo_consumer where id=?";
			int count = qr.update(conn, sql, shoppinginfo.getId());
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
	public boolean changeShoppinginfo(Shoppinginfo shoppinginfo) throws DaoException {
	
			try {
				String sql = "update  shoppinginfo_consumer  set  aid=?,nickname=?,money=?,lasttime=? where id=?";
				int count = qr.update(conn, sql,shoppinginfo.getAid(),shoppinginfo.getNickname(),shoppinginfo.getMoney(),shoppinginfo.getLasttime(),shoppinginfo.getId());
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
	public List<Shoppinginfo> showShoppinginfoAll() throws DaoException {
		String sql = "select id ,aid,nickname,money,lasttime from shoppinginfo_consumer order by id";
		List<Shoppinginfo> list = null;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Shoppinginfo>(Shoppinginfo.class));
			System.out.println("查询成功");
			System.out.println(list);
		} catch (SQLException e) {
			throw new DaoException("查询失败!",e);
		}
		return list;
	}

}
