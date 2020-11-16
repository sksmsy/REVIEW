package step6_1;

class Ex5{
	
	void set_value(int a) {
		
		a = 100;
	}
}
public class Ex05 {
	public static void main(String[] args) {
		
		int a  = 56;
		Ex5 e5= new Ex5();
		
		
		//메서드는 값을 복사하는것이기 때문에 main안의 a에 영향이 없다
		e5.set_value(a);
		System.out.println(a);
		
		
		System.out.println("---------------------");
		
		
		//같은 구조
		int b = 20;
		int c = b;
		c = 100;
		System.out.println(b);
	}
}
