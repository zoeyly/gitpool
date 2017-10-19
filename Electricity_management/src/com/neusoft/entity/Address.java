package com.neusoft.entity;


/*
 * id         int           primary key  auto_increment,
    province   varchar(20)   not null ,-- 省份
    city       varchar(40)   not null ,-- 城市
    area        varchar(40)    not null-- 区/县*/
public class Address {
	private int id;
	private String province;
	private String city;
	private String area;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Address(int id, String province, String city, String area) {
		super();
		this.id = id;
		this.province = province;
		this.city = city;
		this.area = area;
	}
	public Address(String province, String city, String area) {
		super();
		this.province = province;
		this.city = city;
		this.area = area;
	}
	public Address(int id) {
		super();
		this.id = id;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", province=" + province + ", city=" + city + ", area=" + area + "]";
	}
	

}
