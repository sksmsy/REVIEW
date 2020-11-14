package step6_3_method2;

class TestReturn1{
	void loop1() {
		for (int i = 0; i < 10; i++) {
			if( i == 5) {
				System.out.println("close");
				break;
			}
			System.out.println("loop1 == > i : " + i);
		}
		System.out.println("loop1");
	}
	
	void loop2() {
		for (int i = 0; i < 10; i++) {
			if(i == 5) {
				System.out.println("close");
				return;
			}
			
			System.out.println("loop2 ==> i : " + i);
		}
		System.out.println("loop2");
	}
	
	
	
}

public class Ex18 {

	public static void main(String[] args) {

		
		TestReturn1 t1 = new TestReturn1();
		t1.loop1();
		System.out.println("-------------------------------");
		t1.loop2();
		
		
	}

}
