package step6_test;

class Ex1{
	
	void printEvenOrOdd(int x) {
		if(x % 2 == 0) {
			System.out.println("짝");
		}else {
			System.out.println("홀");
		}
		
	}
	
	void sumBetweenValues(int x, int y) {
		
		int tot = 0;
		for (int i = x; i <= y; i++) {
			tot += i;
		}
		System.out.println(tot);
		
	}
	void printPrimeNums(int primeNumber) {
		
		for (int i = 2; i <= primeNumber; i++) {
			int cnt = 0;
			for (int k = 1; k <=i; k++) {
				if(i % k == 0) {
					cnt++;
				}
			}
			if(cnt == 2) {
				System.out.print(i + " ");
			}
		}
	}
	
	
}


public class test1 {
	public static void main(String[] args) {
		
		Ex1 test = new Ex1();
		
		//ex1) a가 홀수인지 짝인지출력
		int a = 19;
		test.printEvenOrOdd(a);
		
		//ex2) x부터 y까지 합을 출력
		int x = 1;
		int y = 10;
		test.sumBetweenValues(x, y);
		
		
		//ex3)숫자 1개를 인자로 사용해서 2부터 인자까지의 소수 전부 출력
		int primeNumber = 20;
		test.printPrimeNums(primeNumber);
		
	}
}
