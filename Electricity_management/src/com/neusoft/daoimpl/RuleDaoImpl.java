package com.neusoft.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.dao.RuleDao;
import com.neusoft.entity.PageModel;
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
					System.out.println("������ɹ�");
					System.out.println(count);
					return true;
				}
		} catch (SQLException e) {
			throw new DaoException("������ʧ��!",e);
		}	
		return false;
	}

	@Override
	public boolean deleteRule(Rule rule) throws DaoException {
try {
			String sql = "delete from rule where id=?";
			int count = qr.update(conn, sql, rule.getId());
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
	public boolean changeRule(Rule rule) throws DaoException {
		try {
			String sql = "update  rule set  pid=? ,size=?  where id=?";
			int count = qr.update(conn, sql,rule.getPid(),rule.getSize(),rule.getId());
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
	public List<Rule> showRuleAll() throws DaoException {
		String sql = "select id,pid,size from rule order by id";
		List<Rule> list = null;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Rule>(Rule.class));
			System.out.println("��ѯ�ɹ�");
			System.out.println(list);
		} catch (SQLException e) {
			throw new DaoException("��ѯʧ��!",e);
		}
		return list;
	}
	
	
	
	
	@Override
	public PageModel<Rule> showPro(int pageNo, int pageSize) throws DaoException {
		PageModel<Rule> pageModel = new PageModel<Rule>();
		String sql = "select id,pid,size from rule ";
		List<Rule> list = null;
		try {
			list = qr.query(conn, sql, new BeanListHandler<Rule>(Rule.class));
			System.out.println("��ѯ�ɹ�");
			System.out.println(list);
		} catch (SQLException e) {
			throw new DaoException("��ѯʧ��!",e);
		}
		return pageModel;
	}
	@Override
	public int getProTotalRecords() throws DaoException {
		int num = 0;
		String sql = "select count(id) from rule";
		try {
			conn = UtilC3P0.getConnection();
			Object obj = qr.query(conn, sql, new ScalarHandler<Object>());
			num = Integer.parseInt(obj.toString());
			System.out.println(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

}