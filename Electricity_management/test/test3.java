import com.neusoft.daoimpl.CateDaoImpl;
import com.neusoft.daoimpl.ProductDaoImpl;
import com.neusoft.daoimpl.RuleDaoImpl;
import com.neusoft.entity.Cate;
import com.neusoft.entity.Product;
import com.neusoft.entity.Rule;

public class test3 {
	
	public static void insertProduct() {
		Rule product=new 		Rule( 42,"wert");
		RuleDaoImpl productDaoImpl=new RuleDaoImpl();
		productDaoImpl.addRule(product);
	}
	

	public static void deleteProduct() {
		Rule product=new 		Rule( 2);
		RuleDaoImpl productDaoImpl=new RuleDaoImpl();
		productDaoImpl.deleteRule(product);
	}
	
	public static void changeProduct() {
		Rule product=new Rule(3,3242,"wert");
		RuleDaoImpl productDaoImpl=new RuleDaoImpl();
		productDaoImpl.changeRule(product);
	}
	

	private static void findCate() {
		// TODO Auto-generated method stub
		Cate cate=new Cate(3);
		CateDaoImpl cateDaoImpl=new CateDaoImpl();
		System.out.println(cateDaoImpl.findCate(cate));
	}
	
	private static void showProductAll() {
		// TODO Auto-generated method stub
		RuleDaoImpl productDaoImpl=new RuleDaoImpl();
		productDaoImpl.showRuleAll();
	}

	public static void main(String[] args) {
		
//		insertProduct();
//		deleteProduct();
//		changeProduct();
		showProductAll();
//		findCate();
		
	}

}
