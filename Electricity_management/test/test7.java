import com.neusoft.daoimpl.Account_consumerDaoImpl;
import com.neusoft.daoimpl.Account_productDaoImpl;
import com.neusoft.entity.Account_consumer;
import com.neusoft.entity.Account_product;

public class test7 {
	
	public static void insertProduct() {
		
		Account_product address=new Account_product("we", "wedfr", 23456,34, "23er");
		Account_productDaoImpl addressDaoImpl=new Account_productDaoImpl();
		addressDaoImpl.addAccount_productDao(address);
	}
	

	public static void deleteProduct() {
		Account_product address=new Account_product (1);
		Account_productDaoImpl addressDaoImpl=new Account_productDaoImpl();
		addressDaoImpl.deleteAccount_productDao(address);
	}
	
	public static void changeProduct() {

		Account_product address=new Account_product(2,"we", "wedfr", 222,222, "23er");
		Account_productDaoImpl addressDaoImpl=new Account_productDaoImpl();
		addressDaoImpl.changeAccount_productDao(address);
	}
	

	
	private static void showProductAll() {
		// TODO Auto-generated method stub
		Account_productDaoImpl addressDaoImpl=new Account_productDaoImpl();
		addressDaoImpl.showAccount_productAll();
	}

	public static void main(String[] args) {
		
//		insertProduct();
		deleteProduct();
		changeProduct();
//		showProductAll();
		
//		findCate();
		
	}

}
