package com.neusoft.user.dao;

import java.util.List;

import com.neusoft.entity.Author;
import com.neusoft.entity.Neusoft_User;

/**
 * 
 * �û�CRUD
 * */
public interface UserDao {
//��ѯ  id
	public Neusoft_User findUserById(int id) ;
	public Neusoft_User findUserById(Neusoft_User user) ;
//��ѯ  username  password
	public Neusoft_User find(String username, String password);
//��ѯ  ����
	public List<Neusoft_User> findAll();
//��ѯ  ��ҳ
	public List<Neusoft_User> findAllByPage(int pageNo, int pageSize);
	
//��ѯ����
	public  List<Author>  findAuthor();
	
//��ѯ�û��Ķ�
	public  Neusoft_User findUserByReader(Neusoft_User user);
	
}
