import com.neusoft.daoimpl.CateDaoImpl;
import com.neusoft.daoimpl.ProductDaoImpl;
import com.neusoft.entity.Cate;
import com.neusoft.entity.Product;

public class test2 {
	
	public static void insertProduct() {
		Product product=new Product( "ÒÂ·þ", 1,"dvs","sdv",32,42,"wert");
		ProductDaoImpl productDaoImpl=new ProductDaoImpl();
		productDaoImpl.insertProduct(product);
	}
	

	public static void deleteProduct() {
		Product product=new Product( 3);
		ProductDaoImpl productDaoImpl=new ProductDaoImpl();
		productDaoImpl.deleteProduct(product);
	}
	
	public static void changeProduct() {
		Product product=new Product(2, "ÒÂ·þ", 23,"sdvasv","sdv",32,42,"wert");
		ProductDaoImpl productDaoImpl=new ProductDaoImpl();
		productDaoImpl.changeProduct(product);
	}
	

	private static void findCate() {
		// TODO Auto-generated method stub
		Cate cate=new Cate(3);
		CateDaoImpl cateDaoImpl=new CateDaoImpl();
		System.out.println(cateDaoImpl.findCate(cate));
	}
	
	private static void showProductAll() {
		// TODO Auto-generated method stub
		Product product=new Product();
		ProductDaoImpl productDaoImpl=new ProductDaoImpl();
		productDaoImpl.showProductAll();
	}

	public static void main(String[] args) {
		
		insertProduct();
		deleteProduct();
		changeProduct();
		showProductAll();
//		findCate();
		
	}

}
