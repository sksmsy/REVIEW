package step6_1_method1;

class Test2{
	
	void printSum() {
		int tot = 0;
		for (int i = 1; i <= 5; i++) {
			tot += i;
		}
		System.out.println(tot);
	}
}

public class Ex02 {

	public static void main(String[] args) {
		
		Test2 t = new Test2();
		
		t.printSum();
	}

}
