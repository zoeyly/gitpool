package com.neusoft.test;

import com.neusoft.dao.impl.AccountDaoImpl;
import com.neusoft.dao.impl.StudentDaoImpl;
import com.neusoft.entity.Account;

public class Test {

	public static void main(String[] args) {

	/*		//��¼
		AccountDaoImpl accountDaoImpl=new AccountDaoImpl();
		System.out.println(	accountDaoImpl.getAccount("aaa", "111"));
		
	//ע��
		AccountDaoImpl accountDaoImpl=new AccountDaoImpl();
		Account acc=new Account("fff", "666");
		System.out.println(accountDaoImpl.insert(acc)	);
		
	//��ѯ���С�
		StudentDaoImpl DaoImpl=new StudentDaoImpl();
		System.out.println(DaoImpl.getStus());
		
		//id��ѯ
		StudentDaoImpl studentDaoImpl=new StudentDaoImpl();
		System.out.println(studentDaoImpl.getStus(2));
		
		//����
		StudentDaoImpl studl=new StudentDaoImpl();
		Student s=new Student();
				s.setId(4);
				s.setName("d");
				s.setSex(1);
				s.setAge(20);
				s.setMyclass("�ͼ�");
				s.setAddress("����");
				s.setPhone(234);
				s.setEmail("123@@");
			studl.insert(s);
		//�޸�
		StudentDaoImpl studl=new StudentDaoImpl();
		Student s=new Student();
				s.setId(2);
				s.setName("d");
				s.setSex(1);
				s.setAge(20);
				s.setMyclass("�ͼ�");
				s.setAddress("����");
				s.setPhone(234);
				s.setEmail("123@@");
			studl.update(s);
			
	
		//ɾ��
		StudentDaoImpl studl=new StudentDaoImpl();
		Student s=new Student();
				s.setId(4);
		studl.delete(4);




		*/
		
		StudentDaoImpl DaoImpl=new StudentDaoImpl();
		System.out.println(DaoImpl.getStus());

	}

}
