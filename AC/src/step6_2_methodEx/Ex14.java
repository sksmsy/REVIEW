package step6_2_methodEx;

import java.util.Random;
import java.util.Scanner;

class MemoryGame{
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	
	int front[] = {1,1,2,2,3,3,4,4,5,5};
	int back[] = new int [10];
	
	int cnt = 0;
	
	void shuffle(){
		for (int i = 0; i < 100; i++) {
			int r = ran.nextInt(front.length-1);
			
			int temp = front[0];
			front[0] = front[r];
			front[r] = temp;
		}
	}
	
	void show() {
		
		for (int i = 0; i < front.length; i++) {
			System.out.print(front[i] + " ");
		}System.out.println();
		for (int i = 0; i < back.length; i++) {
			if(back[i] == 0) {
				System.out.print("X ");
			}else {
				System.out.print(back[i] + " ");				
			}
		}System.out.println();
	}
	
	void check(int x, int y) {
	
	}
	
	void choice() {
		System.out.println("idx1 : ");
		int idx1 = sc.nextInt();
		System.out.println("idx2 : ");
		int idx2 = sc.nextInt();
		
		if(front[idx1] == front[idx2]) {
			back[idx1] = front[idx1];
			back[idx2] = front[idx2];
			cnt++;
		}
		
		
	}
	
	void run() {
		shuffle();
		while(true) {
			
			show();
			
			
			if(cnt == 5) break;
			
			choice();
		}
			
	}
	
}

public class Ex14 {

	public static void main(String[] args) {
		MemoryGame mg = new MemoryGame();
		
		
		mg.run();
	}

}
