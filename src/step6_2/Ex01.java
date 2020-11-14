package step6_2;

class TestRe{
	int result;
	
	void plus1(int a, int b) {
		result = a+b;
	}
	
	int plus2(int a, int b) {
		return a+ b;
	}
}

public class Ex01 {
	public static void main(String[] args) {
		
		TestRe tr = new TestRe();
		
		tr.plus1(10, 3);
		System.out.println(tr.result);
		
		int result = tr.plus2(10, 5);
		System.out.println(result);
	}
}
