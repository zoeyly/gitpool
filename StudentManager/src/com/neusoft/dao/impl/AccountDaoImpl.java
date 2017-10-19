package com.neusoft.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.dao.AccountDao;
import com.neusoft.dao.DaoException;
import com.neusoft.entity.Account;
import com.neusoft.entity.PageModel;
import com.neusoft.util.DBUtils;


/***
 * 账户类crud
 * */

public class AccountDaoImpl implements AccountDao {
	
	public boolean getAccount(String username, String psw) throws DaoException {
		Connection conn = null;
		PreparedStatement st = null;
		//ResultSet  结果
		ResultSet rs=null;
		String password=null;
		
		try {
			conn = DBUtils.getConnection();
			// step4:准备sql
			String sql = "select   password from account where username=?";
			// step3:获取statment
			st = conn.prepareStatement(sql);
			st.setString(1,username);
			// step5:发送sql
			rs = st.executeQuery();
			rs.next();
			 password=rs.getString("password");
			 
				System.out.println("欢迎您："+username);
			// step6:处理返回结果
			if (psw.equals(password)) {
				return true;
			}else {
				
				return false;
			}
		
		} catch (SQLException e) {
			throw new DaoException("查询出错",e);
		} finally {
			// step7:关闭连接
			DBUtils.close(conn, st,rs);
		}
	}

	
	/**		注册		*/
	public boolean insertAccount(Account acc) throws DaoException {
		Connection conn = null;
		PreparedStatement st = null;
		try {

			conn = DBUtils.getConnection();
			// step4:准备sql
			String sql = "INSERT INTO account(username,password,regdate) values(?,?,?)";
//			System.out.println(sql);
			// step3:获取statment
			st = conn.prepareStatement(sql);
			st.setString(1,acc.getUsername());
			st.setString(2, acc.getPsw());
//			System.currentTimeMillis()     获取和当前时间  毫秒
			st.setDate(3, new Date(System.currentTimeMillis()));
			// step5:发送sql
			int count = st.executeUpdate();
			System.out.println(acc.getUsername()+"成功注册");
			// step6:处理返回结果
			if (count > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			throw new DaoException("注册出错",e);
		} finally {
			// step7:关闭连接
			DBUtils.close(conn, st);

		}

		return false;
		
	
	
	}
/**				分页						
 * @return */
		@SuppressWarnings("resource")
		public PageModel getAccountByPage(int pageNo,int pageSize){
			PageModel model=new PageModel();
			Connection conn=null;
			PreparedStatement statement=null;
			ResultSet resultSet=null;
			try {
				conn=DBUtils.getConnection();
				//sql 查询总条数
				String sql="select count(id) from account";
				statement=conn.prepareStatement(sql);
				resultSet=statement.executeQuery();
				if(resultSet.next()) {
					int totalCount=resultSet.getInt(1);
					if(totalCount>0) {
						/**   		limit: 偏移量  查询条数
						 * pageNo==1	pageSize =10			0~10
						 * 						2						10		10~10
						 * 偏移量=(pageNo-1)*pageSize
						 */
						//当前页
						String sql2="select id,username,password from account limit ?,?";
						statement=conn.prepareStatement(sql2);
						statement.setInt(1, (pageNo-1)*pageSize);
						statement.setInt(2, pageSize);
						
						resultSet=statement.executeQuery();
						List<Account> list=new ArrayList<Account>();
						while(resultSet.next()) {
							int id=resultSet.getInt(1);
							String username=resultSet.getString(2);
							String password=resultSet.getString(3);
							
							Account account=new Account(id, username, password);
							list.add(account);
						}
						model.setTotalCount(totalCount);
						model.setList(list);
					}
				}
			}catch (SQLException e) {
			}finally {
				DBUtils.close(conn, statement, resultSet);
			}
			
			return model;
		}
}
