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
	
	//ϵͳ���
	public static void show() {
		System.out.println("*******************��ӭ��¼ѧ����Ϣ����ϵͳ******************");
		System.out.println("������������������.��¼����2.ע�ᡡ��3.�˳�������������������");
		System.out.println("*****************************************************************");
		System.out.print("��ѡ��");
		while(true) {
				int i=scanner.nextInt();
				if(i==1) {
					System.out.print("�������û�����");
					String username=scanner.next();
					System.out.print("���������룺");
					String psw=scanner.next();
					adi.getAccount(username, psw);
					//ѧ��  ���
					showStudentManager();
					break;
				}else if (i==2) {
					System.out.print("�������û�����");
					String username=scanner.next();
					System.out.print("���������룺");
					String password=scanner.next();
					acc=new Account(username, password);
					adi.insertAccount(acc);
					
				}else if (i==3) {
					System.exit(0);
				}else {
					System.out.print("������ 1 �� 2 �� 3");
				}
			}
	}
	
	
		public static void showStudentManager() {
			System.out.println("***************��ѡ��Ҫ��������Ϣ����Ӧ������***************");
			System.out.println("1.�鿴ѧ����Ϣ	 2.���ѧ����Ϣ	 3.�޸�ѧ����Ϣ	 4.ɾ��ѧ����Ϣ	 5.������һ��    6.�˳�");
			System.out.println("*****************************************************************");
			while(true) {
					System.out.print("��ѡ��");
					int i=scanner.nextInt();
					if(i==1) {
						System.out.println("�鿴ѧ����Ϣ");
						showStudent();
					}
					if (i==2) {
						System.out.println("���ѧ����Ϣ");
						addStudent();
					}
					if (i==3) {
						System.out.println("�޸�ѧ����Ϣ");
						updateAll();
					}
					if (i==4) {
						System.out.println("ɾ��ѧ����Ϣ");
						delectStudent();
					}
					if (i==5) {
						show();
					}
					if (i==6) {
						System.exit(0);
					}
					else {
						System.out.print("������ 1  2 3	4	5	6");
					}
				}
		}


		public static void showStudent() {
			System.out.println("*************************************************************************************");
			System.out.println("������1.�鿴����ѧ����Ϣ��	����2.����id��ѯѧ������	 ����3.������һ�� ����");
			System.out.println("**************************************************************************************");
			while(true){
				System.out.print("��ѡ��:");
				int i = scanner.nextInt();
				if(1 == i){
					System.out.print("��ѡ��:");
					showStudentAll();
				}else if(2 == i){
					System.out.print("��ѡ��:");
					showStudentById();
				}else if(3 == i){
					showStudentManager();
				}else{
					System.out.println("��������!����������!");
				}
			}
		}

		private static void showStudentAll () {
			System.out.println("*********************************��ѯ����ѧ����Ϣ**********************************");
			List<Student> list = sdi.getStus();
			for(Student s : list){
				System.out.println(s);
			}
		}


		private static void showStudentById() {
			System.out.println("*********************************����id��ѯѧ����Ϣ**********************************");
			System.out.println("������Ҫ��ѯ��ѧ��id:");
			int id = scanner.nextInt();
			System.out.println(sdi.getStus(id));
		}

		public static void addStudent(){
			Student stu = new Student();
			System.out.print("������ѧ��id:");
			int id = scanner.nextInt();
			System.out.print("������ѧ������:");
			String name =scanner.next();
			System.out.print("������ѧ���Ա�:");
			String sex =scanner.next();
			System.out.print("������ѧ������");
			int age = scanner.nextInt();
			System.out.print("������ѧ�������꼶������,�м�,�߼���:");
			String myClass =scanner.next();
			System.out.print("������ѧ���ĵ�ַ:");
			String address =scanner.next();
			System.out.print("������ѧ���ֻ���:");
			int phone = scanner.nextInt();
			System.out.print("������ѧ������:");
			String email =scanner.next();
			stu.setId(id);
			stu.setName(name);
			stu.setSex(sex.equals("0") ? 0:1);
			stu.setAge(age);
			stu.setAddress(address);
			stu.setMyclass(myClass.equals("����")?"����":(myClass.equals("�м�")?"�м�":"�߼�"));
			stu.setPhone(phone);
			stu.setEmail(email);
			sdi.insert(stu);
			
			
		}
		

		private static void updateAll() {
			Student stu = new Student();
			System.out.print("������Ҫ�޸ĵ�ѧ��id:");
			int id = scanner.nextInt();
			stu = sdi.getStus(id);
			while(true){
				if(stu.getId() == 0){
					System.out.print("ѧ��id������,����������:");
					id = scanner.nextInt();
					stu = sdi.getStus(id);
				}else{
					break;
				}
			}
			System.out.print("������ѧ������:");
			String name = scanner.next();
			System.out.print("������ѧ���Ա�:");
			String sex =scanner.next();
			System.out.print("������ѧ������:");
			int age = scanner.nextInt();
	
			System.out.print("������ѧ�������꼶������,�м�,�߼���:");
			String myClass = scanner.next();
			System.out.print("������ѧ���ĵ�ַ:");
			String address = scanner.next();
			System.out.print("������ѧ���ֻ���:");
			int phone = scanner.nextInt();
			System.out.print("������ѧ������:");
			String email = scanner.next();
			stu.setId(id);
			stu.setName(name);
			stu.setSex(sex.equals("��") ? 0:1);
			stu.setAge(age);
			stu.setAddress(address);
			stu.setMyclass(myClass.equals("����")?"����":(myClass.equals("�м�")?"�м�":"�߼�"));
			stu.setPhone(phone);
			stu.setEmail(email);
			sdi.update(stu);
		}
		
		
		public static void delectStudent(){
			System.out.println("======================================ɾ��ѧ��==================================");
			System.out.println("������Ҫɾ����ѧ��id:");
			int id = scanner.nextInt();
			sdi.delete(id);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
}
