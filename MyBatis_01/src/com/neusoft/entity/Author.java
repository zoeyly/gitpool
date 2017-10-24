package com.neusoft.entity;

import java.io.Serializable;

public class Author  implements Serializable{

	private int AuthorId;	//作者id
	private Neusoft_User user;	//用户
	private String realName;	//真实姓名
	private String IDCard;
	public int getAuthorId() {
		return AuthorId;
	}
	public void setAuthorId(int authorId) {
		AuthorId = authorId;
	}
	public Neusoft_User getUser() {
		return user;
	}
	public void setUser(Neusoft_User user) {
		this.user = user;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	public Author(Integer authorId, Neusoft_User user, String realName, String iDCard) {
		super();
		AuthorId = authorId;
		this.user = user;
		this.realName = realName;
		IDCard = iDCard;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Author [AuthorId=" + AuthorId + ", user=" + user + ", realName=" + realName + ", IDCard=" + IDCard
				+ "]";
	}
	
	
}
