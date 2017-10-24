package com.neusoft.test;

import com.neusoft.entity.Neusoft_User;
import com.neusoft.user.dao.UserDao;
import com.neusoft.user.dao.impl.UserDaoImp;

public class Test {
	public static void test_findById() {
		 UserDao userDao=new UserDaoImp();
		 userDao.findUserById(1);
	}
	public static void test_findById2() {
		 UserDao userDao=new UserDaoImp();
		 Neusoft_User user=new Neusoft_User();
		 user.setId(1);
		 userDao.findUserById(user);
	}
	
	public static void find() {
		 UserDao userDao=new UserDaoImp();
		 userDao.find("aaa", "111");
	}
	
	public static void findall() {
		 UserDao userDao=new UserDaoImp();
		 userDao.findAll();
	}
	
	public static void findAllByPage() {
		 UserDao userDao=new UserDaoImp();
		 userDao.findAllByPage(1,3);
	}
	public static void findAuthor() {
		 UserDao userDao=new UserDaoImp();
		 userDao.findAuthor();
	}
	
	public static void readermap() {
		 UserDao userDao=new UserDaoImp();
		 Neusoft_User user=new Neusoft_User();
		 user.setId(1);
		 userDao.findUserByReader(user);
	}
	
	public static void main(String[] args) {
		test_findById();
//		find();
//		findall();
//		findAllByPage();
//		findAuthor();
//		test_findById2();
//		readermap();
	}
	
}
