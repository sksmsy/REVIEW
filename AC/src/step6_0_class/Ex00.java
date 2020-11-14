package step6_0_class;

public class Ex00 {
	public static void main(String[] args) {
		
		// 증감연산자
		
		// a = a + 1
		// a += 1
		
		// a ++ (후위연산) 연산자가 포함된 식이 종료된 후 -> 실행
		// ++ a (전위연산) 연산자가 포함된 식이 시작되지 전 -> 실행
		
		int a = 10;
		int b = 20;
		int c;
		
		c = a ++ +b;
		System.out.println(c); 			// 30
		System.out.println("a : " + a); // a : 11
		
		c = ++ a + b;
		System.out.println(c); 			// 32
		System.out.println("a : " + a); // a : 12 
		
		
	}

}
