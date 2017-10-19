package com.neusoft.entity;

import java.io.Serializable;

import com.mysql.fabric.xmlrpc.base.Data;

/**
 * 用户帐号实体类
 * 
 * Serializable   序列化接口
 * 
 * */

public class Account  implements Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 4018027210261985348L;
	
	private int id;
	private String username;
	 private String password;
	 private Data  regdate;
	 
	 
	public Data getRegdate() {
		return regdate;
	}
	public void setRegdate(Data regdate) {
		this.regdate = regdate;
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
	public String getPsw() {
		return password;
	}
	public void setPsw(String password) {
		this.password = password;
	}
	
	public Account(String username, String password,Data regdate) {
		super();
		this.username = username;
		this.password = password;
		this.regdate=regdate;
	}
	
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Account(int id,String username, String password) {
		super();
		this.id=id;
		this.username = username;
		this.password = password;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	 
	 
	
}
