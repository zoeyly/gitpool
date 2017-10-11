package com.neusoft.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.neusoft.dao.ProductDao;
import com.neusoft.entity.Cate;
import com.neusoft.entity.Product;
import com.neusoft.utils.DaoException;
import com.neusoft.utils.UtilC3P0;

public class ProductDaoImpl  implements ProductDao{
	
	QueryRunner qr = new QueryRunner();
	Connection conn = null;
	
	public ProductDaoImpl(){
		try {
			conn = UtilC3P0.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertProduct(Product product) throws DaoException {
		try {
			String sql = "insert into product(pname,cid,pno,pic,price,online,pdetail) values( ?, ?,?,?,?,?,?)";
			int count = qr.update(conn, sql,product.getPname(),product.getCid(),product.getPno(),product.getPic(),product.getPrice(),product.getOnline(),product.getPdetail());
				if(count>0){
					System.out.println("插入商品成功");
					System.out.println(count);
					return true;
				}
		} catch (SQLException e) {
			throw new DaoException("插入商品失败!",e);
		}	
		return false;
	}

	@Override
	public boolean deleteProduct(Product product) throws DaoException {
		try {
			
			String sql = "delete from product where id=?";
			int count = qr.update(conn, sql, product.getId());
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
	public boolean changeProduct(Product product) throws DaoException {
		try {
			String sql = "update  product set   pname=?,cid=?, pno =?,pic=?, price=?,online=?, pdetail=? where id=?";
			int count = qr.update(conn, sql,product.getPname(),product.getCid(),product.getPno(),product.getPic(),product.getPrice(),product.getOnline(),product.getPdetail(),product.getId());
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
	public List<Product> showProductAll() throws DaoException {
		String sql = "select id,pname,cid,pno,pic,price,online,pdetail from product order by id";
		List<Product> list = null;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Product>(Product.class));
			System.out.println("查询成功");
			System.out.println(list);
		} catch (SQLException e) {
			throw new DaoException("查询失败!",e);
		}
		return list;
	}

}
