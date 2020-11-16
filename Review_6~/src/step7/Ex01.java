package step7;

class Product{
	String name;
	int price;
	
}
public class Ex01 {
	public static void main(String[] args) {
		
		
		int arr[] = new int[3];
		int arr2[][] = new int[2][3];
		
		//--------------------------------
		
		Product pr = new Product();
		pr.name = "aaaa";
		pr.price= 10000;
		
		
		Product prList[] = new Product[2];
		prList[0] = new Product();
		prList[1] = new Product();
		
		prList[0].name = "aaaa";
		prList[1].name = "bbbb";
		
		prList[0].price = 1000;
		prList[1].price = 2000;
		
		
	}
	
	
}
