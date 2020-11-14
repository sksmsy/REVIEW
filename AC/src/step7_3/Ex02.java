package step7_3;

class Product{
	
	String name;
	int price;
	Product(){
		name ="박스";
		price =  1000;
		System.out.println("기본생성자");
	}
	
	Product(String n , int p ){
		name = n; price = p;
	}
	
	void printProduct() {
		System.out.println(name + " : " + price);
	}
}

public class Ex02 {
		// 생성자 오버로딩 
		// 생성자도 메서드이기때문에 같은이름으로 여러개 만들수있다.
		// 단 다른 메서드 와 마찬가지로 전달되는 인자값을 서로 다르게 하면된다.

	public static void main(String[] args) {

		Product p = new Product(); //기본 생성자 호출
		p.printProduct();
		Product p1 = new Product("aaaaa",2000);
		p1.printProduct();
		
		
	}

}
