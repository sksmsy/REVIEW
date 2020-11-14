package step6_3_method2;

class TestReturn2{
	
	
	int result;
	void plus1(int a, int b) {
		result = a + b;
	}
	
	int plus2 (int a , int b) {
		
		return a + b;
	}
	
}
public class Ex19 {

	public static void main(String[] args) {
	
		
		
		
		TestReturn2 t2 = new TestReturn2();
		
		t2.plus1(10 , 3 );
		System.out.println(t2.result);
			
		System.out.println("-----------------------");
		int result = t2.plus2(10, 3);
		System.out.println(result);
	}

}
