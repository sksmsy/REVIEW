package step6_test;

import java.util.Random;
import java.util.Scanner;

// # 1 to 18

class Game1to18{
	
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	
	int front[][] = new int[3][3];
	int back[][] = new int[3][3];
	
	int num = 1;
	
	void setGame() {
		
		int num = 1;
		for (int i = 0; i < front.length; i++) {
			for (int j = 0; j < back.length; j++) {
				front[i][j] = num;
				back[i][j] = num+9;
				num++;
			}
		}
	}
	
	void shuffle() {
		
		for (int i = 0; i < 100; i++) {
			int r = ran.nextInt(3);
			int r2 = ran.nextInt(3);
			
			int temp = front[r][r2];
			front[r][r2] = front[0][0];
			front[0][0] = temp;
		}
		
		for (int i = 0; i < 100; i++) {
			int r = ran.nextInt(3);
			int r2 = ran.nextInt(3);
			
			int temp = back[r][r2];
			back[r][r2] = back[0][0];
			back[0][0] = temp;
		}
	}
	
	
	void printGame() {
		System.out.println("["+num+"]");
		for (int i = 0; i < back.length; i++) {
			for (int j = 0; j < back.length; j++) {
				System.out.print(front[i][j]+"\t");
			}
			System.out.println("\n");
		}
	}
	
	
	
	void play () {
		System.out.print("Y >>> ");
		int y = sc.nextInt();
		System.out.print("X >>> ");
		int x = sc.nextInt();
		
		
		if(front[y][x] == num) {
			if(front[y][x] <= 9) {
				front[y][x] = back[y][x];
			}else if(front[y][x] > 9) {
				front[y][x] = 0;
			}
			num++;
		}
	}
	
	void run() {
		setGame();
		shuffle();
		
		while(true) {
			printGame();
			play();
			
			if(num == 19) {
				break;
			}
		}
	}
	
	
}


public class test7 {

	public static void main(String[] args) {

		Game1to18 g1 = new Game1to18();
		
		g1.run();
	}

}
