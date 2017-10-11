package com.neusoft.entity;

import java.math.BigInteger;
//id          int        primary key  auto_increment, -- 订单id
//orderno     varchar(50)  not null,-- 订单编号
//orderstatus  int        ,-- 订单状态     1:未付款 2:已付款 3:已发货 4:已完成
//paystatus    int       ,-- 1:线上支付  2：货到付款
//ordertime    bigint    ,-- 下单时间
//paytime      bigint    ,-- 付款时间
//addrinfo     int       ,-- 收货人信息，引用自cosumer_addr表中的id
//mask         varchar(200) -- 备注信息
public class Orderinfo {
	private int id;
	private String orderno;
	private int orderstatus;
	private int paystatus;
	private int ordertime;
	private int paytime;
	private int addrinfo;
	private String mask;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public int getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}
	public int getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(int paystatus) {
		this.paystatus = paystatus;
	}
	public int getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(int ordertime) {
		this.ordertime = ordertime;
	}
	public int getPaytime() {
		return paytime;
	}
	public void setPaytime(int paytime) {
		this.paytime = paytime;
	}
	public int getAddrinfo() {
		return addrinfo;
	}
	public void setAddrinfo(int addrinfo) {
		this.addrinfo = addrinfo;
	}
	public String getMask() {
		return mask;
	}
	public void setMask(String mask) {
		this.mask = mask;
	}
	public Orderinfo(int id, String orderno, int orderstatus, int paystatus, int ordertime, int paytime,
			int addrinfo, String mask) {
		super();
		this.id = id;
		this.orderno = orderno;
		this.orderstatus = orderstatus;
		this.paystatus = paystatus;
		this.ordertime = ordertime;
		this.paytime = paytime;
		this.addrinfo = addrinfo;
		this.mask = mask;
	}
	public Orderinfo(String orderno, int orderstatus, int paystatus, int ordertime, int paytime,
			int addrinfo, String mask) {
		super();
		this.orderno = orderno;
		this.orderstatus = orderstatus;
		this.paystatus = paystatus;
		this.ordertime = ordertime;
		this.paytime = paytime;
		this.addrinfo = addrinfo;
		this.mask = mask;
	}
	public Orderinfo(int id) {
		super();
		this.id = id;
	}
	public Orderinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Orderinfo [id=" + id + ", orderno=" + orderno + ", orderstatus=" + orderstatus + ", paystatus="
				+ paystatus + ", ordertime=" + ordertime + ", paytime=" + paytime + ", addrinfo=" + addrinfo + ", mask="
				+ mask + "]";
	}
	
	
	
}
