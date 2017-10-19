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
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
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
					System.out.println("������Ʒ�ɹ�");
					System.out.println(count);
					return true;
				}
		} catch (SQLException e) {
			throw new DaoException("������Ʒʧ��!",e);
		}	
		return false;
	}

	@Override
	public boolean deleteProduct(Product product) throws DaoException {
		try {
			
			String sql = "delete from product where id=?";
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
	public boolean changeProduct(Product product) throws DaoException {
		try {
			String sql = "update  product set   pname=?,cid=?, pno =?,pic=?, price=?,online=?, pdetail=? where id=?";
			int count = qr.update(conn, sql,product.getPname(),product.getCid(),product.getPno(),product.getPic(),product.getPrice(),product.getOnline(),product.getPdetail(),product.getId());
				if(count>0){
					System.out.println("�޸ĳɹ�");
					return true;
				}
		} catch (SQLException e) {
			throw new DaoException("�޸�ʧ��!",e);
		}	
		return false;
	}

	@Override
	public List<Product> showProductAll() throws DaoException {
		String sql = "select id,pname,cid,pno,pic,price,online,pdetail from product order by id";
		List<Product> list = null;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Product>(Product.class));
			System.out.println("��ѯ�ɹ�");
			System.out.println(list);
		} catch (SQLException e) {
			throw new DaoException("��ѯʧ��!",e);
		}
		return list;
	}
	

	
	@Override
	public PageModel<Product> getPageModel(int pageNo, int pageSize) throws DaoException {
		QueryRunner qRunner= new  QueryRunner();
		PageModel<Product> model=null;
		Connection conn = null;
		 try {
			conn  =	UtilC3P0.getConnection();
			//��ѯ���м�¼
			String totalcount_sql ="select count(id) from Product ";
			//��ѯ�ܵļ�¼ ScalarHandler:��һ�е�һ������
			ResultSetHandler<Long> rsh = new ScalarHandler<Long>(); 
			Integer totalcount =  qRunner.query(conn,totalcount_sql, rsh).intValue();
			
			
			if(totalcount>0) {
				model= new PageModel<Product>();
				//��PageModel ��ֵ  ���м�¼
				model.setTotalcount(totalcount);
				//��ҳ��ѯ
				String sql ="select id,pname,cid,pno,pic,price,online,pdetail from   Product limit ?,? ";
				
				ResultSetHandler<List<Product>> RSH = new BeanListHandler<Product>(Product.class);
				Object [] params = {(pageNo-1)*pageSize,pageSize};
				if(conn.isClosed()) {
					conn  =	UtilC3P0.getConnection();
				}
				List<Product> msgs  = qRunner.query(conn, sql, RSH,params);
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

	@Override
	public List<Product> findProduct(Product cid) throws DaoException {
	try {
		String sql = "select id,pname,cid,pno,pic,price,online,pdetail from product  where cid=?";
		ResultSetHandler<List<Product>> rsh=  new BeanListHandler<Product>(Product.class);
			List<Product> count = qr.query(conn, sql, rsh,cid.getCid()); 
				if(count!=null){
					System.out.println("���ҳɹ�");
					System.out.println(count);
					return count;
				}
		} catch (SQLException e) {
			throw new DaoException("����ʧ��!",e);
		}	
		return null;
	}



	public static void main(String[] args) {
		Product product=new Product(1);
		System.out.println(new ProductDaoImpl().findProduct(product));
	}

}
