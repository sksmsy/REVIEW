package step6_test;

import java.util.Random;

class Ex2{
	Random ran = new Random();
	
	int [] omr = {1,3,4,2,5};
	int [] answer = new int[5];
	
	int cnt = 0;
	int scr = 0;
	
	void my_answer() {
		for (int i = 0; i < answer.length; i++) {
			int r = ran.nextInt(5)+1;
			
			answer[i] = r;
		}
		
	}
	
	
	void check() {
		
		for (int i = 0; i < answer.length; i++) {
			if(answer[i] == omr[i]) {
				System.out.print("O ");
				cnt++;
			}else {
				System.out.print("X ");
			}
		}System.out.println();
		scr = cnt * 20;
		System.out.println(scr);
	}
	
	void print() {
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i]+ " ");
		}
		System.out.println();
		for (int i = 0; i < answer.length; i++) {
			System.out.print(omr[i]+ " ");
		}
		System.out.println();
	}
	
	void run() {
		
		my_answer();
		print();
		check();
	}
	
}

public class test2 {

	public static void main(String[] args) {

		Ex2 e2 = new Ex2();
		
		e2.run();
	}

}
