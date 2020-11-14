package step6_2_methodEx;

import java.util.Random;

class Omr{
	Random ran = new Random();
	
	int omr [] = {1,4,3,2,2};
	int me[] = new int[5];
	
	int cnt = 0;
	int scr = 0;
	
	void makeAnswer() {
		for (int i = 0; i < me.length; i++) {
			int r = ran.nextInt(5)+1;
			me[i] = r;
		}
	}
	
	void showAnswer() {
		for (int i = 0; i < me.length; i++) {
			System.out.print(omr[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < me.length; i++) {
			System.out.print(me[i] +" ");
		}
		System.out.println();
	}
	
	void check() {
		for (int i = 0; i < me.length; i++) {
			if(me[i] == omr[i]) {
				System.out.print("O ");
				cnt++;
			}else {
				System.out.print("X ");
			}
		}System.out.println();
		
		scr = cnt * 20;
		System.out.println(scr);
	}
	
	void run() {
		makeAnswer();
		showAnswer();
		check();
	}
}


public class Ex11 {

	public static void main(String[] args) {
		
		Omr o = new Omr();
		
		o.run();
			
	}

}
