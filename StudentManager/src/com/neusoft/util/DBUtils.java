package com.neusoft.util;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

/**
 * ��ȡ����
 * 
 * �ر�����
 * 
 * */

public class DBUtils {


	public DBUtils() {
	}
	private static Properties ps;
	static {
		InputStream is=Thread.currentThread().getContextClassLoader().
				getResourceAsStream("mysql.properties");
		ps=new Properties();
		
		try {
			ps.load(is);
			Class.forName(ps.getProperty("driver"));
			

			
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**	��ȡ���ݿ�����			*/
	public static Connection getConnection() throws SQLException{
		Connection conn=null;
		 conn=DriverManager.getConnection(ps.getProperty("url"),
					ps.getProperty("user"),ps.getProperty("psw"));
		System.out.println("���ӳɹ�");
		return conn;
	}
	
	/*			�ر�connection 				**/
	public static void close(Connection conn) {
		try {
			if(null!=conn) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**	 �ر�		Statement	*/
	public static void close(Statement statement) {
		try {
			if(null!=statement) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**	 �ر�		ResultSet	*/
	public static void close(ResultSet resultSet) {
		try {
			if(null!=resultSet) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn,Statement statement) {
		close(conn);
		close(statement);
	}
	
	
	public static void close(Connection conn,Statement statement ,ResultSet resultSet) {
		close(conn);
		close(statement);
		close(resultSet);
	}
	
	
	
	
	
	
	
}
