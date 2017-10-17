package com.neusoft.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.dao.RuleDao;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.entity.Rule;
import com.neusoft.utils.DaoException;
import com.neusoft.utils.UtilC3P0;

public class RuleDaoImpl implements RuleDao {
	
	
	QueryRunner qr = new QueryRunner();
	Connection conn = null;
	
	public RuleDaoImpl(){
		try {
			conn = UtilC3P0.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean addRule(Rule rule) throws DaoException {
		try {
			String sql = "insert into rule(pid,size) values(?,?)";
			int count = qr.update(conn, sql, rule.getPid(),rule.getSize());
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
	public boolean deleteRule(Rule rule) throws DaoException {
try {
			String sql = "delete from rule where id=?";
			int count = qr.update(conn, sql, rule.getId());
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
	public boolean changeRule(Rule rule) throws DaoException {
		try {
			String sql = "update  rule set  pid=? ,size=?  where id=?";
			int count = qr.update(conn, sql,rule.getPid(),rule.getSize(),rule.getId());
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
	public List<Rule> showRuleAll() throws DaoException {
		String sql = "select id,pid,size from rule order by id";
		List<Rule> list = null;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Rule>(Rule.class));
			System.out.println("查询成功");
			System.out.println(list);
		} catch (SQLException e) {
			throw new DaoException("查询失败!",e);
		}
		return list;
	}
	
	
	
	@Override
	public PageModel<Rule> getPageModel(int pageNo, int pageSize) throws DaoException {
		QueryRunner qRunner= new  QueryRunner();
		PageModel<Rule> model=null;
		Connection conn = null;
		 try {
			conn  =	UtilC3P0.getConnection();
			//查询所有记录
			String totalcount_sql ="select count(id) from Rule ";
			//查询总的记录 ScalarHandler:第一行第一列数据
			ResultSetHandler<Long> rsh = new ScalarHandler<Long>(); 
			Integer totalcount =  qRunner.query(conn,totalcount_sql, rsh).intValue();
			
			
			if(totalcount>0) {
				model= new PageModel<Rule>();
				//给PageModel 赋值  所有记录
				model.setTotalcount(totalcount);
				//分页查询
				String sql ="select id,pid,size from   Rule limit ?,? ";
				
				ResultSetHandler<List<Rule>> RSH = new BeanListHandler<Rule>(Rule.class);
				Object [] params = {(pageNo-1)*pageSize,pageSize};
				if(conn.isClosed()) {
					conn  =	UtilC3P0.getConnection();
				}
				List<Rule> msgs  = qRunner.query(conn, sql, RSH,params);
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
