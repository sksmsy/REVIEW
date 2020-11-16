package step6_test;

import java.util.Scanner;

//# 사다리 게임

class LadderGame{
	
	Scanner sc = new Scanner(System.in);
	
	int[][] ladder = { 
			{ 0, 0, 0, 0, 0 }, 
			{ 1, 2, 0, 1, 2 }, 
			{ 0, 1, 2, 0, 0 }, 
			{ 0, 0, 0, 1, 2 }, 
			{ 0, 1, 2, 0, 0 },
			{ 1, 2, 1, 2, 0 }, 
			{ 0, 0, 0, 1, 2 }, 
			{ 0, 0, 0, 0, 0 } 
	};
	
	int x = 0;
	int y = 0;
	
	void printLad() {
		System.out.println(" 1  2  3  4  5");
		for (int i = 0; i < ladder.length; i++) {
			for (int j = 0; j < ladder[i].length; j++) {
				if(ladder[i][j] == 1) {
					if(j == x && i == y) {
						System.out.print(" * ");
					}else {
						System.out.print(" ┣━");						
					}
				}
				else if(ladder[i][j] == 2) {
					if(j == x && i == y) {
						System.out.print(" * ");
					}else {
						System.out.print("━┫ ");						
					}
				}
				else if(ladder[i][j] == 0) {
					if(j == x && i == y) {
						System.out.print(" * ");
					}else {
						System.out.print(" ┃ ");						
					}
				}
			}
			System.out.println();
		}
		System.out.println(" A  B  C  D  E");
		System.out.println("\n");
	}
	
	void choice() {
		System.out.print("[1~5] >>>"); 
		int sel = sc .nextInt();
		
		if(sel == 1) {x = 0;}
		else if(sel == 2) {x=1;}
		else if(sel == 3) {x=2;}
		else if(sel == 4) {x=3;}
		else if(sel == 5) {x=4;}
	}
	
	
	void play() {
		printLad();
		
		while(true) {			
			if(ladder[y][x] == 0) {
				y += 1;
				printLad();
			}
			else if(ladder[y][x] == 1) {
				x += 1;
				printLad();
				y += 1;
				printLad();
			}
			else if(ladder[y][x] == 2) {
				x -= 1;
				printLad();
				y += 1;
				printLad();
			}
			
			if(y == 7) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
	void run() {
		
		printLad();
		
		choice();
		play();
		
		
		
	}
}

public class test8 {

	public static void main(String[] args) {

		LadderGame lg = new LadderGame();
		
		lg.run();
	}

}
