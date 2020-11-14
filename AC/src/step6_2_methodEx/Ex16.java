package step6_2_methodEx;

import java.util.Random;
import java.util.Scanner;

class To50{
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	
	int front [][] = new int[3][3];
	int back [][] = new int[3][3];
	
	int num = 1;
	
	void setGame() {
		
		int k = 1;
		for (int i = 0; i < back.length; i++) {
			for (int j = 0; j < back.length; j++) {
				front[i][j] = k;
				back[i][j] = k+9;
				k++;
			}
		}
		
		for (int i = 0; i < back.length; i++) {
			for (int j = 0; j < back.length; j++) {
				int r = ran.nextInt(3);
				int r2 = ran.nextInt(3);
				
				int temp = front[0][0];
				front[0][0] = front[r][r2];
				front [r][r2] = temp;
				
				
				temp = back[0][0];
				back[0][0] = back[r][r2];
				back[r][r2] = temp;
				
			}
		}
	}
	
	
	void view() {
		
		System.out.println("["+num+"]");
		for (int i = 0; i < back.length; i++) {
			for (int j = 0; j < back.length; j++) {
				System.out.print(front[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	void check() {
		
		System.out.print("입력(Y) : ");
		int y = sc.nextInt();
		System.out.print("입력(X) : ");
		int x = sc.nextInt();
		
		if(num == front[y][x]) {
			if(num < 10) {
				front[y][x] = back[y][x];
			}else {
				front[y][x] = 0;
			}
			num++;
		}
	}
	
	void run() {

		setGame();
		
		while(num < 19) {
			
			view();
			check();
		}
	}
	
}

public class Ex16 {

	public static void main(String[] args) {
		
		To50 to = new To50();
		
		
		to.run();
		
		
	}

}
