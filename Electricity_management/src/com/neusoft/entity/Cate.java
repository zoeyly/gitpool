package com.neusoft.entity;

//-- Àà±ğ±í
//create table Cate(
// cid        int           primary key  auto_increment,
// cname      varchar(20)   not null,
// pid        int          
//);
public class Cate {
	private	int cid;
	private	String cname;
	private	int pid;
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public Cate(int cid, String cname, int pid) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.pid = pid;
	}
	public Cate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cate(int cid) {
		super();
		this.cid = cid;
	}
	public Cate(String cname, int pid) {
		super();
		this.cname = cname;
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "Cate [cid=" + cid + ", cname=" + cname + ", pid=" + pid + "]";
	}

	
}
