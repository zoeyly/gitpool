import java.math.BigInteger;

import com.neusoft.daoimpl.Account_consumerDaoImpl;
import com.neusoft.entity.Account_consumer;

public class test6 {
	
	public static void insertProduct() {
		
		Account_consumer address=new Account_consumer("we", "wedfr", 23456,34, "23er");
		Account_consumerDaoImpl addressDaoImpl=new Account_consumerDaoImpl();
		addressDaoImpl.addAccount_consumerDao(address);
	}
	

	public static void deleteProduct() {
		Account_consumer address=new Account_consumer(4);
		Account_consumerDaoImpl addressDaoImpl=new Account_consumerDaoImpl();
		addressDaoImpl.deleteAccount_consumerDao(address);
	}
	
	public static void changeProduct() {

		Account_consumer address=new Account_consumer(6,"we", "wedfr", 22,2, "23er");
		Account_consumerDaoImpl addressDaoImpl=new Account_consumerDaoImpl();
		addressDaoImpl.changeAccount_consumerDao(address);
	}
	

	
	private static void showProductAll() {
		// TODO Auto-generated method stub
		Account_consumerDaoImpl addressDaoImpl=new Account_consumerDaoImpl();
		addressDaoImpl.showAccount_consumerAll();
	}

	public static void main(String[] args) {
//		
//		insertProduct();
//		deleteProduct();
//		changeProduct();
		showProductAll();
		
//		findCate();
		
	}

}
