package com.neusoft.test;

import com.neusoft.dao.impl.AccountDaoImpl;
import com.neusoft.dao.impl.StudentDaoImpl;
import com.neusoft.entity.Account;

public class Test {

	public static void main(String[] args) {

	/*		//登录
		AccountDaoImpl accountDaoImpl=new AccountDaoImpl();
		System.out.println(	accountDaoImpl.getAccount("aaa", "111"));
		
	//注册
		AccountDaoImpl accountDaoImpl=new AccountDaoImpl();
		Account acc=new Account("fff", "666");
		System.out.println(accountDaoImpl.insert(acc)	);
		
	//查询所有、
		StudentDaoImpl DaoImpl=new StudentDaoImpl();
		System.out.println(DaoImpl.getStus());
		
		//id查询
		StudentDaoImpl studentDaoImpl=new StudentDaoImpl();
		System.out.println(studentDaoImpl.getStus(2));
		
		//插入
		StudentDaoImpl studl=new StudentDaoImpl();
		Student s=new Student();
				s.setId(4);
				s.setName("d");
				s.setSex(1);
				s.setAge(20);
				s.setMyclass("低级");
				s.setAddress("北京");
				s.setPhone(234);
				s.setEmail("123@@");
			studl.insert(s);
		//修改
		StudentDaoImpl studl=new StudentDaoImpl();
		Student s=new Student();
				s.setId(2);
				s.setName("d");
				s.setSex(1);
				s.setAge(20);
				s.setMyclass("低级");
				s.setAddress("北京");
				s.setPhone(234);
				s.setEmail("123@@");
			studl.update(s);
			
	
		//删除
		StudentDaoImpl studl=new StudentDaoImpl();
		Student s=new Student();
				s.setId(4);
		studl.delete(4);




		*/
		
		StudentDaoImpl DaoImpl=new StudentDaoImpl();
		System.out.println(DaoImpl.getStus());

	}

}
