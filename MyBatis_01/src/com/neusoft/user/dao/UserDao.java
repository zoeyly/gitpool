package com.neusoft.user.dao;

import java.util.List;

import com.neusoft.entity.Author;
import com.neusoft.entity.Neusoft_User;

/**
 * 
 * 用户CRUD
 * */
public interface UserDao {
//查询  id
	public Neusoft_User findUserById(int id) ;
	public Neusoft_User findUserById(Neusoft_User user) ;
//查询  username  password
	public Neusoft_User find(String username, String password);
//查询  所有
	public List<Neusoft_User> findAll();
//查询  分页
	public List<Neusoft_User> findAllByPage(int pageNo, int pageSize);
	
//查询作者
	public  List<Author>  findAuthor();
	
//查询用户阅读
	public  Neusoft_User findUserByReader(Neusoft_User user);
	
}
