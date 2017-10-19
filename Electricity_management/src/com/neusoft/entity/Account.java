package com.neusoft.entity;

import java.io.Serializable;
import java.sql.Date;

public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6301075639694428811L;
	
	private int id; //用户id  自增
	
	private String username; //用户名称
	
	private String password; //用户密码

	private String ip;
	
	private long logindate;
	
	public long getLogindate() {
		return logindate;
	}

	public void setLogindate(long l) {
		this.logindate = l;
	}
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	

	public Account(String username, String password, String ip) {
		super();
		this.username = username;
		this.password = password;
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
}
