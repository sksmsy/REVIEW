package step6_2_methodEx;

import java.util.Scanner;

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
	String arr[] = {"A","B","C","D","E"};
	
	int x =0, y = 0;
	
	void showGame() {
		System.out.println("  1  2  3  4  5");
		for (int i = 0; i < ladder.length; i++) {
			for (int j = 0; j < ladder[i].length; j++) {
				if(ladder[i][j] == 1) {
					if(y == i && x == j) {
						System.out.print("  * ");
					}else {
						System.out.print("  ┣━");
					}
				}else if(ladder[i][j] == 2) {
					if(y == i && x == j) {
						System.out.print(" *");
					}else {
						System.out.print("━┫");
					}
				}else {
					if(y == i && x == j) {
						System.out.print("  *");
					}else {
						System.out.print("  ┃");
					}
				}
			}
			System.out.println();
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print("  "+arr[i] + "");
		}System.out.println();
		
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void choice() {
		System.out.print("입력 [1~5]");
		x = sc.nextInt()-1;
		
		
		while(y < 8) {
			
			if(ladder[y][x] == 0 ) {
				y +=1;
				showGame();
			}
			else if(ladder[y][x] == 1) {
				x +=1;
				showGame();
				y +=1;
				showGame();
			}else if(ladder[y][x] == 2) {
				x -=1;
				showGame();
				y +=1;
				showGame();
			}
			
		}
		
		
		System.out.println("\t>>>>>" + arr[x]);
	}
	
	void run() {
		while(true) {
			
			showGame();
			choice();
		}
	}
	
	
}

public class Ex17 {

	public static void main(String[] args) {
		
		LadderGame lg = new LadderGame();
		
		
		lg.run();
	}

}

