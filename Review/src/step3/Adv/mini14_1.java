package step3.Adv;

import java.util.Scanner;

public class mini14_1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		
		int game[][] = new int[10][10];
		
		int turn = 2;
		int win = 0;
		
		int p1X =0;
		int p1Y =0;
		int p2X =0;
		int p2Y =0;
		
		while(true) {
			System.out.print("   ");
			for (int i = 0; i < game.length; i++) {
				System.out.print((i+1) + " ");
			}System.out.println();
			
			
			for (int i = 0; i < game.length; i++) {
				if(i < 9) {
					System.out.print((i+1) + "  ");
				}else {
					System.out.print((i+1) + " ");
				}
				
				for (int j = 0; j < game.length; j++) {
					System.out.print(game[i][j] + " ");
				}
				System.out.println();
			}
			
			if(win == 1) {
				System.out.println("[p1]승리");
				break;
			}else if(win == 2) {
				System.out.println("[p2]승리");
				break;
			}
			
			
			if(turn % 2 == 0) {
				System.out.print("[p1] Y : ");
				p1Y = scan.nextInt();
				System.out.print("[p1] X : ");
				p1X = scan.nextInt();
				
				if(game[p1Y-1][p1X-1] != 0) {
					System.out.println("이미 놓여진 자리");
					continue;
				}
				
				game[p1Y-1][p1X-1] = 1;
				turn += 1;
				
			} else if(turn % 2 == 1) {
				
				System.out.print("[p1] Y : ");
				p2Y = scan.nextInt();
				System.out.print("[p1] X : ");
				p2X = scan.nextInt();
					
				if(game[p2Y-1][p2X-1] != 0) {
					System.out.println("이미 놓여진 자리");
					continue;
				}
				game[p2Y-1][p2X-1] = 2;
				turn += 1;
			}
			
			
			
			//가로검사 
			
			for (int i = 0; i < game.length; i++) {
				for (int j = 0; j < game.length-4; j++) {
					if(game[i][j] == 1 && game[i][j+1] == 1 && game[i][j+2] == 1 && game[i][j+3] == 1 &&
							game[i][j+4] == 1 ) {
						win = 1;
					}
					else if(game[i][j] == 2 && game[i][j+1] == 2 && game[i][j+2] == 2 && game[i][j+3] == 2 
							&& game[i][j+4] == 2 ) {
						win = 2;
					}
				}
			}
			
			//세로 검사
			
			for (int i = 0; i < game.length-4; i++) {
				for (int j = 0; j < game.length-4; j++) {
					if(game[i][j] == 1 && game[i+1][j] == 1 && game[i+2][j] == 1 && game[i+3][j] == 1
							&& game[i+4][j] == 1) {
						win = 1;
					}
					else if(game[i][j] == 2 && game[i+1][j] == 2 && game[i+3][j] == 2 && game[i+4][j] == 2) {
						win = 2;
					}	
				}
			}
			
			//대각 검사
			
			for (int i = 0; i < game.length-4; i++) {
				for (int j = 0; j < game.length-4; j++) {
					if(game[i][j] == 1 && game[i+1][j+1] == 1 && game[i+2][j+2] == 1 && game[i+3][j+3] == 1 &&
							game[i+4][j+4] == 1) {
						win = 1;
					}
					else if(game[i][j] == 2 && game[i+1][j+1] == 2 && game[i+2][j+2] == 2 && game[i+3][j+3] == 2 &&
							game[i+4][j+4] == 2) {
						win = 2;
					}
				}
			}
			
			
			for (int i = 9; i > game.length - 7; i--) {
				for (int j = 0; j < game.length-4; j++) {
					if(game[i][j] == 1 && game[i-1][j+1] == 1 && game[i-2][j+2] == 1 && game[i-3][j+3] == 1 &&
							game[i-4][j+4] == 1 ) {
						win = 1;
					}
					else if(game[i][j] ==2 && game[i-1][j+1] == 2 && game[i-2][j+2] == 2 && game[i-3][j+3] == 2 &&
							game[i-4][j+4] == 2 ) {
						win = 2;
					}	
				}
			}
			
			
			
		}
	}

}
