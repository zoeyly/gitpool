package com.neusoft.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.dao.ProductDao;
import com.neusoft.dao.ShoppinginfoDao;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.entity.Rule;
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
			String sql = "insert into shoppinginfo_consumer(aid,nickname,money,lasttime) values( ?,?,?,now())";
			System.out.println(111);
			int count = qr.update(conn, sql,shoppinginfo.getAid(),shoppinginfo.getNickname(),shoppinginfo.getMoney());
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
	
	@Override
	public PageModel<Shoppinginfo> getPageModel(int pageNo, int pageSize) throws DaoException {
		QueryRunner qRunner= new  QueryRunner();
		PageModel<Shoppinginfo> model=null;
		Connection conn = null;
		 try {
			conn  =	UtilC3P0.getConnection();
			//查询所有记录
			String totalcount_sql ="select count(id) from Shoppinginfo_Consumer ";
			//查询总的记录 ScalarHandler:第一行第一列数据
			ResultSetHandler<Long> rsh = new ScalarHandler<Long>(); 
			Integer totalcount =  qRunner.query(conn,totalcount_sql, rsh).intValue();
			
			
			if(totalcount>0) {
				model= new PageModel<Shoppinginfo>();
				//给PageModel 赋值  所有记录
				model.setTotalcount(totalcount);
				//分页查询
				String sql ="select id ,aid,nickname,money,lasttime  from   Shoppinginfo_Consumer limit ?,? ";
				
				ResultSetHandler<List<Shoppinginfo>> RSH = new BeanListHandler<Shoppinginfo>(Shoppinginfo.class);
				Object [] params = {(pageNo-1)*pageSize,pageSize};
				if(conn.isClosed()) {
					conn  =	UtilC3P0.getConnection();
				}
				List<Shoppinginfo> msgs  = qRunner.query(conn, sql, RSH,params);
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
