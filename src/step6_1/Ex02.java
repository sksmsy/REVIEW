package step6_1;

class Ex2{
	
	void printSum() {
		int tot = 0;
		for (int i = 0; i <= 5 ; i++) {
			tot += i;
		}
		System.out.println(tot);
	}
}

public class Ex02 {
	public static void main(String[] args) {
		
		Ex2 e = new Ex2();
		
		e.printSum();
		
	}
}
