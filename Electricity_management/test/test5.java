import com.neusoft.daoimpl.AddressDaoImpl;
import com.neusoft.entity.Address;

public class test5 {
	
	public static void insertProduct() {
		Address address=new Address ("wert", "qwe", "wee");
		AddressDaoImpl addressDaoImpl=new AddressDaoImpl();
		addressDaoImpl.addAddress(address);
	}
	

	public static void deleteProduct() {
		Address address=new Address(1);
		AddressDaoImpl addressDaoImpl=new AddressDaoImpl();
		addressDaoImpl.deleteAddress(address);
	}
	
	public static void changeProduct() {
		Address address=new Address (2,"222", "222", "w222ee");
		AddressDaoImpl addressDaoImpl=new AddressDaoImpl();
		addressDaoImpl.changeAddress(address);
	}
	

	
	private static void showProductAll() {
		// TODO Auto-generated method stub
		AddressDaoImpl addressDaoImpl=new AddressDaoImpl();
		addressDaoImpl.showAddressAll();
	}

	public static void main(String[] args) {
		
//		insertProduct();
		deleteProduct();
//		changeProduct();
//		showProductAll();
//		findCate();
		
	}

}
