package step3.Adv;

import java.util.Random;
import java.util.Scanner;

public class mini15_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		
		final int SIZE = 6;
		final int WALL = 9;
		final int BALL = 3;
		final int PLAYER = 2;
		
		int game[][] = new int[SIZE][SIZE];
		
		int ballY = 0;
		int ballX = 0;
		int goalY = 0;
		int goalX = 0;
		int pX = 0;
		int pY = 0;
		
		System.out.print("벽 개수 : ");
		int wallCnt = scan.nextInt();
		
		//wall
		while(wallCnt != 0) {
			int rX = ran.nextInt(SIZE);
			int rY = ran.nextInt(SIZE);
			
			if(game[rY][rX] == 0) {
				game[rY][rX] = WALL;
				wallCnt -= 1;
			}
		}
		
		//ball 
		while(true) {
			int rX = ran.nextInt(SIZE-2) +1;
			int rY = ran.nextInt(SIZE-2) +1;
			
			if(game[rY][rX] == 0) {
				game[rY][rX] = BALL;
				ballY = rY;
				ballX = rX;
				break;
			}
		}
		
		//골대
		while(true) {
			int rX = ran.nextInt(SIZE);
			int rY = ran.nextInt(SIZE);
			
			if(game[rY][rX] == 0) {
				game[rY][rX] = 5;
				goalY = rY;
				goalX = rX;
				break;
			}
		}
		
		
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game.length; j++) {
				System.out.print(game[i][j] + " ");
			}
			System.out.println();
		}
		while(true) {
			System.out.println("플레이어 위치 설정");
			System.out.print("Y : ");
			pY = scan.nextInt();
			System.out.print("X : ");
			pX = scan.nextInt();
		
			if(game[pY][pX] == 0) {
				game[pY][pX] = PLAYER;
				break;
			}
		}
		//게임 시작
		while(true) {
			

			System.out.println("==================");
			for (int i = 0; i < game.length; i++) {
				for (int j = 0; j < game.length; j++) {
					if(game[i][j] == BALL) {
						System.out.print("공 ");
					}else if(game[i][j] == PLAYER) {
						System.out.print("옷 ");
					}else if(game[i][j] == 5) {
						System.out.print("골 ");
					}else if(game[i][j] == WALL) {
						System.out.print("벽 ");
					}else {
						System.out.print(game[i][j] + " ");
					}
				}
				System.out.println();
			}
			
			if(ballY == goalY && ballX == goalX) {
				System.out.println("게임종료");
				break;
			}
			
			System.out.print("플레이어 이동 : ");
			int mv = scan.nextInt();
			
			int xx = pX;
			int yy = pY;
			
			if(mv == 2) {
				yy = yy +1;
			}else if(mv == 4) {
				xx = xx -1;
			}else if(mv == 6) {
				xx = xx + 1;
			}else if(mv == 8) {
				yy = yy -1 ;
			}
			// 예외처리
			if(SIZE <= xx || xx < 0) continue;
			if(SIZE <= yy || yy < 0) continue;
			if(game[yy][xx] != 0 && game[yy][xx] != BALL) continue;
			
			//ball 
			if(game[yy][xx] == BALL) {
				
				int xxx = ballX;
				int yyy = ballY;
				
				if(mv == 2) {
					yyy = yyy + 1;
				}else if(mv == 4) {
					xxx = xxx -1;
				}else if(mv == 6) {
					xxx = xxx +1;
				}else if(mv == 8) {
					yyy = yyy -1;
				}
				
				if(SIZE <= xxx || xxx < 0) continue;
				if(SIZE <= yyy || yyy < 0) continue;
				if(game[yyy][xxx] != 0 && game[yyy][xxx] !=5) continue;
				
				game[ballY][ballX] = 0;
				ballY = yyy;
				ballX = xxx;
				game[ballY][ballX] = BALL;
				
				
				
			}
			game[pY][pX] = 0;
			pY = yy;
			pX = xx;
			game[pY][pX] = PLAYER;
		}
		
	}

}
