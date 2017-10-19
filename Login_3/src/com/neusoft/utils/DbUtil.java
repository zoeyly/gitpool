package com.neusoft.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil  {

	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
			String username = "scott";
			String password = "111111";
			conn = DriverManager.getConnection(dbUrl, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//设置手动事物
	public static void beginTransaction(Connection conn){
		try {
			if(conn !=null){
				if(conn.getAutoCommit()){
					conn.setAutoCommit(false); //手动提交
				}
			}
		}catch(SQLException e){	}
	}
	
	//设置提交事物
	public static void commitTransaction(Connection conn){
		try{
			if(conn != null){
				if(!conn.getAutoCommit()){
					conn.commit();
				}
			}
		}catch(SQLException	e){}
	}
	
	public static void rollbackTransaction(Connection conn){
		try{
			if(conn != null){
				if(!conn.getAutoCommit()){
					conn.rollback();
				}
			}
		}catch(SQLException e){}
	}
	
	public static void resetConnection(Connection conn){
		try{
			if(conn != null){
				if(!conn.getAutoCommit()){
					conn.setAutoCommit(false);
				}else{
					conn.setAutoCommit(true);
				}
			}
		}catch(SQLException e){}
	}
	
	public static void close(PreparedStatement pstmt){
		if(pstmt != null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
	public static void main(String[] args){
		System.out.println(DbUtil.getConnection());
	}

}
