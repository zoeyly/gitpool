package com.neusoft.entity;


/**
 * 学生实体类
 * */
public class Student {

	 private int id;
	 private String name;
	 private int sex;//0: 男  1:女
	 private int age;
	 private String myclass;//1: 初级   2:中级 3:高级
	 private String address;
	 private int phone;
	 private String email;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMyclass() {
		return myclass;
	}
	public void setMyclass(String myclass) {
		this.myclass = myclass;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Student(int id, String name, int sex, int age, String myclass, String address, int phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.myclass = myclass;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", myclass=" + myclass
				+ ", address=" + address + ", phone=" + phone + ", email=" + email + "]";
	}
	 
	 
	 
	
	 
	 
}
