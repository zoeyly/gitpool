import java.math.BigInteger;

import com.neusoft.daoimpl.CateDaoImpl;
import com.neusoft.daoimpl.OrderinfoDaoImpl;
import com.neusoft.daoimpl.ProductDaoImpl;
import com.neusoft.entity.Cate;
import com.neusoft.entity.Orderinfo;
import com.neusoft.entity.Product;

public class test4 {
	
	public static void insertProduct() {
		BigInteger bigInteger=new BigInteger("765432");
		Orderinfo product=new  Orderinfo("wcragva", 23525, 235, 34,3243, 235, "23");
		OrderinfoDaoImpl productDaoImpl=new OrderinfoDaoImpl();
		productDaoImpl.addOrderinfo(product);
	}
	

	public static void deleteProduct() {
		Orderinfo product=new Orderinfo( 3);
		OrderinfoDaoImpl productDaoImpl=new OrderinfoDaoImpl();
		productDaoImpl.deleteOrderinfo(product);
	}
	
	public static void changeProduct() {
		BigInteger bigInteger=new BigInteger("356456");
		Orderinfo product=new  Orderinfo(2,"qqqq", 23525, 235, 3,34, 235, "qqqq");
		OrderinfoDaoImpl productDaoImpl=new OrderinfoDaoImpl();
		productDaoImpl.changeOrderinfo(product);
	}
	

	private static void findCate() {
		// TODO Auto-generated method stub
		Cate cate=new Cate(3);
		CateDaoImpl cateDaoImpl=new CateDaoImpl();
		System.out.println(cateDaoImpl.findCate(cate));
	}
	
	private static void showProductAll() {
		// TODO Auto-generated method stub
		OrderinfoDaoImpl orderinfoDaoImpl=new OrderinfoDaoImpl();
		orderinfoDaoImpl.showOrderinfoAll();
	}

	public static void main(String[] args) {
		
//		insertProduct();
//		deleteProduct();
//		changeProduct();
		showProductAll();
//		findCate();
		
	}

}
