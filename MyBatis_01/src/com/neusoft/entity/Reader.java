package com.neusoft.entity;


public class Reader {
	private int readerid;
	private int userId;
	private int money;
	public int getReaderid() {
		return readerid;
	}
	public void setReaderid(int readerid) {
		this.readerid = readerid;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Reader(int readerid, int userId, int money) {
		super();
		this.readerid = readerid;
		this.userId = userId;
		this.money = money;
	}
	public Reader() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Reader [readerid=" + readerid + ", userId=" + userId + ", money=" + money + "]";
	}
	
	
}
