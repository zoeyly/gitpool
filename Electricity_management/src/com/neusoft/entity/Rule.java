package com.neusoft.entity;

/*
 *  id            int      primary key  auto_increment ,
  pid           int     ,-- 商品id，引用商品表中的id
  size          varchar(20)  -- 尺寸
 * */
public class Rule {
		private int id;
		private int pid;
		private String size;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
		}
		public String getSize() {
			return size;
		}
		public void setSize(String size) {
			this.size = size;
		}
		public Rule(int id, int pid, String size) {
			super();
			this.id = id;
			this.pid = pid;
			this.size = size;
		}
		public Rule(int pid, String size) {
			super();
			this.pid = pid;
			this.size = size;
		}
		
		public Rule(int id) {
			super();
			this.id = id;
		}
		public Rule() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Rule [id=" + id + ", pid=" + pid + ", size=" + size + "]";
		}
		
}
