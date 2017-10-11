package com.neusoft.entity;

import org.w3c.dom.Text;

/*
 * create table product(
   id          int          primary key  auto_increment,-- 商品编号，主键
   pname       varchar(20)  not null,
   cid         int  ,-- 外键，引用自cate表中的cid
   pno         varchar(30)  ,-- 货号
   pic         varchar(100),-- 商品图片
   price       double     , -- 商品价格
   online      int     ,   -- 1:上线  0:下线 
   pdetail     text       -- 商品详情
);*/
public class Product {
	private 	int  id;
	private 	String pname;
	private 	int cid;
	private 	String pno;
	private String pic;
	private double price;
	private int online;
	private String pdetail;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getOnline() {
		return online;
	}
	public void setOnline(int online) {
		this.online = online;
	}
	public String getPdetail() {
		return pdetail;
	}
	public void setPdetail(String pdetail) {
		this.pdetail = pdetail;
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(int id) {
		super();
		this.id = id;
	}
	public Product(String pname, int cid, String pno, String pic, double price, int online, String pdetail) {
		super();
		this.pname = pname;
		this.cid = cid;
		this.pno = pno;
		this.pic = pic;
		this.price = price;
		this.online = online;
		this.pdetail = pdetail;
	}
	public Product(int id, String pname, int cid, String pno, String pic, double price, int online, String pdetail) {
		super();
		this.id = id;
		this.pname = pname;
		this.cid = cid;
		this.pno = pno;
		this.pic = pic;
		this.price = price;
		this.online = online;
		this.pdetail = pdetail;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + pname + ", cid=" + cid + ", pno=" + pno + ", pic=" + pic + ", price="
				+ price + ", online=" + online + ", pdetail=" + pdetail + "]";
	}
	
	
}
