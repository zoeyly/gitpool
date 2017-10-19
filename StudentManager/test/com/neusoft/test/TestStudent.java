package com.neusoft.test;

import java.util.List;
import java.util.Scanner;

import com.neusoft.dao.impl.AccountDaoImpl;
import com.neusoft.dao.impl.StudentDaoImpl;
import com.neusoft.entity.Account;
import com.neusoft.entity.Student;

public class TestStudent {
		static Scanner scanner=new Scanner(System.in);
		static AccountDaoImpl adi=new AccountDaoImpl();
		static StudentDaoImpl sdi=new StudentDaoImpl();
		static Account acc=new Account();
	
	public static void main(String[] args) {

		show();
	}
	
	//系统面板
	public static void show() {
		System.out.println("*******************欢迎登录学生信息管理系统******************");
		System.out.println("　　　　　　　　１.登录　　2.注册　　3.退出　　　　　　　　　");
		System.out.println("*****************************************************************");
		System.out.print("请选择：");
		while(true) {
				int i=scanner.nextInt();
				if(i==1) {
					System.out.print("请输入用户名：");
					String username=scanner.next();
					System.out.print("请输入密码：");
					String psw=scanner.next();
					adi.getAccount(username, psw);
					//学生  面板
					showStudentManager();
					break;
				}else if (i==2) {
					System.out.print("请输入用户名：");
					String username=scanner.next();
					System.out.print("请输入密码：");
					String password=scanner.next();
					acc=new Account(username, password);
					adi.insertAccount(acc);
					
				}else if (i==3) {
					System.exit(0);
				}else {
					System.out.print("请输入 1 或 2 或 3");
				}
			}
	}
	
	
		public static void showStudentManager() {
			System.out.println("***************请选择要操作的信息所对应的数字***************");
			System.out.println("1.查看学生信息	 2.添加学生信息	 3.修改学生信息	 4.删除学生信息	 5.返回上一级    6.退出");
			System.out.println("*****************************************************************");
			while(true) {
					System.out.print("请选择：");
					int i=scanner.nextInt();
					if(i==1) {
						System.out.println("查看学生信息");
						showStudent();
					}
					if (i==2) {
						System.out.println("添加学生信息");
						addStudent();
					}
					if (i==3) {
						System.out.println("修改学生信息");
						updateAll();
					}
					if (i==4) {
						System.out.println("删除学生信息");
						delectStudent();
					}
					if (i==5) {
						show();
					}
					if (i==6) {
						System.exit(0);
					}
					else {
						System.out.print("请输入 1  2 3	4	5	6");
					}
				}
		}


		public static void showStudent() {
			System.out.println("*************************************************************************************");
			System.out.println("　　　1.查看所有学生信息　	　　2.根据id查询学生姓名	 　　3.返回上一层 　　");
			System.out.println("**************************************************************************************");
			while(true){
				System.out.print("请选择:");
				int i = scanner.nextInt();
				if(1 == i){
					System.out.print("请选择:");
					showStudentAll();
				}else if(2 == i){
					System.out.print("请选择:");
					showStudentById();
				}else if(3 == i){
					showStudentManager();
				}else{
					System.out.println("输入有误!请重新输入!");
				}
			}
		}

		private static void showStudentAll () {
			System.out.println("*********************************查询所有学生信息**********************************");
			List<Student> list = sdi.getStus();
			for(Student s : list){
				System.out.println(s);
			}
		}


		private static void showStudentById() {
			System.out.println("*********************************根据id查询学生信息**********************************");
			System.out.println("请输入要查询的学生id:");
			int id = scanner.nextInt();
			System.out.println(sdi.getStus(id));
		}

		public static void addStudent(){
			Student stu = new Student();
			System.out.print("请输入学生id:");
			int id = scanner.nextInt();
			System.out.print("请输入学生姓名:");
			String name =scanner.next();
			System.out.print("请输入学生性别:");
			String sex =scanner.next();
			System.out.print("请输入学生年龄");
			int age = scanner.nextInt();
			System.out.print("请输入学生所属年级（初级,中级,高级）:");
			String myClass =scanner.next();
			System.out.print("请输入学生的地址:");
			String address =scanner.next();
			System.out.print("请输入学生手机号:");
			int phone = scanner.nextInt();
			System.out.print("请输入学生邮箱:");
			String email =scanner.next();
			stu.setId(id);
			stu.setName(name);
			stu.setSex(sex.equals("0") ? 0:1);
			stu.setAge(age);
			stu.setAddress(address);
			stu.setMyclass(myClass.equals("初级")?"初级":(myClass.equals("中级")?"中级":"高级"));
			stu.setPhone(phone);
			stu.setEmail(email);
			sdi.insert(stu);
			
			
		}
		

		private static void updateAll() {
			Student stu = new Student();
			System.out.print("请输入要修改的学生id:");
			int id = scanner.nextInt();
			stu = sdi.getStus(id);
			while(true){
				if(stu.getId() == 0){
					System.out.print("学生id不存在,请重新输入:");
					id = scanner.nextInt();
					stu = sdi.getStus(id);
				}else{
					break;
				}
			}
			System.out.print("请输入学生姓名:");
			String name = scanner.next();
			System.out.print("请输入学生性别:");
			String sex =scanner.next();
			System.out.print("请输入学生年龄:");
			int age = scanner.nextInt();
	
			System.out.print("请输入学生所属年级（初级,中级,高级）:");
			String myClass = scanner.next();
			System.out.print("请输入学生的地址:");
			String address = scanner.next();
			System.out.print("请输入学生手机号:");
			int phone = scanner.nextInt();
			System.out.print("请输入学生邮箱:");
			String email = scanner.next();
			stu.setId(id);
			stu.setName(name);
			stu.setSex(sex.equals("男") ? 0:1);
			stu.setAge(age);
			stu.setAddress(address);
			stu.setMyclass(myClass.equals("初级")?"初级":(myClass.equals("中级")?"中级":"高级"));
			stu.setPhone(phone);
			stu.setEmail(email);
			sdi.update(stu);
		}
		
		
		public static void delectStudent(){
			System.out.println("======================================删除学生==================================");
			System.out.println("请输入要删除的学生id:");
			int id = scanner.nextInt();
			sdi.delete(id);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
}
