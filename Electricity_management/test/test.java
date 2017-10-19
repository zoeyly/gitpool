import com.neusoft.daoimpl.CateDaoImpl;
import com.neusoft.entity.Cate;

public class test {
	
	public static void insertCate() {
		Cate cate=new Cate( "ÒÂ·þ", 1);
		CateDaoImpl cateDaoImpl=new CateDaoImpl();
		cateDaoImpl.insertCate(cate);
	}
	
	public static void deleteCate() {
		Cate cate=new Cate( 4);
		CateDaoImpl cateDaoImpl=new CateDaoImpl();
		cateDaoImpl.deleteCate(cate);
	}
	
	public static void changeCate() {
		Cate cate=new Cate(3,"ÊÖ»ú",1 );
		CateDaoImpl cateDaoImpl=new CateDaoImpl();
		cateDaoImpl.changeCate(cate);
	}
	

	private static void findCate() {
		// TODO Auto-generated method stub
		Cate cate=new Cate(3);
		CateDaoImpl cateDaoImpl=new CateDaoImpl();
		System.out.println(cateDaoImpl.findCate(cate));
	}
	
	private static void showCateAll() {
		// TODO Auto-generated method stub
		Cate cate=new Cate(3);
		CateDaoImpl cateDaoImpl=new CateDaoImpl();
		System.out.println(cateDaoImpl.showCateAll());
	}

	public static void main(String[] args) {
		
//		insertCate();
		 
//		deleteCate();
		
//		changeCate();
//		findCate();
		showCateAll();
		
	}

}
