package com.neusoft.entity;
/*
 * -- 买家购物信息
create table  shoppinginfo_consumer(
   id          int      primary key auto_increment,
   aid         int     ,-- 买家帐号id，依赖account_consumer表中的id
   nickname    varchar(20) ,-- 用户昵称
   money       double  ,-- 订单金额
   lasttime        bigint  -- 最近消费  
);
 */
public class Shoppinginfo {
	private int id;
	private int aid;
	private String nickname;
	private int money;
	private long lasttime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public long getLasttime() {
		return lasttime;
	}
	public void setLasttime(long lasttime) {
		this.lasttime = lasttime;
	}
	public Shoppinginfo(int id, int aid, String nickname, int money, long lasttime) {
		super();
		this.id = id;
		this.aid = aid;
		this.nickname = nickname;
		this.money = money;
		this.lasttime = lasttime;
	}
	public Shoppinginfo(int aid, String nickname, int money, long lasttime) {
		super();
		this.aid = aid;
		this.nickname = nickname;
		this.money = money;
		this.lasttime = lasttime;
	}
	public Shoppinginfo(int id) {
		super();
		this.id = id;
	}
	public Shoppinginfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Shoppinginfo [id=" + id + ", aid=" + aid + ", nickname=" + nickname + ", money=" + money + ", lasttime="
				+ lasttime + "]";
	}
	

}
