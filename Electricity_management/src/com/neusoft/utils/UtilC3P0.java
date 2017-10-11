package com.neusoft.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.mchange.v2.c3p0.ComboPooledDataSource;

public class UtilC3P0 {
	private static ComboPooledDataSource ds = null;
	private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>();
	
	static{
		try{
			ds = new ComboPooledDataSource("mysql");
		}catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	//�õ�����
	public static Connection getConnection() throws SQLException{
		Connection conn = connectionHolder.get(); 
		if(conn!=null){
			return conn;
		}else{
			conn = ds.getConnection();
			connectionHolder.set(conn);
			return conn;
		}	
	}
	
	
	//�ر�����
	public static void close(Statement stmt){
		if(null != stmt){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs){
		if(null != rs){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection conn){
		if(null != conn){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection conn,ResultSet rs,Statement stmt){
		close(rs);
		close(stmt);
		close(conn);
	}
	
	public static void close(Connection conn,Statement stmt){
		close(stmt);
		close(conn);
	}
	
	public static void close(ResultSet rs,Statement stmt){
		close(rs);
		close(stmt);
	}
	
	
	public static void main(String[] args) {
	
		try {
			Connection conn = UtilC3P0.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
