import com.neusoft.daoimpl.Account_productDaoImpl;
import com.neusoft.daoimpl.ShoppinginfoDaoImpl;
import com.neusoft.entity.Account_product;
import com.neusoft.entity.Shoppinginfo;

public class test8 {
	
	public static void insertProduct() {
		
		Shoppinginfo address=new Shoppinginfo(1, "a", 10, 10);
		ShoppinginfoDaoImpl daoImpl=new ShoppinginfoDaoImpl();
		daoImpl.insertShoppinginfo(address);
		}
	

	public static void deleteProduct() {
		Shoppinginfo address=new Shoppinginfo(2);
		ShoppinginfoDaoImpl daoImpl=new ShoppinginfoDaoImpl();
		daoImpl.deleteShoppinginfo(address);
	}
	
	public static void changeProduct() {
		Shoppinginfo address=new Shoppinginfo(1, 2,"a", 10, 10);
		ShoppinginfoDaoImpl daoImpl=new ShoppinginfoDaoImpl();
		daoImpl.changeShoppinginfo(address);
	}
	

	
	private static void showProductAll() {
		// TODO Auto-generated method stub
		ShoppinginfoDaoImpl daoImpl=new ShoppinginfoDaoImpl();
		daoImpl.showShoppinginfoAll();
	}

	public static void main(String[] args) {
		
//		insertProduct();
//		deleteProduct();
//		changeProduct();
		showProductAll();
		
//		findCate();
		
	}

}
