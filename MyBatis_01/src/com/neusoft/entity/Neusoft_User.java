package com.neusoft.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 用户登录实体类
 * */
public class Neusoft_User  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3814067055986758193L;
	private int id;
	private String userName; 
	private String password;
	private String userIp;
	
	private List<Reader> readers;
	
	
	public Neusoft_User(int id, String userName, String password, String userIp, List<Reader> readers) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.userIp = userIp;
		this.readers = readers;
	}
	public List<Reader> getReaders() {
		return readers;
	}
	public void setReaders(List<Reader> readers) {
		this.readers = readers;
	}
	public Neusoft_User(Integer id, String userName, String password, String userIp) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.userIp = userIp;
	}
	public Neusoft_User(Integer id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}
	public Neusoft_User() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	@Override
	public String toString() {
		return "Neusoft_User [id=" + id + ", userName=" + userName + ", password=" + password + ", userIp=" + userIp
				+ ", readers=" + readers + "]";
	}
	

	
	
}
