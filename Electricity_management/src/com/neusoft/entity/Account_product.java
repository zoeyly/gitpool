package com.neusoft.entity;

public class Account_product {


	/* id         int       primary key auto_increment,
	    loginname   varchar(50)  not null,
	    password   varchar(50) ,
	    registertime   bigint    ,-- 注册时间
	    lastlogintime   bigint,-- 最后登录时间
	    ip          varchar(20)-- ip地址*/

		private int id;
		private String loginname;
		private String password;
		private long registertime;
		private long lastlogintime;
		private String ip;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getLoginname() {
			return loginname;
		}
		public void setLoginname(String loginname) {
			this.loginname = loginname;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public long getRegistertime() {
			return registertime;
		}
		public void setRegistertime(long registertime) {
			this.registertime = registertime;
		}
		public long getLastlogintime() {
			return lastlogintime;
		}
		public void setLastlogintime(long l) {
			this.lastlogintime = l;
		}
		public String getIp() {
			return ip;
		}
		public void setIp(String ip) {
			this.ip = ip;
		}
		public Account_product(int id, String loginname, String password, long registertime,
				long lastlogintime, String ip) {
			super();
			this.id = id;
			this.loginname = loginname;
			this.password = password;
			this.registertime = registertime;
			this.lastlogintime = lastlogintime;
			this.ip = ip;
		}
		public Account_product(String loginname, String password, long registertime, long lastlogintime,
				String ip) {
			super();
			this.loginname = loginname;
			this.password = password;
			this.registertime = registertime;
			this.lastlogintime = lastlogintime;
			this.ip = ip;
		}
		public Account_product(int id) {
			super();
			this.id = id;
		}
		public Account_product() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Account_consumer [id=" + id + ", loginname=" + loginname + ", password=" + password + ", registertime="
					+ registertime + ", lastlogintime=" + lastlogintime + ", ip=" + ip + "]";
		}

}
