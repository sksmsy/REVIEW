package step6_2_methodEx;

class TestEx1 {
	void printEvenOrOdd(int x) {
		
		if(x % 2 == 0) {
			System.out.println("짝");
		}else {
			System.out.println("홀");
		}
		
	}
	
	void subBetweenValues(int x, int y) {
		int tot =0;
		for (int i = x; i <= y; i++) {
			tot += i;
		}
		System.out.println(tot);
	}
	
	void printPrimeNums(int primeNumber) {
		
		for (int i = 2; i <= primeNumber; i++) {
			int cnt = 0;
			for (int j = 1; j <= i ; j++) {
				if(i % j == 0) {
					cnt ++;
				}
			}
			
			if(cnt == 2) {
				System.out.print(i +  " ");
			}
		}
	}
}

public class Ex08 {

	public static void main(String[] args) {

		
		TestEx1 t = new TestEx1();
		
		//ex1) a가 홀수인지 짝수인지 출력
		int a = 19;
		t.printEvenOrOdd(a);
		
		System.out.println("---------------------");
		
		//ex2) x부터 y까지의 합을 출력하는 메서드
		int x = 1;
		int y = 10;
		t.subBetweenValues(x, y);
		
		System.out.println("---------------------");
		
		//ex3) 숫자 1개를 인자로 사용해서 2부터 인자까지의 소수 출력
		
		int primeNumber = 20;
		t.printPrimeNums(primeNumber);
		
	}

}
