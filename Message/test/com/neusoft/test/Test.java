package com.neusoft.test;

import com.neusoft.dao.DaoFactory;
import com.neusoft.dao.MessageBoardDao;
import com.neusoft.entity.MessageBoard;

public class Test {

	public static void main(String[] args) {
		showMsg();
		//System.out.println("java\u2122");
	}
	
	public static void testAdd() {
		MessageBoardDao mbd = DaoFactory.getInstance("messagedao", MessageBoardDao.class);
		MessageBoard mb = new MessageBoard("Ð¡°¡","asdwasd","asdasd","asasa");
		System.out.println(mbd.insertMessage(mb));
	}
	
	public static void showMsg(){
		MessageBoardDao mbd = DaoFactory.getInstance("messagedao", MessageBoardDao.class);
		System.out.println(mbd.showMsgAll());
	}
}
